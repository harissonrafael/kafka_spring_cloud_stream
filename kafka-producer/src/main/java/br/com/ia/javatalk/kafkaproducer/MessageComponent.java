package br.com.ia.javatalk.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MessageComponent {

    @Autowired
    private StreamBridge streamBridge;


    @Scheduled(cron = "*/10 * * * * *")
    public void sendScheduledMessage() {
        System.out.println("Producer scheduled - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        streamBridge.send("scheduled-out-0", "Generic message scheduled - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

}
