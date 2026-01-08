package mapper;

import model.Trade;
import model.TradeMessage;

public class TradeMapper {

    public Trade map(TradeMessage msg) {
        return new Trade(
                msg.tradeId,
                msg.commodity,
                msg.quantity,
                msg.price
        );
    }
}
