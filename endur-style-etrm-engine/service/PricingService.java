package service;

import market.MarketDataFeed;
import model.Trade;

public class PricingService {

    public void applyMarketPrice(Trade trade) {
        trade.setMarketPrice(MarketDataFeed.getPrice(trade.getCommodity()));
    }
}
