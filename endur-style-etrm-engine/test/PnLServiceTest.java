import model.Portfolio;
import model.Trade;
import org.junit.jupiter.api.Test;
import service.PnLService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PnLServiceTest {

    @Test
    void testPnLCalculation() {
        Portfolio portfolio = new Portfolio("TEST");
        Trade trade = new Trade("T1", "POWER", 100, 50);
        trade.setMarketPrice(55);

        portfolio.addTrade(trade);

        assertEquals(500, new PnLService().calculateUnrealizedPnL(portfolio));
    }
}
