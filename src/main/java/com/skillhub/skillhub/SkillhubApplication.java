package com.skillhub.skillhub;

import com.skillhub.skillhub.config.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class SkillhubApplication {
	public static void main(String[] args) {
		SpringApplication.run(SkillhubApplication.class, args);
	}
}