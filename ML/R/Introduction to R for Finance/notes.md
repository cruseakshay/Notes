# Introduction to R for Finance

## The Basics

1. financial returns: return multiplier

    multiplier = 1 + (return / 100)

2. *weighted average*: The weighted average allows you to calculate your portfolio return over a time period.
vector Coercesion
It is important to remember that a vector can only be composed of one data type. This means that you cannot have both a numeric and a character in the same vector. If you attempt to do this, the lower ranking type will be coerced into the higher ranking type.

3. relationship between the two stocks?
    One way to capture relationship is by finding the correlation between the two stocks. 
    
    Correlation is a measure of association between two things, here, stock prices, and is represented by a number from -1 to 1. 
    
    A 1 represents perfect positive correlation, a -1 represents perfect negative correlation, and 0 correlation means that the stocks move independently of each other. 
    
    Correlation is a common metric in finance.

    [cor()](https://www.rdocumentation.org/packages/stats/versions/3.3.1/topics/cor)

4. Time value of Money
  - Present value and Future value

  If you expect a cash flow of $100 to be received 1 year from now, what is the present value of that cash flow at a 5% interest rate? 

  To calculate this, you discount the cash flow to get it in terms of today's dollars. The general formula for this is:

  ```present_value <- cash_flow * (1 + interest / 100) ^ -year```

The hierarchy for coercion is:
logical < integer < numeric < character

*names()* function to add names to vector values.

- Vectors
  - vector subsetting

- Matrix
  - [cbind()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/cbind) and [rbind()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/cbind) (column bind and row bind respectively).
  - matrix subsetting

- dataframe
  - [data.frame()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/data.frame)
  - [head()](https://www.rdocumentation.org/packages/utils/versions/3.3.2/topics/head)
  - [tail()](https://www.rdocumentation.org/packages/utils/versions/3.3.2/topics/head)
  - [str()](https://www.rdocumentation.org/packages/utils/versions/3.3.2/topics/str)
  - [colnames()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/row%2Bcolnames)
  - [rownames()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/row%2Bcolnames)
  - delete a column by assigning NULL. ``` cash$col_name <- NULL ```
  - [subset()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/subset)

- factors
  - [factor()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/factor)
  - [levels()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/levels)
  - [summary()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/summary) for tabulating factors.
  - cut() to create factor from Integer vector
### Readings

1. Python for Finance Analyze Big Financial Data By Yves Hilpisch