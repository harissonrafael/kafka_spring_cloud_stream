package br.com.ia.javatalk.kafkaproducer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.GenericMessage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class KafkaMessage {

    @Bean
    public Supplier<String> continuous() {
        return () -> "Producer continuous - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Bean
    public Function<String, GenericMessage> scheduled() {
        return m -> new GenericMessage(m);
    }
}
