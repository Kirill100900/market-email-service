package market.service;

import market.model.Message;

public interface ConsumerService {
    public void consume(Message message);
}
