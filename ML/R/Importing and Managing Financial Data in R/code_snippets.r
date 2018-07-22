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

# Assign SPY data to 'spy' using auto.assign argument
spy <- getSymbols("SPY", auto.assign = FALSE)

# Look at the structure of the 'spy' object
str(spy)

# Assign JNJ data to 'jnj' using env argument
jnj <- getSymbols("JNJ", env = NULL)

# Look at the structure of the 'jnj' object
str(jnj)

# Load the Quandl package
library(Quandl)

# Import GDP data from FRED
gdp <- Quandl(code = "FRED/GDP")

# Look at the structure of the object returned by Quandl
str(gdp)

# Import GDP data from FRED as xts
gdp_xts <- Quandl(code = "FRED/GDP", type = "xts")

# Look at the structure of gdp_xts
str(gdp_xts)

# Import GDP data from FRED as zoo
gdp_zoo <- Quandl(code = "FRED/GDP", type = "zoo")

# Look at the structure of gdp_zoo
str(gdp_zoo)

# Create an object containing the Pfizer ticker symbol
symbol <- "PFE"

# Use getSymbols to import the data
getSymbols(symbol)

# Look at the first few rows of data
head(PFE)

# Download exchange rate data from Oanda
# Create a currency_pair object
currency_pair <- "GBP/CAD"

# Load British Pound to Canadian Dollar exchange rate data
getSymbols(currency_pair, src = "oanda")

# Examine object using str()
str(GBPCAD)

# Try to load data from 190 days ago
getSymbols(currency_pair, from = Sys.Date() - 190, to = Sys.Date(), src = "oanda")

# Create a series_name object
series_name <- "UNRATE"

# Load the data using getSymbols
getSymbols(series_name, src = "FRED")

# Create a quandl_code object
quandl_code <- "FRED/UNRATE"

# Load the data using Quandl
unemploy_rate <- Quandl(quandl_code)

# Extracting and transforming data
# Extract the close column
dc_close <- Cl(DC)

# Look at the head of dc_close
head(dc_close)

# Extract the volume column
dc_volume <- Vo(DC)

# Look at the head of dc_volume
head(dc_volume)

# Extract the high, low, and close columns
dc_hlc <- HLC(DC)

# Look at the head of dc_hlc
head(dc_hlc)

# Extract the open, high, low, close, and volume columns
dc_ohlcv <- OHLCV(DC)

# Look at the head of dc_ohlcv
head(dc_ohlcv)

# Download CME data for CL and BZ as an xts object
oil_data <- Quandl(code = c("CME/CLH2016", "CME/BZH2016"), type = "xts")

# Look at the column names of the oil_data object
colnames(oil_data)

# Extract the Open price for CLH2016
cl_open <- getPrice(oil_data, symbol = "CLH2016", prefer = "Open$")

# Look at January, 2016 using xts' ISO-8601 subsetting
cl_open["2016-01"]

# Use Quandl to download weekly returns data
# Download quarterly CL and BZ prices
qtr_price <- Quandl(code = c("CME/CLH2016", "CME/BZH2016"), collapse = "quarterly", type = "xts")

# View the high prices for both series
Hi(qtr_price)

# Download quarterly CL and BZ returns
qtr_return <- Quandl(code = c("CME/CLH2016", "CME/BZH2016"), collapse = "quarterly", type = "xts", transform = "rdiff")

# View the settle price returns for both series
getPrice(qtr_return, prefer = "Settle")

# Combine many instruments into one object
# Call head on each object in data_env using eapply
data_list <- eapply(data_env, FUN = head)

# Merge all the list elements into one xts object
data_merged <- do.call(merge, data_list)

# Ensure the columns are ordered: open, high, low, close
data_ohlc <- OHLC(data_merged)

# Symbols
symbols <- c("AAPL", "MSFT", "IBM")

# Create new environment
data_env <- new.env()

# Load symbols into data_env
getSymbols(symbols ,env = data_env)

# Extract the close column from each object and combine into one xts object
close_data <- do.call(merge, eapply(data_env, Cl))

# View the head of close_data
head(close_data)

# ch-3 Managing data from multiple sources

# Set a default data source
# Set the default to pull data from Alpha Vantage
setDefaults(getSymbols, src = "av")

# Get GOOG data
getSymbols("GOOG")

# Verify the data was actually pulled from Alpha Vantage
str(GOOG)

# Look at getSymbols.yahoo arguments
args(getSymbols.yahoo)

# Set default 'from' value for getSymbols.yahoo
setDefaults(getSymbols.yahoo, from = "2000-01-01")

# Confirm defaults were set correctly
getDefaults('getSymbols.yahoo')

# Set default data source for one symbol
# Look at the first few rows of CP
head(CP)

# Set the source for CP to FRED
setSymbolLookup(CP = "FRED")

# Load CP data again
getSymbols("CP")

# Look at the first few rows of CP
head(CP)

# Save and load symbol lookup table
# Save symbol lookup table
saveSymbolLookup(file = "my_symbol_lookup.rda")

# Set default source for CP to "yahoo"
setSymbolLookup(CP = "yahoo")

# Verify the default source is "yahoo"
getSymbolLookup('CP')

# Load symbol lookup table
loadSymbolLookup('my_symbol_lookup.rda')

# Access the object using get() or backticks
# Load BRK-A data
getSymbols("BRK-A")

# Use backticks and head() to look at the loaded data
head(`BRK-A`)

# Use get() to assign the BRK-A data to an object named BRK.A
BRK.A <- get("BRK-A")

# Create valid name for one instrument
# Create BRK.A object
BRK.A <- getSymbols("BRK-A", auto.assign = FALSE)

# Create col_names object with the column names of BRK.A
col_names <- colnames(BRK.A)

# Set BRK.A column names to syntactically valid names
colnames(BRK.A) <- make.names(col_names) 

# Create valid names for multiple instruments
# Set name for BRK-A to BRK.A
setSymbolLookup(BRK.A = list(name = "BRK-A"))

# Set name for T (AT&T) to ATT
setSymbolLookup(ATT = list(name = "T"))

# Load BRK.A and ATT data
getSymbols(c("BRK.A", "ATT"))

# ch-4 Aligning data with different periodicities
# Extract the start date of the series
start_date <- start(irregular_xts)

# Extract the end date of the series
end_date <- end(irregular_xts)

# Create a regular date sequence
regular_index <- seq(from = start_date, to = end_date, by = "day")

# Create a zero-width xts object
regular_xts <- xts(, order.by = regular_index)

# Use merge to make an irregular index regular

# The previous exercise taught you how to make a zero-width xts object with a regular time index. 
# You can use the zero-width object to regularize an irregular xts object.

# Merge irregular_xts and regular_xts
merged_xts <- merge(regular_xts, irregular_xts)

# Look at the first few rows of merged_xts
head(merged_xts)

# Use the fill argument to fill NA with their previous value
merged_filled_xts <- merge(regular_xts, irregular_xts, fill = na.locf) # locf: last observation comes first

# Look at the first few rows of merged_filled_xts
head(merged_filled_xts)

# Aggregate daily data and merge with monthly data
# DATA : getSymbols(c("FEDFUNDS", "DFF"), src = "FRED")
# Aggregate DFF to monthly
monthly_fedfunds <- apply.monthly(DFF, FUN = mean)

# Convert index to yearmon
index(monthly_fedfunds) <- as.yearmon(index(monthly_fedfunds))


# Merge FEDFUNDS with the monthly aggregate
merged_fedfunds <- merge(FEDFUNDS, monthly_fedfunds)

# Look at the first few rows of the merged object
head(merged_fedfunds)

# Align series to first and last day of month
# Fill NA forward
merged_fedfunds_locf <- na.locf(merged_fedfunds)

# Extract index values containing last day of month
aligned_last_day <- merged_fedfunds_locf[index(monthly_fedfunds)]

# Fill NA backward
merged_fedfunds_locb <- na.locf(merged_fedfunds,fromLast = TRUE)

# Extract index values containing first day of month
aligned_first_day <- merged_fedfunds_locb[index(FEDFUNDS)]

# Aggregate to weekly, ending on Wednesdays
# Extract index weekdays
index_weekdays <- .indexwday(DFF)

# Find locations of Wednesdays
wednesdays <- which(index_weekdays == 3)

# Create custom end points
end_points <- c(0, wednesdays, nrow(DFF))

# Calculate weekly mean using custom end points
weekly_mean <- period.apply(DFF, end_points, mean)

# Combine data that have timezones
c# Create merged object with a Europe/London timezone
tz_london <- merge(london, chicago)

# Look at tz_london structure
str(tz_london)

# Create merged object with a America/Chicago timezone
tz_chicago <- merge(chicago, london)

# Look at tz_chicago structure
str(tz_chicago)

# Make irregular intraday-day data regular
# exercise assumes markets open at 9AM and close at 4PM Monday-Friday.
# Create a regular date-time sequence
regular_index <- seq(as.POSIXct("2010-01-04 09:00"), as.POSIXct("2010-01-08 16:00"), by = "30 min")

# Create a zero-width xts object
regular_xts <- xts(, order.by = regular_index)

# Merge irregular_xts and regular_xts, filling NA with their previous value
merged_xts <- merge(regular_xts, irregular_xts, fill = na.locf)

# Subset to trading day (9AM - 4PM)
trade_day <- merged_xts["T09:00/T16:00"]

# Fill missing values by trading day
# split-lapply-rbind 
# Split trade_day into days
daily_list <- split(trade_day , f = "days")

# Use lapply to call na.locf for each day in daily_list
daily_filled <- lapply(daily_list, FUN = na.locf)

# Use do.call to rbind the results
filled_by_trade_day <- do.call(rbind, daily_filled)

# Aggregate irregular intraday-day data
# Convert raw prices to 5-second prices
xts_5sec <- to.period(intraday_xts, period = "seconds", k = 5)

# Convert raw prices to 10-minute prices
xts_10min <- to.period(intraday_xts, period = "minutes", k = 10)

# Convert raw prices to 1-hour prices
xts_1hour <- to.period(intraday_xts, period = "hours", k = 1)

# ch-5 Importing text data, and adjusting for corporate actions
# Import well-formatted daily OHLC data
# NOTE: AMZN.csv file is in curr dir
# Load AMZN.csv
getSymbols("AMZN", src="csv")

# Look at AMZN structure
str(AMZN)

# Import text files in other formats
# Import AMZN.csv using read.zoo
amzn_zoo <- read.zoo("AMZN.csv", sep = ",", header = TRUE)

# Convert to xts
amzn_xts <- as.xts(amzn_zoo)

# Look at the first few rows of amzn_xts
head(amzn_xts)

# Handle date and time in separate columns
# Read data with read.csv
une_data <- read.csv("UNE.csv", nrows = 5)

# Look at the structure of une_data
str(une_data)

# Read data with read.zoo, specifying index columns
une_zoo <- read.zoo("UNE.csv", index.column = c("Date", "Time"), sep = ",", header = TRUE)

# Look at first few rows of data
head(une_zoo)

# Read text file containing multiple instruments
# Read data with read.csv
two_symbols_data <- read.csv("two_symbols.csv", nrows = 5)

# Look at the structure of two_symbols_data
str(two_symbols_data)

# Read data with read.zoo, specifying index columns
two_symbols_zoo <- read.zoo("two_symbols.csv", split = c("Symbol", "Type"), sep = ",", header = TRUE)

# Look at first few rows of data
head(two_symbols_zoo)

# Handle missing values
# fill NA using last observation carried forward
locf <- na.locf(DGS10)

# fill NA using linear interpolation
approx <- na.approx(DGS10)

# fill NA using spline interpolation
spline <- na.spline(DGS10)

# merge into one object
na_filled <- merge(locf,approx, spline)

# plot combined object
plot(na_filled, col = c("black", "red", "green"))

# Visualize imported data
# Look at the last few rows of AAPL data
tail(AAPL)

# Plot close price
plot(Cl(AAPL))

# Plot adjusted close price
plot(Ad(AAPL))

# Cross reference sources
# Look at first few rows of aapl_raw
head(aapl_raw)

# Look at first few rows of aapl_split
head(aapl_split_adjusted)

# Plot difference between adjusted close and split-adjusted close
plot(Ad(aapl_raw) - Cl(aapl_split_adjusted))

# Plot difference between volume from the raw and split-adjusted sources
plot(Vo(aapl_raw) - Vo(aapl_split_adjusted))

# Adjust for stock splits and dividends
# Look at first few rows of AAPL
head(AAPL)

# Adjust AAPL for splits and dividends
aapl_adjusted <- adjustOHLC(AAPL)

# Look at first few rows of aapl_adjusted
head(aapl_adjusted)

# Download split and dividend data
# Download AAPL split data
splits <- getSplits("AAPL")

# Download AAPL dividend data
dividends <- getDividends("AAPL")

# Look at the first few rows of dividends
head(dividends)

# Download unadjusted AAPL dividend data
raw_dividends <- getDividends("AAPL", split.adjust = FALSE)

# Look at the first few rows of raw_dividends
head(raw_dividends)

# Adjust univariate data for splits and dividends
# Calculate split and dividend adjustment ratios
ratios <- adjRatios(splits = splits, dividends = raw_dividends, close = Cl(AAPL))

# Calculate adjusted close for AAPL
aapl_adjusted <- Cl(AAPL) * ratios[, "Split"] * ratios[, "Div"]

# Look at first few rows of Yahoo adjusted close
head(Ad(AAPL))

# Look at first few rows of aapl_adjusted
head(aapl_adjusted)