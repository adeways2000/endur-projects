package service;

import model.Portfolio;
import model.Trade;

public class PnLService {

    public double calculateUnrealizedPnL(Portfolio portfolio) {
        return portfolio.getTrades().stream()
                .filter(t -> t.getStatus() != null)
                .mapToDouble(Trade::getMtM)
                .sum();
    }
}
