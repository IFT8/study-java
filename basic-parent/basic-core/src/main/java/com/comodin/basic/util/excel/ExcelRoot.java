package com.comodin.basic.util.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * <pre>
 * @Target：
 * 　　@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
 * 　　作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
 * 　　取值(ElementType)有：
 * 　　　　1.CONSTRUCTOR:用于描述构造器
 * 　　　　2.FIELD:用于描述域
 * 　　　　3.LOCAL_VARIABLE:用于描述局部变量
 * 　　　　4.METHOD:用于描述方法
 * 　　　　5.PACKAGE:用于描述包
 * 　　　　6.PARAMETER:用于描述参数
 * 　　　　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 * @Retention：
 * 　　@Retention定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。使用这个meta-Annotation可以对 Annotation的“生命周期”限制。
 * 　　作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
 * 　　取值（RetentionPolicy）有：
 * 　　　　1.SOURCE:在源文件中有效（即源文件保留）
 * 　　　　2.CLASS:在class文件中有效（即class保留）
 * 　　　　3.RUNTIME:在运行时有效（即运行时保留）
 * </pre>
 */
@SuppressWarnings("JavaDoc")
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelRoot {

    /**
     * 设定：excelSheet名；若为空，即会选择 下标为0的工作表。 默认调用 workbook.getSheetAt(0);
     *
     * @return JavaBean对应的Excel.Sheet名
     */
    String sheetName();

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

    /**
     * 标题，初始化参数 1、设定，标题行，所在的位置，默认值为1，代表标题设置excel第1行 【只有为正整数】
     *
     * @return //
     */
    int titleRowPositions() default 1;

    /**
     * 标题，初始化参数 2、设定，标题列，开始的位置，默认值为1，代表标题设置excel第1列 【只有为正整数】
     *
     * @return //
     */
    int titleColumnStartPositions() default 1;

    /**
     * 标题，初始化参数 3、设定，标题列，结束的位置，默认为0，不做限制 【只有为正整数】【此是基于 titleExcelColumnPositions  】
     *
     * @return //
     */
    int titleColumnEndPositions() default 0;

    /**
     * 标题，初始化参数 4、设定，标题列，最大的位置，默认为0，不做限制 【只有为正整数】
     *
     * @return //
     */
    int titleColumnMaxPositions() default 0;

    /**
     * 标题，初始化参数 5、设定，是否校验标题顺序，默认为：false，代表不校验；true 代表强制检查其数据的顺序
     *
     * @return //
     */
    boolean titleOrder() default false;

    /**
     * 数据区域，初始化参数 1、设定，行，开始读取的位置，默认为2，代表从excel第2行开始读取 【只有为正整数】
     *
     * @return //
     */
    int dataRowStartPositions() default 2;

    /**
     * 数据区域，初始化参数 2、设定，行，结束读取的位置，默认为0，为最后一行（索引值=0，用负数来表示倒数第n行）
     *
     * @return //
     */
    int dataRowEndPositions() default 0;

    /**
     * 数据区域，初始化参数 3、设定，行，最大读取的位置，默认为0，代表不设置限制； 【只有为正整数】
     *
     * @return //
     */
    int dataRowMaxPositions() default 0;

    /**
     * 数据区域，初始化参数 1、设定，每行列，开始读取的位置，默认为1，代表从excel第1列开始读取 【只有为正整数】
     *
     * @return //
     */
    int dataColumnStartPositions() default 1;

    /**
     * 数据区域，初始化参数 2、设定，每行列，结束读取的位置，默认为0，代表不设置限制 【只有为正整数】
     *
     * @return //
     */
    int dataColumnEndPositions() default 0;

    /**
     * 数据区域，初始化参数 3、设定，每行列，最大读取的位置，默认为0，代表不设置限制； 【只有为正整数】
     *
     * @return //
     */
    int dataColumnMaxPositions() default 0;
}
