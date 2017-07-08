package com.comodin.basic.util.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;


/**
 * 用来在对象的get方法上加入的annotation，通过该annotation说明某个属性所对应的标题
 * Hibernate Validator 中内置的 constraint简介
 * 注解                              作用
 *
 * @Valid 被注释的元素是一个对象，需要检查此对象的所有字段值
 * @Null 被注释的元素必须为 null
 * @NotNull 被注释的元素必须不为 null
 * @AssertTrue 被注释的元素必须为 true
 * @AssertFalse 被注释的元素必须为 false
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max, min)             被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内 [integer该号码接受的最大整数数][fraction该数字接受的最大数字的小数位数]
 * @Past 被注释的元素必须是一个过去的日期
 * @Future 被注释的元素必须是一个将来的日期
 * @Pattern(value) 被注释的元素必须符合指定的正则表达式
 * <p>
 * Hibernate Validator 附加的 constraint
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 * @Email 被注释的元素必须是电子邮箱地址
 * @Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
 * @NotEmpty 被注释的字符串的必须非空
 * @Range(min=,max=,message=) 被注释的元素必须在合适的范围内
 */
@SuppressWarnings("JavaDoc")
@Target({FIELD,METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {

    /**
     * 属性对应excel标题名称，无默认值，此参数必需设置。
     *
     * @return //
     */
    String title();

    /**
     * 出错，对外提供的错误代码
     *
     * @return //
     */
    String errorCode();

    /**
     * 在excel的顺序，默认为：0，即代表对顺序没有限定
     *
     * @return //
     */
    int order() default 0;


    String pattern() default "";

    /**
     * 可以支持，按组进行校验；
     * 注意：
     * 1、若@ExcelResources.validGroups，已经配置过，优先于@ExcelRoot.validGroups级别。
     * 2、若@ExcelResources.validGroups，为空，而@ExcelRoot.validGroups级别有配置，即使用@ExcelRoot.validGroups指定的组
     * 3、@ExcelResources.validGroups 要优于 @ExcelRoot.validGroups
     *
     * @return //
     */
    Class<?>[] validGroups() default {};
}
