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

## Intraday times for all days

NYSE["T09:30/T16:00"]

## Find the first or last period of time

[first() and last()](https://www.rdocumentation.org/packages/xts/versions/0.9-7/topics/first)

## Matrix arithmetic - add, subtract, multiply, and divide in time!

xts objects respect time. By design when you perform any binary operation using two xts objects, these objects are first aligned using the intersection of the indexes. This may be surprising when first encountered.

if you want to preserve the dimensions of your data.
- Your options include:
  - Use coredata() or as.numeric() (drop one to a matrix or vector).
  - Manually shift index values - i.e. use lag().
  - Reindex your data (before or after the calculation).

## Math with non-overlapping indexes
# Add a to b, and fill all missing rows of b with 0
a + merge(b, index(a), fill = 0)

## Add a to b and fill NAs with the last observation
a + merge(b, index(a), fill = na.locf)

## Merging and modifying time series
merge() takes three key arguments which we will emphasize here. 
First is the ..., which lets you pass in an arbitrary number of objects to combine.
The second argument is join, which specifies how to join the series - accepting arguments such as inner or left.
This is similar to a relational database join, only here, the index is what we join on. The final argument for this exercise is fill. This keyword specifies what to do with the new values in a series if there is missingness introduced as a result of the merge.

## Apply and aggregate by time
The main function in xts to facilitate this is [endpoints()](http://www.rdocumentation.org/packages/xts/versions/0.9-7/topics/endpoints). It takes a time series (or a vector of times) and returns the locations of the last observations in each interval. \

