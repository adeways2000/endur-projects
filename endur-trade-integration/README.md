

\## `endur-trade-integration`



```md

\# Endur-Style Trade Integration \& STP Engine



\## Project Summary

This project simulates \*\*Endur-style Straight-Through Processing (STP)\*\* for trade integration.  

It demonstrates how trades are ingested from external systems, validated, mapped, enriched, acknowledged, and logged.



Integration is a major responsibility of Endur developers.



---



\## Key Features

\- External trade message ingestion

\- Validation rules

\- Message-to-trade mapping

\- Trade enrichment (book, defaults)

\- STP status tracking

\- ACK / NACK handling

\- Integration logging

\- Message queue simulation



---



\## Architecture











+----------------------+

| External Trading App |

+----------+-----------+

           |

           v

+----------------------+

| Message Queue (Sim)  |

+----------+-----------+

           |

           v

+----------------------+

| Validation Rules     |

+----------+-----------+

           |

           v

+----------------------+

| Trade Mapping        |

+----------+-----------+

           |

           v

+----------------------+

| Trade Enrichment     |

| (Book, Defaults)     |

+----------+-----------+

           |

           v

+----------------------+

| Trade Accepted       |

| or Rejected          |

+----------+-----------+

           |

           v

+----------------------+

| ACK / NACK Response  |

+----------------------+





This reflects real Endur STP integration pipelines.



---



\## Project Structure

endur-trade-integration/

├── model/ # TradeMessage, Trade, IntegrationStatus

├── validation/ # Validation rules

├── mapper/ # Message-to-trade mapping

├── service/ # Ingestion, enrichment, ACK/NACK

├── messaging/ # Queue simulation

├── logging/ # Integration logs

└── Main.java # End-to-end demo



---



\## How to Run the Project



\### Prerequisites

\- Java 11+

\- IDE or terminal



\### Steps

```bash

cd endur-trade-integration

javac Main.java

java Main





