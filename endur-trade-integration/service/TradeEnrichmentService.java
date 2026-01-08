package service;

import model.Trade;

public class TradeEnrichmentService {

    public void enrich(Trade trade) {
        trade.setBook("POWER_TRADING_BOOK");
    }
}
