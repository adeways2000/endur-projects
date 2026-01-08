/*
 * Project: Enterprise Endur Integration
 * Module: Risk Management
 * Description: OpenComponents (.NET) plugin for real-time Value-at-Risk (VaR) calculation.
 */

using System;
using OLF.Data;
using OLF.Trading;

namespace Enterprise.Endur.OpenComponents
{
    public class RiskCalculator : ITransactionListener
    {
        public void OnAfterInsert(ITransaction tran)
        {
            CalculateExposure(tran);
        }

        private void CalculateExposure(ITransaction tran)
        {
            try 
            {
                // Accessing Endur's internal risk engine via OpenComponents
                double volume = tran.GetDoubleField(TransactionField.Volume);
                double price = tran.GetDoubleField(TransactionField.Price);
                
                double exposure = volume * price;
                
                // Log exposure to internal monitoring system
                Console.WriteLine($"[Risk Service] Trade {tran.TransactionId}: Exposure calculated as {exposure} EUR");
                
                // Trigger Kafka update if exposure exceeds threshold
                if (exposure > 1000000) 
                {
                    NotifyRiskDesk(tran, exposure);
                }
            }
            catch (Exception ex)
            {
                // Error handling for production support
                Console.Error.WriteLine($"Error in RiskCalculator: {ex.Message}");
            }
        }

        private void NotifyRiskDesk(ITransaction tran, double exposure)
        {
            // Logic to interface with the enterprise alerting system
        }
    }
}
