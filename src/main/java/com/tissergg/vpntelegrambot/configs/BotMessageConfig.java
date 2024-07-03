package com.tissergg.vpntelegrambot.configs;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "message")
@PropertySource(value = "classpath:message.properties", encoding = "UTF-8")
@Getter
@Setter
public class BotMessageConfig {
    private String start;
    private String help;
    private String trialNotUsed;
    private String trialUsed;
    private String stop;
    private String unknown;

    @PostConstruct
    public void init() {

        System.out.println("Start message: " + start);
        System.out.println("Help message: " + help);
        System.out.println("Trial not used message: " + trialNotUsed);
        System.out.println("Trial used message: " + trialUsed);
        System.out.println("Stop message: " + stop);

    }
}