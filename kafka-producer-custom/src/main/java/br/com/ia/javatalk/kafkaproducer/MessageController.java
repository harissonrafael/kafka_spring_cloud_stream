package br.com.ia.javatalk.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.http.HttpStatus.ACCEPTED;

@Controller
public class MessageController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping
    @ResponseStatus(ACCEPTED)
    public void delegateToSupplier(@RequestBody String body) {
        System.out.println("Sending message: " + body);
        streamBridge.send("custom-out-0", new GenericMessage(body + " - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
    }
}
