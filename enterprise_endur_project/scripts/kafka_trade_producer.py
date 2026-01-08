"""
Project: Enterprise Endur Integration
Module: Integration Layer
Description: Python script simulating a Kafka producer that streams Endur trade events to downstream systems.
"""

import json
import time
from datetime import datetime

# Mocking Kafka Producer for demonstration
class EndurKafkaProducer:
    def __init__(self, bootstrap_servers):
        self.bootstrap_servers = bootstrap_servers
        print(f"Connected to Kafka at {self.bootstrap_servers}")

    def send_trade_event(self, topic, trade_data):
        event = {
            "timestamp": datetime.now().isoformat(),
            "source": "Openlink_Endur_Enterprise",
            "event_type": "TRADE_CAPTURE",
            "payload": trade_data
        }
        # In a real scenario, use: producer.send(topic, value=event)
        print(f"Sending event to topic [{topic}]: {json.dumps(event, indent=2)}")

def main():
    producer = EndurKafkaProducer("kafka-broker.enterprise.cloud:9092")
    
    # Simulated trade data from Endur Connex Gateway
    sample_trade = {
        "tran_num": 105678,
        "instrument": "POWER_FWD_DE",
        "volume": 50.0,
        "price": 85.20,
        "currency": "EUR",
        "counterparty": "EEX_EXCHANGE",
        "portfolio": "ENT_TRADING_01"
    }
    
    while True:
        producer.send_trade_event("endur.trades.v1", sample_trade)
        time.sleep(10) # Simulate periodic trade capture

if __name__ == "__main__":
    main()
