package service;

import model.Portfolio;

public class RiskLimitService {

    private static final double MAX_EXPOSURE = 10000;

    public boolean isWithinLimit(Portfolio portfolio) {
        double exposure = new RiskService().calculateExposure(portfolio);
        return exposure <= MAX_EXPOSURE;
    }
}
