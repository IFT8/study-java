package cn.assupg.study.study08;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * <pre>
 * @Conditional 基于条件的自动配置，一般配合 Condition 接口一起使用，只有接口（一个或多个）的实现类返回true，才装配，否则不装配。
 * 它可以用在方法上面，则只对该方法起作用，还可以用在类上面，则对该类下面的所有方法起作用。
 * @Conditional 的参数可以是数组形式，但必需都返回true才装配。
 *
 * spring org.springframework.boot.autoconfigure.condition.* 下有许多官方提供的条件的自动装置使用。
 * ConditionalOnBean                根据窗口中是否存在某个bean，或者是某一个注解，才装配，否则不装配。 可以是bean的名字，或者bean的类型
 * ConditionalOnMissingBean         与ConditionalOnBean相反，不存在的时候，才装配。
 * OnBeanCondition
 *
 * ConditionalOnProperty            当某个属性等于某个值的时候，才装配。若或某个资源文件名等于什么的时候，才装配。@ConditionalOnProperty(name = "runnable.enabled", havingValue = "true",matchIfMissing = true)
 * OnPropertyCondition
 *
 * ConditionalOnClass               当classpath下慧某一个类的时候，才装配。否则不装配
 * ConditionalOnMissingClass        与ConditionalOnClass相反。
 * OnClassCondition
 *
 * ConditionalOnExpression          表达式，返回为true的时候，才装配.
 * OnExpressionCondition
 *
 * ConditionalOnNotWebApplication   当前不是web环境的时候，才装配
 * ConditionalOnWebApplication      当前是web环境的时候，才装配
 * OnWebApplicationCondition
 *
 *
 * ConditionalOnJava                基于当前 JVM的版本号，装配。 这个装配的范围，大于或等于，小于或等于
 * OnJavaCondition
 *
 * ConditionalOnJndi
 * OnJndiCondition
 *
 * ConditionalOnResource
 * OnResourceCondition
 * ResourceCondition
 *
 * ConditionalOnCloudPlatform
 * ConditionalOnSingleCandidate
 * AbstractNestedCondition
 * AllNestedConditions
 * AnyNestedCondition
 * NoneNestedConditions
 * SpringBootCondition
 * BeanTypeRegistry
 * ConditionEvaluationReport
 * ConditionEvaluationReportAutoConfigurationImportListener
 * ConditionMessage
 * ConditionOutcome
 * OnCloudPlatformCondition
 * SearchStrategy
 * </pre>
 */
@SpringBootConfiguration
public class EncodingConvertConfiguration {

    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConvert createUTF8EncodingConvert() {
        return new UTF8EncodingConvert();
    }

    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvert createGBKEncodingConvert() {
        return new UTF8EncodingConvert();
    }

    @Bean
    @ConditionalOnProperty(name = "runnable.enabled", havingValue = "true", matchIfMissing = true)
    public Runnable createRunnable() {
        return () -> {
        };
    }

    @Bean
    @ConditionalOnClass(name = "com.google.gson.Gson")
    public Runnable createGsonRunnable() {
        return () -> {
        };
    }

    @Bean
    @ConditionalOnBean(name = "user")
    public Runnable createBeanRunnable() {
        return () -> {
        };
    }
}
