package cn.assupg.study09;


import org.springframework.context.annotation.Bean;

import java.util.Date;

public class ImportMyConfiguration {

    @Bean
    public Date createDate() {
        return new Date();
    }

    @Bean
    public Date createDate2() {
        return new Date();
    }
}
