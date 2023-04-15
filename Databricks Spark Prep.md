# Questions for preparation on Apache Spark.

## How to handle Bad Records in CSV/JSON etc.
mode = [ PERMISSIVE | DROPMALFORMED | FAILFAST ]

PERMISSIVE, which is the default value, the parser will try to parse all the rows in the CSV file, even if they contain missing or malformed data. 
The parser will replace missing or malformed data with null values and continue parsing the rest of the rows.

DROPMALFORMED, the parser will drop any row that contains missing or malformed data and return only the rows that are well-formed.

FAILFAST, the parser will stop parsing the file as soon as it encounters a row with missing or malformed data, 
and it will throw an exception indicating the location of the error.

```python
from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("Read CSV File with Corrupt Records").getOrCreate()

# if we want a new column with malformed strings from the data.
df = spark.read \
    .option("header", "true") \
    .option("mode", "PERMISSIVE") \
    .option("columnNameOfCorruptRecord", "corrupt_record") \
    .csv("path/to/csv/file.csv")

df.show()
```

## how to get list of DFs available

```python
from pyspark.sql import DataFrame

[k for (k, v) globals().items() if isinstance(v,DataFrame)]

# OR

# Get the Catalog object
catalog = spark.catalog

# Get a list of all the available DataFrames
dataframes = catalog.listTables()

# Print the names of the DataFrames
for dataframe in dataframes:
    print(dataframe.name)
```

## Adding source file name in the dataframe as column.

```python
from pyspark.sql.functions input_file_name

# Use withColumn on Dataframe.
df.withColumn("file_name" ,input_file_name())
```

## Number of records in each file present in DIR.

```python
from pyspark.sql.functions input_file_name

df = spark.read.csv("path/to/dir/*csv", header=True)
df = df.withColumn("file_name" ,input_file_name())

display(df.grouby("file_name").count())
```

## Add partition id to the dataframe.
```python
from pyspark.sql.functions spark_partition_id

df = spark.read.csv("path/to/dir/*csv", header=True)
df = df.withColumn("partition_id" ,spark_partition_id())

# number of partition
display(df.select("partition_id").distinct())


# count by partition
display(df.grouby("partition_id").count())
```

## Adding surrogate key to the dataframe.

monotonically_increasing_id - not preferred in scenarios where other table depend on this as it changes/vavries on table regeneration.
Hash key -
  - md5 - can get duplicates in some scenarios where data is v.large 
  - sha2 - mostly used.

```python
from pyspark.sql.functions monotonically_increasing_id, md5, sha2

df = spark.read.csv("path/to/dir/*csv", header=True)
df = df.withColumn("key" ,monotonically_increasing_id()) 
```

## Difference between global temporary view and temporary view.

**Temporary View**: A temporary view is tied to a SparkSession and is only available to the current session. 
When the SparkSession that created the temporary view is terminated, the view is automatically dropped. 
Temporary views are created using the **createOrReplaceTempView()** method of a DataFrame or a SQL query result.

**Global Temporary View**: A global temporary view is tied to a Spark application and is available to all sessions. 
Global temporary views are created using the **createOrReplaceGlobalTempView()** method of a DataFrame or a SQL query result. 
The name of a global temporary view starts with **global_temp.** prefix.


## List databases, tables, views and columns.

```python

spark.catalog.listDatabases()
spark.catalog.listTables("db_name")
spark.catalog.listColumns("tbl_name","db_name")

```
