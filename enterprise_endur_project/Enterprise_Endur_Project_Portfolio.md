# Enterprise Openlink Endur Project Portfolio: Real-Time ETRM Automation

**Author:** Adebisi Azokunle
**Date:** Dec 15, 2025

## 1. Executive Summary

This portfolio details a simulated enterprise project designed to enhance Energy Trading and Risk Management (ETRM) capabilities using Openlink Endur. The project focuses on **real-time trade lifecycle management**, **integration with modern data streaming platforms (Kafka)**, and the implementation of **DevOps methodologies** for continuous delivery. The solutions demonstrate expertise across the required technical stack: OpenJVS, OpenComponents (.NET), Connex, SQL optimization, and Python for automation.

## 2. Project Architecture and Design

The solution introduces a decoupled, event-driven architecture to ensure scalability and real-time data availability for downstream analytics and risk systems.

| Component | Technology | Role in ETRM Lifecycle | Skill Demonstrated |
| :--- | :--- | :--- | :--- |
| **Trade Capture** | Connex Gateway | Automated booking of EEX Power Futures, ensuring data integrity and STP. | Connex Gateways, Trade Booking |
| **Trade Enrichment** | OpenJVS (`TradeEnrichment.java`) | Custom logic for setting internal portfolios and initializing Kafka sync status. | OpenJVS, cMotion Configuration |
| **Real-Time Risk** | OpenComponents (`RiskCalculator.cs`) | High-performance, real-time exposure calculation and limit monitoring. | OpenComponents (.NET/Java), API Design |
| **Data Streaming** | Apache Kafka (Python Producer) | Publishes validated trade events for consumption by external systems. | Kafka, Python, API Design |
| **EOD Optimization** | SQL Scripts | Performance tuning of core Endur database queries for faster EOD batch processing. | SQL Optimization, Analytical Abilities |

## 3. Customization and Extension Details

### 3.1. OpenJVS Customization: Trade Enrichment

The `TradeEnrichment.java` script is triggered post-Connex booking via cMotion. It ensures that every incoming trade is immediately enriched with necessary internal attributes, critical for subsequent processing and reporting.

**Key Functionality:**
- **Portfolio Assignment:** Dynamically assigns the internal portfolio (`ENT_EU_POWER_PF`) based on the trade's external region.
- **Kafka Tracking:** Initializes a custom trade info field (`KAFKA_SYNC_STATUS`) to `PENDING`, acting as a flag for the Kafka producer service.

### 3.2. OpenComponents Extension: Real-Time Risk Calculation

The `RiskCalculator.cs` (C#/.NET) OpenComponent is registered as a `TransactionListener` to execute immediately upon trade insertion. This moves a critical risk calculation out of the core Endur process, improving performance and enabling modern development practices.

**Key Functionality:**
- **Exposure Calculation:** Calculates notional exposure (`Volume * Price`).
- **Limit Monitoring:** Triggers an alert (`NotifyRiskDesk`) if the exposure exceeds a predefined threshold (e.g., 1,000,000 EUR), demonstrating a hands-on approach to **risk management**.

### 3.3. SQL Optimization for EOD Batch Processing

Optimized SQL is essential for meeting strict EOD deadlines. The provided scripts focus on:
- **Performance Analysis:** Query to identify the top 10 slowest queries by average CPU time.
- **Optimized Reporting View:** Creation of `vw_Ent_Daily_Trade_Summary` using joins and filtering on validated trades, which is crucial for the **Operations** team.
- **Indexing Strategy:** Suggestion for creating an index on `cmotion_workflow_table` to speed up workflow status lookups.

## 4. Integration with Kafka and External Systems

The Kafka integration component bridges the gap between the transactional ETRM system and the analytical data landscape.

The Python-based `kafka_trade_producer.py` simulates the service responsible for reading validated trades from Endur and publishing them to the `endur.trades.v1` topic. This ensures **real-time data availability** for downstream systems, such as market risk analytics platforms or regulatory reporting tools.

## 5. DevOps and CI/CD Implementation

A robust CI/CD pipeline is defined using GitHub Actions to manage the deployment of Endur customizations, aligning with **DevOps methodologies**.

**Pipeline Steps:**
1. **Build:** Compiles OpenComponents (`RiskCalculator.csproj`).
2. **Test:** Runs automated unit tests (simulated) and JVS linting.
3. **Deployment:** Uses a Python script (`deploy_customizations.py`) to deploy compiled artifacts to the target environment (UAT or PROD) based on the branch (`develop` or `main`).

This approach ensures **code quality**, **repeatability**, and **faster time-to-market** for new ETRM features, directly addressing the requirement for familiarity with CI/CD pipelines and performance optimization.

## 6. Conclusion

This project demonstrates the full spectrum of skills required for an Openlink Endur Developer/Analyst, from **deep Endur customization** and **legacy code optimization** to **modern integration patterns** and **DevOps automation**. The focus on real-time data, performance, and cross-functional collaboration reflects a convincing profile for leading development initiatives in a complex energy trading environment.
