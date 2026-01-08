# Architecture Overview: Enterprise Endur Integration

## 1. System Design
The project follows a decoupled, event-driven architecture designed to minimize latency in trade processing while ensuring high data availability for downstream systems.

## 2. Data Flow
1. **Trade Ingestion**: Trades are captured via the **Connex Gateway** from external exchanges.
2. **Enrichment**: The `TradeEnrichment.java` (OpenJVS) script automatically assigns portfolios and initializes sync flags.
3. **Risk Calculation**: The `RiskCalculator.cs` (OpenComponents) listener calculates exposure in real-time.
4. **Downstream Sync**: The `kafka_trade_producer.py` service streams validated trade events to the enterprise Kafka broker.

## 3. Integration Layer
- **Messaging**: Apache Kafka for asynchronous communication.
- **Database**: Optimized SQL Server/Sybase schema for high-volume EOD reporting.
- **APIs**: RESTful wrappers for cross-team access to Endur data.

## 4. Deployment Strategy
- **CI/CD**: GitHub Actions pipeline for automated building, testing, and deployment to UAT/PROD environments.
