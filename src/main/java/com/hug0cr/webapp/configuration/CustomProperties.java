package com.hug0cr.webapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.hug0cr.webapp.configuration")
public class CustomProperties {

    private String apiUrl;

}
