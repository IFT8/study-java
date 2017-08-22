package cn.assupg.study.study09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Date;

/**
 * <pre>
 * @EnableConfigurationProperties 是用来启用一个选择性的，一般是和@ConfigurationProperties一起使用。这个选择性就是，可以把配置文件的属性注入到bean的属性里面去，bean中属性需要get/set方法.
 * @EnableAsync 启用异步，一般是和@Async一起使用。
 *
 * @Enable 的工作原理，就是使用@Import 引用一个或多个配置
 *
 * @Import
 *          1、可以导入一个普通的类，（bean会被spring容器所托管）@Import({User.class,Role.class})
 *          2、导入配置类，配置里面的bean都会被spring容器所托管
 *
 * 接口 ImportSelector 【String[] selectImports(AnnotationMetadata importingClassMetadata);】
 *          有一个接口方法，selectImports 方法的返回 String[] 数组代表是class数组，或者是配置类，所有的都会装配到spring容器中托管。
 *          注意：可以根据注解中的配置，可以动态的根据逻辑返回 String[]。
 *
 *          @Import({Role.class, ImportMyConfiguration.class, MyImportSelector.class})   //通过自己实现的 ImportSelector 实现导入User.class
 *
 * 接口 ImportBeanDefinitionRegistrar【	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry);】
 *          它没有返回值，但是它有一个 BeanDefinitionRegistry 是往spring容器里面注入一个bean的。
 *
 *          它与 接口ImportSelector 效果差不多，只不过 接口ImportSelector是通过String[]返回的class字符串，注入到spring容器中，
 *              而 接口ImportBeanDefinitionRegistrar是提供一个 BeanDefinitionRegistry 让我们自己去注入。
 * </pre>
 */
@EnableConfigurationProperties
@EnableAsync
@ComponentScan
//@Import({User.class, Role.class, ImportMyConfiguration.class})
@Import({Role.class, ImportMyConfiguration.class, MyImportSelector.class})   //通过自己实现的 ImportSelector 实现导入User.class
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        System.out.println(context.getBean(TomcatProperties.class));

        context.getBean(Runnable.class).run();

        System.out.println("-------------------end-------------");

        System.out.println(context.getBean(User.class));
        System.out.println(context.getBean(Role.class));
        System.out.println(context.getBeansOfType(Date.class));
        context.close();
    }
}
