package com.yoke.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = "classpath:db.properties")
@Component
@Data
public class DataSourceProperties {

    @Value("${db.driverClass}")
    private String driverClass;

    @Value("${db.url}")
    private String url;

    @Value("${db.userName}")
    private String userName;

    @Value("${db.password}")
    private String password;
}
