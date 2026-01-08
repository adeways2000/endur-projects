package batch;

import model.Portfolio;
import model.RiskLimit;
import service.AlertService;
import service.RiskCalculationService;
import service.RiskLimitService;

public class RiskBatchJob {

    public void run(Portfolio portfolio) {

        var metric = new RiskCalculationService().calculate(portfolio);
        var limit = new RiskLimit(10000);

        if (new RiskLimitService().breached(metric, limit)) {
            new AlertService().sendAlert("Exposure limit exceeded");
        }
    }
}
