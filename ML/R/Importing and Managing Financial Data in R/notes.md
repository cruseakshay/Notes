# Importing and Managing Financial Data in R

## Introduction and downloading data

The getSymbols() function from the quantmod package provides a consistent interface to import data from various sources into your workspace. By default, getSymbols() imports the data as a xts object.

Yahoo! Finance is the default data source for getSymbols().

You use the Symbols argument to specify the instrument (i.e. the ticker symbol) you want to import. Since Symbols is the first argument to getSymbols(), you usually just type the instrument name and omit Symbols =.

The src values for Alpha Vantage and FRED are "av" and "FRED", respectively.

**Introducing Quandl()**
the Quandl package provides access to the Quandl databases via one simple function: Quandl().

The Quandl() function specifies both the data source and the instrument via its code argument, in the form "DATABASE/DATASET".

- Two other ways Quandl() differs from getSymbols() are:
  - Quandl() returns a data.frame by default.
  - Quandl() will not automatically assign the data to an object.

The Quandl() function returns a data.frame by default. It can return other classes via the type argument.

- The possible values for type are:
  - "raw" (a data.frame),
  - "ts" (time-series objects from the stats package),
  - "zoo",
  - "xts", and
  - "timeSeries" (from the timeSeries package in the RMetrics suite).

## Extracting and transforming data

The quantmod package provides several helper functions to extract specific columns from an object, based on the column name. The Op(), Hi(), Lo(), Cl(), Vo(), and Ad() functions can be used to extract the open, high, low, close, volume, and adjusted close column, respectively.

The getPrice() function in the quantmod package can extract any column by name by using the prefer argument. It can also extract columns for a specific instrument by using the symbol argument, which is useful when an object contains several instruments with the same price type.

You can use regular expressions for both the prefer and symbol arguments, because they are passed to the base::grep() function internally.

The Quandl() function allows you to specify common **aggregations** and **transformations** via the collapse and/or transform arguments.

use eapply() to call a function on each object in the environment, much like what lapply() does for each element of a list.

do.call(merge, my_list) to merge lists into one.

## Managing data from multiple sources

The first argument to setDefaults() is the function you want to update, and the remaining arguments are name = value pairs of the arguments you want to update and the new default value.

Note that this only works with getSymbols() because getSymbols() actively checks to see if you want to use a different default value.

You can find the arguments for a specific method by using help() (e.g. help("getSymbols.yahoo") or by calling args() to print them to the console

You can use setSymbolLookup() to specify the default data source for an instrument.

setSymbolLookup() can take any number of name = value pairs, where name is the symbol and value is a named list of getSymbols() arguments for that one symbol.

how to save and load symbol-based defaults by using saveSymbolLookup() and loadSymbolLookup(), respectively. You can use the file arguments to specify a file to store your defaults.

- Access the object using get() or backticks
  At some point, you might download data for an instrument that does not have a syntactically valid name.
  You can use the get function or backticks (`) to access objects that do not have syntactically valid names.

- Create valid names for multiple instruments
  You can also use setSymbolLookup() to create a mapping between the instrument symbol and the name of the R object.
  setSymbolLookup(NEW_NAME = list(name = "OLD_NAME"))

## Aligning data with different periodicities

- To create regular data from an irregular data set
  In order to create regular data from an irregular data set, the first thing you need is a regular sequence of date-times that span the dates of your irregular data set. A "regular" sequence of date-times has equally-spaced time points.

  A zero-width xts object has an index of date-times, but no data columns.

Sometimes two series have the same periodicy, but use different conventions to represent a timestamp. For example, monthly series may be timestamped with the first or last date of the month. The different timestamp convention can cause many NA when series are merged. The yearmon class from the zoo package helps solve this problem.

- Align series to first and last day of month
  First you merge the lower-frequency data with the aggregate data, then use na.locf() to fill the NA forward (or backward, using fromLast = TRUE). Then you can subset the result using the index of the object with the representation you prefer.

- Aggregate to weekly, ending on Wednesdays
  In this exercise, you will learn a general aggregation technique to aggregate daily data to weekly, but with weeks ending on Wednesdays. This is often done in stock market research to avoid intra-week seasonality.

  You can supply your own end points to period.apply() (versus using endpoints()). Recall endpoints() returns locations of the last observation in each period specified by the on argument. The first and last elements of the result are always zero and the total number of observations, respectively. The end points you pass to period.apply() must follow this convention.

## Importing text data, and adjusting for corporate actions

well-formatted file contains data for a single instrument with date, open, high, low, close, volume, and adjusted close columns, in that order. 