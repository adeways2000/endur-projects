# Connex Gateway Configuration: EEX Trade Feed

## 1. Overview
This configuration enables the automated booking of Power Futures from the European Energy Exchange (EEX) into the enterprise Endur environment.

## 2. Connection Settings
| Parameter | Value |
| :--- | :--- |
| **Gateway Name** | EEX_POWER_CONNEX |
| **Protocol** | FIX 4.4 |
| **Host** | eex-fix-gateway.market.com |
| **Port** | 9876 |
| **Heartbeat** | 30s |

## 3. Field Mapping (EEX to Endur)
| EEX FIX Tag | Endur Field | Mapping Logic |
| :--- | :--- | :--- |
| `Tag 55` (Symbol) | `ins_type` | Map `DEBM` to `POWER_FWD_DE` |
| `Tag 38` (OrderQty) | `position` | Direct mapping |
| `Tag 44` (Price) | `price` | Direct mapping |
| `Tag 1` (Account) | `internal_portfolio` | Lookup via the Enterprise Portfolio Matrix |

## 4. Post-Booking Actions
- Trigger `TradeEnrichment.java` JVS script.
- Update `KAFKA_SYNC_STATUS` to `PENDING`.
- Notify `RiskCalculator.cs` for real-time VaR update.
