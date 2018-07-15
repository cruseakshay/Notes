# Importing and Managing Financial Data in R

## Introduction and downloading data

# Load the quantmod package
library(quantmod)

# Import QQQ data from Yahoo! Finance
getSymbols("QQQ", auto.assign = TRUE)

# Look at the structure of the object getSymbols created
str(QQQ)

# Look at the first few rows of QQQ
head(QQQ)

# Data sources
# Import QQQ data from Alpha Vantage
getSymbols("QQQ", src = "av")

# Look at the structure of QQQ
str(QQQ)

# Import GDP data from FRED
getSymbols("GDP", src = "FRED")

# Look at the structure of GDP
str(GDP)