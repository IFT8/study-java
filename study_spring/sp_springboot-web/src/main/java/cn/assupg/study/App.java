package cn.assupg.study;

import cn.assupg.study.bean.Product;
import cn.assupg.study.mapper.ProductMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        ProductMapper productMapper = context.getBean(ProductMapper.class);

        productMapper.add(new Product().setName("test").setType("type1").setPrice(10.0));
        context.close();
    }
}
