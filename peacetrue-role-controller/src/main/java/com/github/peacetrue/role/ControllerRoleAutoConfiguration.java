package com.github.peacetrue.role;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.data.web.ReactiveSortHandlerMethodArgumentResolver;


/**
 * @author xiayx
 */
@Configuration
@EnableConfigurationProperties(ControllerRoleProperties.class)
@ComponentScan(basePackageClasses = ControllerRoleAutoConfiguration.class)
@PropertySource("classpath:/application-role-controller.yml")
public class ControllerRoleAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ReactivePageableHandlerMethodArgumentResolver.class)
    public ReactivePageableHandlerMethodArgumentResolver reactivePageableHandlerMethodArgumentResolver() {
        return new ReactivePageableHandlerMethodArgumentResolver();
    }

    @Bean
    @ConditionalOnMissingBean(ReactivePageableHandlerMethodArgumentResolver.class)
    public ReactiveSortHandlerMethodArgumentResolver reactiveSortHandlerMethodArgumentResolver() {
        return new ReactiveSortHandlerMethodArgumentResolver();
    }

}
