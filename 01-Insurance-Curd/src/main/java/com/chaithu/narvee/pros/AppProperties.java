package com.chaithu.narvee.pros;
import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "plan-api")
@Configuration
@Data
public class AppProperties {
	
	HashMap<String,String> messages = new HashMap<>();

}
