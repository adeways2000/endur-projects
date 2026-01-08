package service;

import model.Portfolio;

public class RiskService {

    public double calculateExposure(Portfolio portfolio) {
        return portfolio.getTrades().stream()
                .mapToDouble(t -> Math.abs(t.getMtM()))
                .sum();
    }
}
