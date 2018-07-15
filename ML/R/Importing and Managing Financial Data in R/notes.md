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
