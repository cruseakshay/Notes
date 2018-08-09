# Manipulating Time Series Data in R with xts & zoo

## Introduction to eXtensible Time Series, using xts and zoo for time series

[What is an xts object?](https://www.rdocumentation.org/packages/xts/versions/0.9-7/topics/xts)

At the core of both xts and zoo is a simple R matrix with a few additional attributes. 
The most important of these attributes is the index. 
The index holds all the information we need for xts to treat our data as a time series.

![coredata()](http://www.rdocumentation.org/packages/xts/versions/0.9-7/topics/coredata.xts)
![index()](http://www.rdocumentation.org/packages/zoo/versions/1.7-13/topics/index)

xts objects get their power from the index attribute that holds the time dimension. One major difference between xts and most other time series objects in R is the ability to use any one of various classes that are used to represent time.

[saveRDS() and readRDS()](https://www.rdocumentation.org/packages/base/versions/3.3.1/topics/readRDS)

One of the best ways to write an xts object from R is to use the zoo function [write.zoo()](https://www.rdocumentation.org/packages/zoo/versions/1.7-13/topics/read.zoo).

## First Order of Business - Basic Manipulations

[The ISO-8601 standard](https://en.wikipedia.org/wiki/ISO_8601)

it is sometimes necessary to view only a subset of time for each day over multiple days. Using xts, you can slice days easily by using special notation in the i = argument to the single bracket extraction (i.e. [i, j]).

use the special T/T notation designed for intraday repeating intervals.

# Intraday times for all days
NYSE["T09:30/T16:00"]