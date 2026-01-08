package validation;

import model.TradeMessage;

public class TradeMessageValidator {

    public void validate(TradeMessage msg) {

        if (msg.tradeId == null || msg.tradeId.isEmpty()) {
            throw new RuntimeException("Trade ID missing");
        }

        if (msg.quantity <= 0) {
            throw new RuntimeException("Quantity must be positive");
        }

        if (msg.price <= 0) {
            throw new RuntimeException("Price must be positive");
        }
    }
}
