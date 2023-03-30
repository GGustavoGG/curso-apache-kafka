package com.example.jsonconsumer.listener;

import com.example.jsonconsumer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment) {
        log.info("Recebi o pagamento {}", payment.toString());
        Thread.sleep(2000);
        log.info("Validando fraude");
        Thread.sleep(2000);
        log.info("Compra aprovada");
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        log.info("Gerando PDF do produto de id {} ", payment.getId());
        Thread.sleep(4000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendMail() {
        log.info("Enviando email... ");
        Thread.sleep(1000);
    }
}
