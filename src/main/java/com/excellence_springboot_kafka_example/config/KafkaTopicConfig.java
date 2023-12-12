package com.excellence_springboot_kafka_example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

//	@Value("${spring.kafka.topic.name}")
//	private String topicName;

//	@Value("${spring.kafka.topic-json.name}")
//	private String topicJsonName;

	@Bean
	public NewTopic excellenceTopic() {
		return TopicBuilder.name("excellence").build();
	}

	@Bean
	public NewTopic excellenceJsonTopic() {
		return TopicBuilder.name("excellence_json").build();
	}

}
