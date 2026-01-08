package service;

public class AcknowledgementService {

    public void sendAck(String tradeId) {
        System.out.println("ACK sent for trade " + tradeId);
    }

    public void sendNack(String tradeId, String reason) {
        System.out.println("NACK sent for trade " + tradeId + " | Reason: " + reason);
    }
}
