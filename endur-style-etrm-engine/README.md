### Endur-Style ETRM Engine (Java)



\# Endur-Style ETRM Engine (Java)



\## Project Summary

This project simulates the core functionality of an Energy Trading \& Risk Management (ETRM) system similar to \*\*ION Endur\*\*.

Since Endur is proprietary, this project demonstrates Endur-style architecture, workflows, and development concepts using Java.



The system models the \*\*full trade lifecycle\*\*, valuation, \*\*PnL\*\*, risk calculation, batch processing, and integration.



---



\## Key Features

\- Trade capture and lifecycle management

\- JVS-style validation logic

\- Market data feed simulation

\- Mark-to-Market (MtM) valuation

\- Realized \& unrealized PnL

\- Risk exposure calculation

\- End-of-Day (EOD) batch jobs

\- REST-style integration layer

\- Unit tests (JUnit-ready)





\## Architecture

+------------------+
|  External Input  |
+--------+---------+
         |
         v
+------------------+        +--------------------+
|  Trade Capture   | -----> | JVS-Style Scripts  |
+--------+---------+        | (Validation Rules) |
         |                  +--------------------+
         v
+------------------+
| Trade Lifecycle  |  NEW → VALIDATED → PRICED → SETTLED
+--------+---------+
         |
         v
+------------------+        +------------------+
| Market Data Feed | -----> | Pricing Service |
+--------+---------+        +------------------+
         |
         v
+------------------+
| PnL & Risk Calc  |
+--------+---------+
         |
         v
+------------------+
| EOD Batch Jobs   |
+--------+---------+
         |
         v
+------------------+
| REST API Layer   |
+------------------+



This mirrors how Endur processes trades daily from capture to reporting.



---



\## Project Structure

endur-style-etrm-engine/

├── model/ # Trade, Portfolio, lifecycle states

├── script/ # JVS-style validation logic

├── market/ # Market data feed simulation

├── service/ # Pricing, PnL, Risk services

├── batch/ # End-of-Day processing

├── api/ # REST integration

├── test/ # Unit tests

└── Main.java # End-to-end demo



---



\## How to Run the Project



\### Prerequisites

\- Java 11+

\- Any IDE (IntelliJ / Eclipse) or terminal



\### Steps

```bash

cd endur-style-etrm-engine

javac Main.java

java Main











