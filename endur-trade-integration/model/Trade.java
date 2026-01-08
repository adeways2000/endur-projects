package model;

public class Trade {
    private String tradeId;
    private String commodity;
    private double quantity;
    private double price;
    private String book;
    private IntegrationStatus status;

    public Trade(String tradeId, String commodity, double quantity, double price) {
        this.tradeId = tradeId;
        this.commodity = commodity;
        this.quantity = quantity;
        this.price = price;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setStatus(IntegrationStatus status) {
        this.status = status;
    }
    public String getTradeId() {
        return tradeId;
    }
}
