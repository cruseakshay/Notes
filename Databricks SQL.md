## Databricks SQL

### Pre-requisite


```sql
CREATE DATABASE IF NOT EXISTS dbacademy;

-- The following grants SELECT, CREATE, MODIFY, READ_METADATA, and CREATE_NAMED_FUNCTION privileges to the learner for this database

------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
---------- **You MUST change the username to the learner's username**---------------------------
GRANT ALL PRIVILEGES ON DATABASE dbacademy TO `student@azuredatabrickstraining.onmicrosoft.com`;
------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------

USE dbacademy;

--The following ensures the tables use the latest data set
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_customers_csv;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_customers;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_loyalty_segments;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_loyalty_segments_csv;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_sales_gold;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_silver_promo_prices;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_silver_purchase_orders;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_silver_sales_orders;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_silver_suppliers;
DROP TABLE IF EXISTS basic_sql_for_databricks_sql_source_silver_suppliers;
DROP TABLE IF EXISTS intro_to_databricks_sql_gym_logs;
DROP TABLE IF EXISTS web_events_csv;


-- The following creates tables for use in Databricks SQL
-- Web Events table
CREATE TABLE web_events_csv 
  USING csv 
  OPTIONS (
    path "wasbs://courseware@dbacademy.blob.core.windows.net/data-visualization-on-databricks-sql/v01/Visualization/web-events.csv",
    header "true",
    inferSchema "true"
);
DROP TABLE IF EXISTS data_visualization_on_databricks_sql_web_events;
CREATE TABLE data_visualization_on_databricks_sql_web_events AS
  SELECT * FROM web_events_csv;
DROP TABLE web_events_csv;

-- Gym Logs table
CREATE TABLE intro_to_databricks_sql_gym_logs 
    USING JSON
    LOCATION 'wasbs://courseware@dbacademy.blob.core.windows.net/introduction-to-databricks-sql/v01/gym-logs';
-- The following ensures everything worked correctly
SELECT * FROM intro_to_databricks_sql_gym_logs;

-- Customers table
CREATE TABLE basic_sql_for_databricks_sql_customers_csv
  USING csv 
  OPTIONS (
    path "wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/customers",
    header "true",
    inferSchema "true"
);
CREATE TABLE basic_sql_for_databricks_sql_customers AS
  SELECT * FROM basic_sql_for_databricks_sql_customers_csv;
DROP TABLE basic_sql_for_databricks_sql_customers_csv;

-- Loyalty Segments table
CREATE TABLE basic_sql_for_databricks_sql_loyalty_segments_csv
  USING csv 
  OPTIONS (
    path "wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/loyalty_segments",
    header "true",
    inferSchema "true"
);
CREATE TABLE basic_sql_for_databricks_sql_loyalty_segments AS
  SELECT * FROM basic_sql_for_databricks_sql_loyalty_segments_csv;
DROP TABLE basic_sql_for_databricks_sql_loyalty_segments_csv;

CREATE TABLE basic_sql_for_databricks_sql_sales_gold AS
  SELECT * FROM delta.`wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/solutions/gold/sales`;
CREATE TABLE basic_sql_for_databricks_sql_silver_promo_prices AS
  SELECT * FROM delta.`wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/solutions/silver/promo_prices`;
CREATE TABLE basic_sql_for_databricks_sql_silver_purchase_orders AS
  SELECT * FROM delta.`wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/solutions/silver/purchase_orders.delta`;
CREATE TABLE basic_sql_for_databricks_sql_silver_sales_orders AS
  SELECT * FROM delta.`wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/solutions/silver/sales_orders`;
CREATE TABLE basic_sql_for_databricks_sql_silver_suppliers AS
  SELECT * FROM delta.`wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/solutions/silver/suppliers`;
CREATE TABLE basic_sql_for_databricks_sql_source_silver_suppliers AS
  SELECT * FROM delta.`wasbs://courseware@dbacademy.blob.core.windows.net/basic-sql-for-databricks-sql/v01/retail-org/solutions/silver/suppliers`;
```

