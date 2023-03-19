package com.example.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("send message {} ", message);
        kafkaTemplate.send("str-topic", message);
//                .addCallback(
//                success -> {
//                    if (success != null) {
//                        log.info("Send message with success {}", message);
//                        log.info("Partition {}, offset {}",
//                                success.getRecordMetadata().partition(),
//                                success.getRecordMetadata().offset());
//                    }
//                },
//                error -> log.error("Error send message")
//        );
    }
}
