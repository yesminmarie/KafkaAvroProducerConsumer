package com.services.kafkaavroproducerconsumer.service;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendAvroData(String topicName, Student student){
        log.info("Sending data to kafka topic {}", topicName);
        String key = "key" + String.format("%.3f", Math.random());
        kafkaTemplate.send(topicName, key, student);
        log.info("Sent message successfully {}", student.toString());
    }
}
