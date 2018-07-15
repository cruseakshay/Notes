# Importing and Managing Financial Data in R

## Introduction and downloading data
The getSymbols() function from the quantmod package provides a consistent interface to import data from various sources into your workspace. By default, getSymbols() imports the data as a xts object.

Yahoo! Finance is the default data source for getSymbols().

You use the Symbols argument to specify the instrument (i.e. the ticker symbol) you want to import. Since Symbols is the first argument to getSymbols(), you usually just type the instrument name and omit Symbols =.

The src values for Alpha Vantage and FRED are "av" and "FRED", respectively.