package com.khy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSourceOne")
    @ConfigurationProperties(prefix = "spring.datasource-one")
    public DruidDataSource dataSourceOne() {
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource-two")
    public DruidDataSource dataSourceTwo() {
        return new DruidDataSource();
    }
}