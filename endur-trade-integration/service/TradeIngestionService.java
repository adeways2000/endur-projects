package service;

import logging.IntegrationLogger;
import mapper.TradeMapper;
import model.IntegrationStatus;
import model.Trade;
import model.TradeMessage;
import validation.TradeMessageValidator;

public class TradeIngestionService {

    private final AcknowledgementService ackService = new AcknowledgementService();

    public void ingest(TradeMessage msg) {

        IntegrationLogger.log("Received trade " + msg.tradeId);

        try {
            new TradeMessageValidator().validate(msg);

            Trade trade = new TradeMapper().map(msg);
            trade.setStatus(IntegrationStatus.VALIDATED);

            new TradeEnrichmentService().enrich(trade);
            trade.setStatus(IntegrationStatus.ENRICHED);

            trade.setStatus(IntegrationStatus.ACCEPTED);
            ackService.sendAck(trade.getTradeId());

            IntegrationLogger.log("Trade accepted " + trade.getTradeId());

        } catch (Exception e) {
            ackService.sendNack(msg.tradeId, e.getMessage());
            IntegrationLogger.log("Trade rejected: " + e.getMessage());
        }
    }
}
