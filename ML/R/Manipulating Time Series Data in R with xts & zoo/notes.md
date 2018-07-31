# Manipulating Time Series Data in R with xts & zoo

## Introduction to eXtensible Time Series, using xts and zoo for time series

[What is an xts object?](https://www.rdocumentation.org/packages/xts/versions/0.9-7/topics/xts)

At the core of both xts and zoo is a simple R matrix with a few additional attributes. 
The most important of these attributes is the index. 
The index holds all the information we need for xts to treat our data as a time series.

![coredata()](http://www.rdocumentation.org/packages/xts/versions/0.9-7/topics/coredata.xts)
![index()](http://www.rdocumentation.org/packages/zoo/versions/1.7-13/topics/index)