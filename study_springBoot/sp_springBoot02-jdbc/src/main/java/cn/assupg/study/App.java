package cn.assupg.study;

import cn.assupg.study.dao.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 装配DataSource的步骤：
 * 1、加入数据库驱动
 * 2、配置参数
 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * spring.datasource.url=jdbc:mysql://127.0.0.1:3306/fleet_supeng?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true
 * spring.datasource.username=root
 * spring.datasource.password=root123456
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(context.getBean(DataSource.class));
        DataSource dataSource = context.getBean(DataSource.class);
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection.getCatalog());
        }

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        context.getBean(DepartmentRepository.class).add("test1");

    }
}
