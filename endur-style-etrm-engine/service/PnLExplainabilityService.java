package service;

import model.Trade;

public class PnLExplainabilityService {

    public String explainPnL(Trade trade) {
        double priceDiff = trade.getMtM() / trade.getQuantity();

        return String.format(
            "PnL driven by price change. TradePrice=%.2f, MarketPrice=%.2f, Quantity=%.2f",
            trade.getMtM() / trade.getQuantity() + trade.getTradePrice(),
            trade.getTradePrice(),
            trade.getQuantity()
        );
    }
}
