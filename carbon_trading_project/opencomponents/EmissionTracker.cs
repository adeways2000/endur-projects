/*
 * Project: Visionary Endur - Carbon Trading & ESG Engine
 * Module: Real-Time ESG Data Ingestion
 * Description: OpenComponents service for ingesting real-time carbon intensity data.
 */

using System;
using System.Net.Http;
using System.Threading.Tasks;
using OLF.Data;
using OLF.Trading;

namespace Enterprise.Endur.Carbon
{
    public class EmissionTracker : ITransactionListener
    {
        private static readonly HttpClient client = new HttpClient();

        public void OnAfterInsert(ITransaction tran)
        {
            UpdateEmissionData(tran).Wait();
        }

        private async Task UpdateEmissionData(ITransaction tran)
        {
            try
            {
                // Visionary: Fetching real-time grid intensity from an external ESG API
                string region = tran.GetStringField(TransactionField.ExternalBblRegion);
                double intensity = await FetchGridIntensity(region);

                // Update Endur's internal market data or trade info
                tran.SetField(TransactionField.TranInfo, "REAL_TIME_EMISSION_FACTOR", intensity.ToString());
                
                Console.WriteLine($"[ESG Service] Updated Trade {tran.TransactionId} with intensity {intensity} for region {region}");
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine($"ESG Data Ingestion Error: {ex.Message}");
            }
        }

        private async Task<double> FetchGridIntensity(string region)
        {
            // Mocking an API call to a service like Electricity Maps or MSCI
            await Task.Delay(100); 
            return region == "GERMANY" ? 0.385 : 0.420;
        }
    }
}
