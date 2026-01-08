---



\## `endur-risk-engine`



```md

\# Endur-Style Risk, Limits \& Alerting Engine



\## Project Summary

This project simulates \*\*middle-office risk management\*\* functionality found in Endur.  

It focuses on exposure calculation, PnL aggregation, limit checks, breach detection, and alerting.



Risk governance is a core part of Endur implementations.



---



\## Key Features

\- Portfolio exposure calculation

\- PnL aggregation

\- Risk metrics

\- Risk limits

\- Breach detection

\- Alert generation

\- Batch-based risk monitoring



---



\## Architecture



+------------------+
| Portfolio Trades |
+--------+---------+
|
v
+------------------+
| Exposure Calc    |
+--------+---------+
|
v
+------------------+
| Risk Metrics     |
| (Exposure, PnL)  |
+--------+---------+
|
v
+------------------+
| Limit Checks     |
+--------+---------+
|
v
+------------------+
| Alerts \& Reports |
+------------------+





This mirrors Endur’s middle-office risk controls.



---



\## Project Structure

endur-risk-engine/

├── model/ # Risk metrics, limits

├── service/ # Exposure, risk, limit logic

├── batch/ # Risk batch job

└── Main.java # Demo execution


---



\## How to Run the Project



\### Prerequisites

\- Java 11+

\- IDE or terminal



\### Steps

```bash

cd endur-risk-engine

javac Main.java

java Main





