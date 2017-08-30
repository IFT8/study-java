package com.comodin.basic.util.db.rws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DynamicDataSourceTransactionProcessor implements BeanPostProcessor {
    private final Log log = LogFactory.getLog(DynamicDataSource.DYNAMIC_DATA_SOURCE_LOG_PACKAGE_NAME);

    private boolean forceChoiceReadWhenWrite = false;
    private Map<String, Boolean> writeMethodMap = new HashMap<>();

    /**
     * 当之前操作是写的时候，是否强制从从库读
     * 默认（false） 当之前操作是写，默认强制从写库读
     *
     * @param forceChoiceReadWhenWrite //
     */
    public void setForceChoiceReadWhenWrite(boolean forceChoiceReadWhenWrite) {
        this.forceChoiceReadWhenWrite = forceChoiceReadWhenWrite;
    }

    public Object determineMasterOrSlaveDB(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        String strInfo = "determineMasterOrSlaveDB ==> MethodName: " + methodName;
        if (log.isDebugEnabled()) {
            log.debug(strInfo);
        }

        //if (isChoiceMasterDB(methodName)) {
        //
        //    String dbContextTypeBefore = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
        //
        //    DynamicDataSourceHolder.setDbTypeMaster();
        //
        //    String dbContextTypeAfter = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
        //    log.info(String.format("%s dbContextType Before:%s <===> After:%s", strInfo, dbContextTypeBefore, dbContextTypeAfter));
        //} else {
        //    String dbContextTypeBefore = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
        //
        //    DynamicDataSourceHolder.setDbTypeSlave();
        //
        //    String dbContextTypeAfter = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
        //    log.info(String.format("%s dbContextType Before:%s <===> After:%s", strInfo, dbContextTypeBefore, dbContextTypeAfter));
        //}
        if (methodName.startsWith("getTaskWithClientInternalIdByDriver") || methodName.startsWith("selectByDriverUsername")) {
            String dbContextTypeBefore = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();

            DynamicDataSourceHolder.setDbTypeSlave();

            String dbContextTypeAfter = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
            if (log.isDebugEnabled()) {
                log.debug(String.format("%s dbContextType Before:%s <===> After:%s", strInfo, dbContextTypeBefore, dbContextTypeAfter));
            }
        } else {
            String dbContextTypeBefore = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();

            DynamicDataSourceHolder.setDbTypeMaster();

            String dbContextTypeAfter = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
            if (log.isDebugEnabled()) {
                log.debug(String.format("%s dbContextType Before:%s <===> After:%s", strInfo, dbContextTypeBefore, dbContextTypeAfter));
            }
        }

        try {
            return pjp.proceed();
        } finally {
            String dbContextTypeBefore = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
            DynamicDataSourceHolder.clearDBType();
            String dbContextTypeAfter = (DynamicDataSourceHolder.getContextHolder().get() == null) ? " null" : DynamicDataSourceHolder.getContextHolder().get().name();
            if (log.isDebugEnabled()) {
                log.debug(String.format("%s clearDBType Before:%s <===> After:%s", strInfo, dbContextTypeBefore, dbContextTypeAfter));
            }
        }
    }

    private boolean isChoiceMasterDB(String invocationMethodName) {
        String bestNameMatch = null;
        for (String mappedName : this.writeMethodMap.keySet()) {
            if (PatternMatchUtils.simpleMatch(mappedName, invocationMethodName)) {
                bestNameMatch = mappedName;
                break;
            }
        }
        //表示应该选择读库
        if (bestNameMatch == null) {
            return false;
        }
        Boolean isForceChoiceRead = writeMethodMap.get(bestNameMatch);
        if (isForceChoiceRead == Boolean.TRUE) {
            return false;
        }
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof NameMatchTransactionAttributeSource)) {
            return bean;
        }

        try {
            NameMatchTransactionAttributeSource transactionAttributeSource = (NameMatchTransactionAttributeSource) bean;
            Field nameMapField = ReflectionUtils.findField(NameMatchTransactionAttributeSource.class, "nameMap");
            nameMapField.setAccessible(true);
            Map<String, TransactionAttribute> nameMap = (Map<String, TransactionAttribute>) nameMapField.get(transactionAttributeSource);

            nameMap.forEach((methodName, transactionAttribute) -> {
                RuleBasedTransactionAttribute attr = (RuleBasedTransactionAttribute) transactionAttribute;
                if (attr.isReadOnly()) {
                    return;
                }

                Boolean isForceChoiceRead = Boolean.FALSE;
                if (forceChoiceReadWhenWrite) {
                    //不管之前操作是写，默认强制从读库读 （设置为 NOT_SUPPORTED 即可） NOT_SUPPORTED会挂起之前的事务
                    attr.setPropagationBehavior(Propagation.NOT_SUPPORTED.value());
                    isForceChoiceRead = Boolean.TRUE;
                }

                if (log.isDebugEnabled()) {
                    log.debug("write transaction process  method:{} force read:{}" + " " + methodName + " " + isForceChoiceRead);
                }
                writeMethodMap.put(methodName, isForceChoiceRead);
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("process read/write transaction error", e);
        }
        return bean;
    }
}
