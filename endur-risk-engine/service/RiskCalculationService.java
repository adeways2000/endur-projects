package service;

import model.Portfolio;
import model.RiskMetric;

public class RiskCalculationService {

    public RiskMetric calculate(Portfolio portfolio) {
        double exposure = new ExposureService().calculateExposure(portfolio);
        double pnl = portfolio.getTrades().stream()
                .mapToDouble(t -> t.getMtM())
                .sum();

        return new RiskMetric(exposure, pnl);
    }
}
