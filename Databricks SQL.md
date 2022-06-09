## Databricks SQL

### Pre-requisite


```sql
CREATE DATABASE IF NOT EXISTS dbacademy;

-- The following grants SELECT, CREATE, MODIFY, READ_METADATA, and CREATE_NAMED_FUNCTION privileges to the learner for this database

------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
---------- **MUST change the username**---------------------------
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

### Basic Querying Using SQL

```sql
-- 2021 Sales
SELECT sum(total_price) Total_Sales FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
    WHERE order_date >= to_date('2021-01-01');

-- Insert New Sale
INSERT INTO dbacademy.basic_sql_for_databricks_sql_sales_gold
    (customer_id, customer_name, product_name, order_date, product_category, product, total_price)
    VALUES
    (38832, "Jones", "Opple", current_date(), "Opple", NULL, 1000);
```

### Query Parameters (Text, Number, Dropdown List, Query Based Dropdown)

```sql
-- Query Parameters
--category = Opple, Zamaha, Rony
--Note: Dropdown List need single quotes as it is not of type Text by default.
SELECT sum(total_price) Total_Sales FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
    WHERE product_category = '{{category}}';

-- SELECT sum(total_price) Total_Sales FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
--     WHERE customer_name= '{{customerName}}';

--From Aug 1 2019 to Oct 31 2019
--Note: Thundebolt, for preconfigured ranges.
-- SELECT sum(total_price) Total_Sales FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
--     WHERE order_date >= '{{ dateRange.start }}'
--     AND order_date <= '{{ dateRange.end }}';

-- Product Category
SELECT DISTINCT product_category FROM dbacademy.basic_sql_for_databricks_sql_sales_gold;
```

### Bar Chart

```sql
-- Note: In Table Viz, Column Rename, Column Visibility, Type: Text, HTTP, IMG etc.
-- Note: Bar Viz, Data Label e.g. {{@@name}}

-- Sales for Three Months: (Month, Total Sales, Customer Name)
SELECT customer_name, total_price Total_Sales, month(order_date) Month, product_category FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
    WHERE order_date >= to_date('2019-08-01')
    AND order_date <= to_date('2019-10-31');
```

### Table, Details, and Counter

```sql
-- Details
SELECT * FROM dbacademy.basic_sql_for_databricks_sql_sales_gold;

-- Counter: Prefix, Suffix, Formatting, Rows or Value
SELECT sum(total_price) Total_Sales, 3000000 Sales_Goal FROM dbacademy.basic_sql_for_databricks_sql_sales_gold;
```

### Area, Pie, Line, Heatmap, Scatter, and Box

```sql
-- Area, Pie, Line, and Heatmap Chart
-- Area, Pie, Line: (product_category, Total_Sales), Sort Order
-- HeatMap: (Month, product_category, Color:Total Sales, Color Schemes

SELECT customer_name, total_price Total_Sales, month(order_date) Month, product_category FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
    WHERE order_date >= '2019-08-01'
    AND order_date <= '2019-10-31';


-- Scatterplot (units, price)
SELECT c.customer_name, sum(c.units_purchased) units, sum(s.total_price) price FROM dbacademy.basic_sql_for_databricks_sql_customers c
    INNER JOIN dbacademy.basic_sql_for_databricks_sql_sales_gold s
    on string(c.customer_id) = s.customer_id
    WHERE c.state = 'CA' 
    OR c.state = 'NY'
    GROUP BY c.customer_name;


-- Boxplot (product_category, total_price), Min-Max Scale 
SELECT * FROM dbacademy.basic_sql_for_databricks_sql_sales_gold;

-- Combo: Bar + Line, (customer_name, (price, units))
-- Use scatter plot query
```

### Pivot, Funnel, and Word Cloud

```sql
-- Pivot Table
-- Note: Table Heatmap Feature, TSV, Diff Aggregate Functions
SELECT month(order_date) Month, product_category Category FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
    WHERE order_date >= '2019-08-01'
    AND order_date <= '2019-10-31'
    ORDER BY month(order_date);


-- Funnel
WITH funnel AS (
    SELECT DISTINCT "Customers" AS Step, string(customer_id) FROM dbacademy.basic_sql_for_databricks_sql_customers
        UNION ALL
    SELECT DISTINCT "Orders" AS Step, customer_id FROM dbacademy.basic_sql_for_databricks_sql_silver_sales_orders
        UNION ALL
    SELECT DISTINCT "Sales" AS Step, customer_id FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
)
SELECT Step, count(customer_id) as Value 
    FROM funnel
    GROUP BY Step;


-- Word Cloud
SELECT * FROM dbacademy.data_visualization_on_databricks_sql_web_events;

### Map (Choropleth and Markers)

-- Map
SELECT state, count(customer_id) 
    FROM dbacademy.basic_sql_for_databricks_sql_customers
    GROUP BY state;

-- SELECT * from dbacademy.basic_sql_for_databricks_sql_customers;
```

### Sankey and Sunburst

```sql
-- Sankey and Sunburst
WITH calculate_time AS
    (SELECT 
        session_id,
        time,
        page,
        time - LAG(time,1) OVER (PARTITION BY session_id ORDER BY time) AS time_to_last_event
    FROM dbacademy.data_visualization_on_databricks_sql_web_events),
    
    events AS
    (SELECT 
        session_id,
        page,
        time AS session_start,
        COALESCE(LEAD(string(time),1) OVER (PARTITION BY session_id ORDER BY time),'2021-01-01') AS session_end,
        ROW_NUMBER() OVER (PARTITION BY session_id ORDER BY time) AS event_number
    FROM calculate_time),
 
    sequence AS
    (SELECT session_id,
        MAX(CASE WHEN event_number = 1 THEN page ELSE NULL END) AS e1,
        MAX(CASE WHEN event_number = 2 THEN page ELSE NULL END) AS e2,
        MAX(CASE WHEN event_number = 3 THEN page ELSE NULL END) AS e3,
        MAX(CASE WHEN event_number = 4 THEN page ELSE NULL END) AS e4,
        MAX(CASE WHEN event_number = 5 THEN page ELSE NULL END) AS e5
    FROM events
    GROUP BY session_id)

SELECT e1,
    e2,
    e3,
    e4,
    e5,
    COUNT(*) AS value 
FROM sequence
GROUP BY e1, e2, e3, e4, e5
ORDER BY value DESC
```

### Cohort

```sql
-- Cohort
-- Date: Cohort_date, Stage: month_number, Bucket Population: Total, Stage Value: Value
-- Time Int: Monthly  
WITH
population AS (
    SELECT to_date(from_unixtime(valid_from)) AS cohort_date, customer_id
    FROM dbacademy.basic_sql_for_databricks_sql_customers
),
activity AS (
    SELECT order_date AS activity_date, dbacademy.basic_sql_for_databricks_sql_sales_gold.customer_id AS unique_id, cohort_date 
    FROM dbacademy.basic_sql_for_databricks_sql_sales_gold
    INNER JOIN population ON string(population.customer_id) = dbacademy.basic_sql_for_databricks_sql_sales_gold.customer_id
    WHERE month(order_date) > 3
),
population_agg AS (
    SELECT cohort_date, count(customer_id) AS total
    FROM population
    GROUP BY cohort_date
)
SELECT activity.cohort_date as cohort_date,
    month(activity_date) - 7 AS month_number,
    count(unique_id) AS value,
    total
    FROM activity
    INNER JOIN population_agg ON activity.cohort_date = population_agg.cohort_date
    GROUP BY month(activity_date) - 7, activity.cohort_date, population_agg.total
```
