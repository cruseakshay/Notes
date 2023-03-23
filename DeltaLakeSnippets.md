## Snippets for pyspark and delta lake.

We can run the following using %sql or spark.sql()

```sql
CREATE DATABASE IF NOT EXISTS {db};

USE {db}

SET spark.databricks.delta.formatCheck.enabled = false; --??

SET spark.databricks.delta.properties.defaults.autoOptimize.optimizeWrite = true; -- ??

DROP TABLE IF EXISTS {table};

-- no upfront schema definition needed
CREATE TABLE loans_delta2
USING delta
AS SELECT * FROM parquet.`/tmp/delta_demo/loans_parquet`;

--
CONVERT TO DELTA parquet.`/tmp/delta_demo/loans_parquet`;

--Transaction logs:
DESCRIBE HISTORY {table};

--Time Travel using version or timestamp
SELECT * FROM {table} VERSION AS OF 0;

--Rollback a table to a specific version
RESTORE {table} VERSION AS OF 0;

MERGE INTO {table} AS Destination
USING {table} AS Source
ON {join_condition}
WHEN MATCHED THEN 
  UPDATE SET *
WHEN NOT MATCHED 
  THEN INSERT *;
  
--File compaction and performance optimizations
VACUUM {table};

--Cache table in memory
CACHE SELECT * FROM {table};

--Z-Order Optimize
OPTIMIZE {table} ZORDER BY {column}
```
