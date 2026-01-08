package messaging;

import model.TradeMessage;
import service.TradeIngestionService;

public class MessageQueueSimulator {

    public void receive(TradeMessage msg) {
        new TradeIngestionService().ingest(msg);
        System.out.println("ACK sent for trade " + msg.tradeId);
    }
}
