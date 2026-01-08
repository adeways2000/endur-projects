package service;

import model.RiskLimit;
import model.RiskMetric;

public class RiskLimitService {

    public boolean breached(RiskMetric metric, RiskLimit limit) {
        return metric.exposure > limit.maxExposure;
    }
}
