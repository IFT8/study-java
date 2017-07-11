package cn.assupg.study.study09.s4_EnableLog_ImportBeanDefinitionRegistrar;

import cn.assupg.study.study09.User;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@EnableLog(name = "my springboot..")
@ComponentScan
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(context.getBean(User.class));
        context.close();
    }
}
