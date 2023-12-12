package com.excellence_springboot_kafka_example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.excellence_springboot_kafka_example.payload.User;

@Service
public class JsonKafkaProducer {

//	@Value("${spring.kafka.topic-json.name}")
//	private String topicJsonName;

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {

		LOGGER.info(String.format("Message sent -> %s", data.toString()));

		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "excellence_json").build();

		kafkaTemplate.send(message);
	}
}
