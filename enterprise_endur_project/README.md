# Enterprise Endur Integration Project

## Overview
This project demonstrates a robust, enterprise-grade integration for Openlink Endur, focusing on automated trade processing, real-time risk monitoring, and modern data streaming.

## Project Structure
- `/jvs/`: OpenJVS scripts for trade enrichment.
- `/opencomponents/`: C# (.NET) plugins for real-time risk calculation.
- `/sql/`: Optimized SQL for EOD batch processing.
- `/scripts/`: Python scripts for Kafka integration and CI/CD automation.
- `/docs/`: Detailed configuration and architecture documentation.

## Key Features
- **Automated Trade Capture**: Integration via Connex Gateway.
- **Real-Time Risk**: OpenComponents-based exposure monitoring.
- **Data Streaming**: Kafka producer for downstream system synchronization.
- **DevOps Ready**: Automated deployment scripts and CI/CD pipeline definitions.

## Getting Started
1. Review the `docs/Architecture_Overview.md` for a deep dive into the system design.
2. Explore the `jvs` and `opencomponents` folders for core business logic.
3. Check `scripts/deploy_customizations.py` for deployment automation.
