-- Project: Visionary Endur - Carbon Trading & ESG Engine
-- Module: Advanced Analytics
-- Description: SQL views for real-time carbon exposure and ESG compliance monitoring.

-- 1. Carbon Intensity per Portfolio
-- Calculates the weighted average carbon intensity (WACI) for all physical trades
CREATE VIEW vw_Portfolio_Carbon_Intensity AS
SELECT 
    p.name AS Portfolio_Name,
    SUM(t.position * CAST(ti.value AS FLOAT)) / SUM(t.position) AS Weighted_Avg_Intensity,
    SUM(t.position * CAST(ti.value AS FLOAT)) AS Total_Carbon_Footprint_MT
FROM ab_tran t
JOIN portfolio p ON t.internal_portfolio = p.portfolio_id
JOIN ab_tran_info ti ON t.tran_num = ti.tran_num
JOIN tran_info_types tit ON ti.type_id = tit.type_id
WHERE tit.type_name = 'CARBON_INTENSITY'
AND t.tran_status = 3 -- Validated
GROUP BY p.name;

-- 2. Offset Coverage Ratio
-- Monitors how much of the physical emissions are covered by linked carbon offsets
CREATE VIEW vw_ESG_Offset_Coverage AS
SELECT 
    t.tran_num AS Physical_Trade_ID,
    t.position AS Volume_MWh,
    CAST(ti_int.value AS FLOAT) AS Intensity,
    (t.position * CAST(ti_int.value AS FLOAT)) AS Gross_Emissions,
    ti_link.value AS Linked_Offset_ID,
    CASE 
        WHEN ti_link.value IS NOT NULL THEN 'COVERED'
        ELSE 'UNCOVERED'
    END AS Compliance_Status
FROM ab_tran t
LEFT JOIN ab_tran_info ti_int ON t.tran_num = ti_int.tran_num AND ti_int.type_id = (SELECT type_id FROM tran_info_types WHERE type_name = 'CARBON_INTENSITY')
LEFT JOIN ab_tran_info ti_link ON t.tran_num = ti_link.tran_num AND ti_link.type_id = (SELECT type_id FROM tran_info_types WHERE type_name = 'LINKED_OFFSET_ID')
WHERE t.ins_type IN (SELECT ins_type FROM instrument WHERE name LIKE '%POWER%' OR name LIKE '%GAS%');

-- 3. Carbon VaR (cVaR) Exposure
-- Combines position volume with carbon price volatility (simulated)
CREATE VIEW vw_Carbon_VaR_Exposure AS
SELECT 
    Portfolio_Name,
    Total_Carbon_Footprint_MT,
    Total_Carbon_Footprint_MT * 85.50 AS Carbon_Market_Value_EUR, -- Current EUA Price
    Total_Carbon_Footprint_MT * 85.50 * 0.15 AS Carbon_VaR_95_Percent -- 15% Volatility assumption
FROM vw_Portfolio_Carbon_Intensity;
