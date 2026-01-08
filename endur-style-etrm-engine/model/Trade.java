package model;

public class Trade {

    private String tradeId;
    private String commodity;
    private double quantity;
    private double tradePrice;
    private double marketPrice;
    private TradeStatus status = TradeStatus.NEW;

    public Trade(String tradeId, String commodity, double quantity, double tradePrice) {
        this.tradeId = tradeId;
        this.commodity = commodity;
        this.quantity = quantity;
        this.tradePrice = tradePrice;
    }

    public double getMtM() {
        return (marketPrice - tradePrice) * quantity;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public void updateStatus(TradeStatus status) {
        this.status = status;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getCommodity() {
        return commodity;
    }
}
