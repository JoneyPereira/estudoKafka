package com.redua.jsonconsumer.listener;

import com.redua.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){

        log.info("Pagamento recebido {}", payment.toString());
        Thread.sleep(2000);

        log.info("Validadndo fraude... ");
        Thread.sleep(2000);

        log.info("Compra aprovada... ");
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){

        Thread.sleep(3000);
        log.info("Gerando pdf do produto: {}", payment.getIdProduct());
        Thread.sleep(3000);

        log.info("Pdf criado da compra... ");
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment){

        Thread.sleep(3000);
        log.info("Enviando email do pagamento: {}", payment.getId());
    }
}
