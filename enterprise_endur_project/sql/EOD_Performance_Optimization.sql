-- Project: Enterprise Endur Integration
-- Module: Database Optimization
-- Description: SQL scripts for optimizing EOD batch processing and trade reporting.

-- 1. Identify slow-running EOD queries
SELECT 
    TOP 10
    qs.total_worker_time / qs.execution_count AS AvgCPUTime,
    qs.execution_count,
    st.text AS QueryText
FROM sys.dm_exec_query_stats AS qs
CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) AS st
ORDER BY AvgCPUTime DESC;

-- 2. Optimized Trade Summary View for Enterprise Risk Desk
-- Uses indexing hints and avoids cursors for high-volume trade data
CREATE VIEW vw_Ent_Daily_Trade_Summary AS
SELECT 
    t.ins_num,
    t.tran_num,
    t.trade_date,
    p.name AS Portfolio,
    i.name AS Instrument,
    t.position,
    t.price,
    (t.position * t.price) AS Notional_Value
FROM ab_tran t
JOIN portfolio p ON t.internal_portfolio = p.portfolio_id
JOIN instrument i ON t.ins_type = i.ins_type
WHERE t.tran_status = 3 -- Validated Trades
AND t.trade_date = CAST(GETDATE() AS DATE);

-- 3. Indexing strategy for cMotion workflow tables
CREATE INDEX idx_cmotion_tran_status ON cmotion_workflow_table (tran_num, current_status);
