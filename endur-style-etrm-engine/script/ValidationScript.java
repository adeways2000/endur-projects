package script;

import model.Trade;

public class ValidationScript implements TradeScript {

    @Override
    public void execute(Trade trade) {
        if (trade.getQuantity() <= 0) {
            throw new RuntimeException("Invalid trade quantity");
        }
    }
}
