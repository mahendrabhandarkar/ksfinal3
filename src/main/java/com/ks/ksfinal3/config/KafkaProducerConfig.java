package com.ks.ksfinal3.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {
    /*
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test-topic").build();
    }
     */
}
