/*
 * Project: Enterprise Endur Integration
 * Module: Trade Processing
 * Description: OpenJVS script for automated trade enrichment during the capture lifecycle.
 * Author: Endur Developer/Analyst
 */

package com.enterprise.endur.jvs;

import com.olf.openjvs.*;
import com.olf.openjvs.enums.*;

public class TradeEnrichment implements IScript {
    public void execute(IContainerContext context) throws OException {
        Table argt = context.getArgumentsTable();
        Table returnt = context.getReturnTable();
        
        // Retrieve the transaction object from the context
        Transaction tran = context.getTransaction();
        
        if (tran != null) {
            enrichTradeData(tran);
        }
    }

    private void enrichTradeData(Transaction tran) throws OException {
        // Example: Enriching Power Trade with enterprise-specific internal attributes
        int toolset = tran.getFieldInt(TRANF_FIELD.TRANF_TOOLSET_ID.toInt());
        
        if (toolset == TOOLSET_ENUM.POWER_TOOLSET.toInt()) {
            // Set internal portfolio based on region
            String region = tran.getFieldString(TRANF_FIELD.TRANF_EXTERNAL_BBL_REGION.toInt());
            if ("EUROPE".equalsIgnoreCase(region)) {
                tran.setField(TRANF_FIELD.TRANF_INTERNAL_PORTFOLIO.toInt(), 0, "ENT_EU_POWER_PF");
            }
            
            // Add custom info field for Kafka tracking
            tran.setField(TRANF_FIELD.TRANF_TRAN_INFO.toInt(), 0, "KAFKA_SYNC_STATUS", "PENDING");
            
            OConsole.oprint("Trade " + tran.getTranNum() + " enriched for region: " + region);
        }
    }
}
