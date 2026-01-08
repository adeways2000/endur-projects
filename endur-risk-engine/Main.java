import batch.RiskBatchJob;
import model.Portfolio;
import model.Trade;

public class Main {

    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio("RISK_BOOK");

        Trade trade = new Trade("T1", "POWER", 200, 50);
        trade.setMarketPrice(60);

        portfolio.addTrade(trade);

        new RiskBatchJob().run(portfolio);
    }
}
