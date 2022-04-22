package br.com.ia.javatalk.kafkaconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.GenericMessage;

import java.util.function.Consumer;

@Configuration
public class KafkaMessage {

    @Bean
    public Consumer<String> continuous() {
        return s -> System.out.println(s);
    }

    @Bean
    public Consumer<GenericMessage<String>> scheduled() {
        return g -> System.out.println("Consuming message with PAYLOAD '" + g.getPayload() + "' and HEADERS '" + g.getHeaders() + "'");
    }

    @Bean
    public Consumer<GenericMessage<String>> custom() {
        return g -> System.out.println("Consuming CUSTOM message with PAYLOAD '" + g.getPayload() + "' and HEADERS '" + g.getHeaders() + "'");
    }
}
