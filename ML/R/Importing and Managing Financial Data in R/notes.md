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