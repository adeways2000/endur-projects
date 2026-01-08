package batch;

import model.Portfolio;
import service.PnLService;
import service.RiskService;

public class EndOfDayBatch {

    public void run(Portfolio portfolio) {
        System.out.println("EOD Unrealized PnL: " +
                new PnLService().calculateUnrealizedPnL(portfolio));

        System.out.println("EOD Exposure: " +
                new RiskService().calculateExposure(portfolio));
    }
}
