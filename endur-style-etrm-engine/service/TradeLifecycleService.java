package service;

import model.Trade;
import model.TradeStatus;

public class TradeLifecycleService {

    public void validate(Trade trade) {
        trade.updateStatus(TradeStatus.VALIDATED);
    }

    public void price(Trade trade) {
        trade.updateStatus(TradeStatus.PRICED);
    }

    public void settle(Trade trade) {
        trade.updateStatus(TradeStatus.SETTLED);
    }
}
