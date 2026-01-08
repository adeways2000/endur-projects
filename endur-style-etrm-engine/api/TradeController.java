@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private Portfolio portfolio = new Portfolio("API_PORTFOLIO");

    @PostMapping
    public String addTrade(@RequestBody Trade trade) {
        portfolio.addTrade(trade);
        return "Trade added";
    }

    @GetMapping("/pnl")
    public double getPnL() {
        return new PnLService().calculateUnrealizedPnL(portfolio);
    }
}
