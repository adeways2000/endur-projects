import batch.EndOfDayBatch;
import model.Portfolio;
import model.Trade;
import script.ValidationScript;
import service.PricingService;
import service.TradeLifecycleService;

public class Main {

    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio("POWER_BOOK");

        Trade trade = new Trade("T1", "POWER", 100, 50);

        new ValidationScript().execute(trade);

        TradeLifecycleService lifecycle = new TradeLifecycleService();
        lifecycle.validate(trade);

        new PricingService().applyMarketPrice(trade);
        lifecycle.price(trade);

        portfolio.addTrade(trade);

        new EndOfDayBatch().run(portfolio);
    }
}
