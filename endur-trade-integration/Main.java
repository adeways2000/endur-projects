import messaging.MessageQueueSimulator;
import model.TradeMessage;

public class Main {

    public static void main(String[] args) {

        TradeMessage msg = new TradeMessage();
        msg.tradeId = "EXT-1001";
        msg.commodity = "POWER";
        msg.quantity = 100;
        msg.price = 52;
        msg.sourceSystem = "EXT_TRADING_APP";

        new MessageQueueSimulator().receive(msg);
    }
}
