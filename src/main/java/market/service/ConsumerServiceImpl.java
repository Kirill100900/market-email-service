package market.service;

import market.model.Message;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class ConsumerServiceImpl implements ConsumerService{
    @KafkaListener(topics = "messages", groupId = "message_group_id")
    public void consume(Message message){
        System.out.println("Consuming the message: " + message);
    }
}
