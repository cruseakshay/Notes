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

plot() can used to visulaise vectors, matrix, dataframe and factor.

[attributes](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/attributes) of datatypes and also [attr()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/attr).

``` attributes(list_A) and attr(list_A, which = "names") ```

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
  - **R's default behavior when creating data frames is to convert all characters into factors.**
  - To get rid of above behaviour ```cash <- data.frame(company, cash_flow, year, stringsAsFactors = FALSE)```.

- factors
  - [factor()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/factor)
  - [levels()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/levels)
  - [summary()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/summary) for tabulating factors.
  - [cut()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/cut) to create factor from Integer vector.
  - [ordered()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/factor)
  - ordered and unordered factors
  - unique() to find unique words

- list
  - [list()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/list)
  - lists in R can be used to hold together items of different data types.
  - names() can be used to name elements of a created list.
  - To access the elements in the list, use [ ]. This will always return another list.
  - To pull out the data inside each element of your list, use [[ ]].
  - If your list is named, you can use the $ operator: This is the same as using [[ ]] to return the inner data.
  - Adding to a list ``` my_list$dans_movie <- "StaR Wars" ```
  - Adding to a list ``` c(my_list, dans_movie = "StaR Wars") ```
  - Removing from a list ``` my_list$dans_movie <- NULL ```
  - Removing from a list, If your list is not named ``` my_list[1] <- NULL or my_list[[1]] <- NULL ```
  - [split()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/split)
  - [unsplit()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/split)

#### Split-Apply-Combine

A common data science problem is to split your data frame by a grouping, apply some transformation to each group, and then recombine those pieces back into one data frame. This is such a common class of problems in R that it has been given the name split-apply-combine.

### Readings

1. Python for Finance Analyze Big Financial Data By Yves Hilpisch