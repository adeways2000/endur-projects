package market;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MarketDataFeed {

    private static final Map<String, Double> BASE_PRICES = new HashMap<>();

    static {
        BASE_PRICES.put("POWER", 50.0);
        BASE_PRICES.put("GAS", 30.0);
    }

    public static double getPrice(String commodity) {
        double base = BASE_PRICES.getOrDefault(commodity, 0.0);
        return base + new Random().nextDouble() * 5;
    }
}
