package cn.assupg.study.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
@Configuration
public class TestRibbonCustomizeConfiguration2 {

    //@Autowired
    //IClientConfig config;

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}

