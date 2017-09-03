package cn.assupg.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
@Configuration
public class TestRibbonCustomizeConfiguration {

    @Autowired
    IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        //if (this.propertiesFactory.isSet(IRule.class, name)) {
        //    return this.propertiesFactory.get(IRule.class, config, name);
        //}
        //ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
        //rule.initWithNiwsConfig(config);
        //return rule;
        return new RandomRule();
    }
}