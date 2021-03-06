# Intermediate R for Finance

- Dates in R
  - Sys.Date() to get todays date.
  - R has a lot to offer in terms of dates and times. The two main classes of data for this are Date and POSIXct.
  - Date is used for calendar date objects like "2015-01-22". POSIXct is a way to represent datetime objects like "2015-01-22         08:39:40 EST".
  - From char to date using [as.Date()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/as.Date)
  - the format of "yyyy-mm-dd" is known as ISO format (ISO = International Organization for Standardization).
  - **Internally, dates are stored as the number of days since January 1, 1970, and datetimes are stored as the number of seconds     since then.**
  - format =
    - %Y: 4-digit year (1982)
    - %y: 2-digit year (82)
    - %m: 2-digit month (01)
    - %d: 2-digit day of the month (13)
    - %A: weekday (Wednesday)
    - %a: abbreviated weekday (Wed)
    - %B: month (January)
    - %b: abbreviated month (Jan)
  - you can convert objects that are already dates to differently formatted dates using [format()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/format)
  - you can find the difference between two dates, in days.
  - Equivalently, you could use the [difftime()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/difftime)         function to find the time interval instead.
    ```R
      difftime(tomorrow, today)
      Time difference of 1 days

      # With some extra options!
      difftime(tomorrow, today, units = "secs")
      Time difference of 86400 secs
    ```
  - a few functions that are useful for extracting date components
    - months() - extract month of the input Date
    - weekdays() - to extract the day of the week that input date falls on
    - quarters() - to determine which quarter of the year (Q1-Q4) that input date falls in

- types of relational operators.
  - \> : Greater than
  - \>=: Greater than or equal to
  - < : Less than
  - <=: Less than or equal to
  - ==: Equality
  - !=: Not equal

Relational operators can be used for  Vectorized operations:
    ```R
    apple <- c(120.00, 120.08, 119.97, 121.88)
    datacamp  <- c(118.5, 124.21, 125.20, 120.22)

    apple > datacamp
    [1]  TRUE FALSE FALSE  TRUE

    apple > 120
    [1] FALSE  TRUE FALSE  TRUE
    ```
- Logical Operators: For checking multiple relational conditions at once
  - & (And): An intersection. a & b is true only if both a and b are true.
  - | (Or): A union. a | b is true if either a or b is true.
  - Not operator, Add ! in front of a logical expression, and it will flip that expression from TRUE to FALSE (and vice versa).

  The function is.na() checks for missing data. refer example below
      ```R
        subset(df, !is.na(column_name)) # to get rows without missing data
        subset(df, is.na(column_name))  # to get rows with missing data
      ```

  **IF statement**
      ```R
        if(condition) {
          code
        }
      ```

  **IF-ELSE statement**
      ```R
        if(condition) {
          code if true
        } else {
            code if false
        }
      ```

  **IF-ELSEIF-ELSE statement**
      ```R
        if(condition1) {
          code if condition1 is true
        } else if(condition2) {
            code if condition2 is true
        } else {
            code if both are false
        }
      ```

  **ifelse()**
  A powerful function to know about is ifelse(). It creates an if statement in 1 line of code, and more than that, it works on entire vectors!

  ```R
    apple
    [1] 109.49 109.90 109.11 109.95 111.03 112.12

    ifelse(test = apple > 110, yes = "Buy!", no = "Do nothing!")
    [1] "Do nothing!" "Do nothing!" "Do nothing!" "Do nothing!" "Buy!"
    [6] "Buy!"
  ```

- repeat loop

This is the simplest loop. You must specify when you want to break out of the loop using *break* keyword.
Otherwise it runs for eternity!

```R
repeat {
    # code goes here
    if(condition) {
        break
    }
}
```

- While loops
    ```R
    while (condition) {
        # code goes here
    }
    ```

- for loop
    ```R
    for (value in sequence) {
        # code goes here
    }
    ```
  - Loop over data frame rows
    ```R
    for (row in 1:nrow(df)) {
        # code goes here
    }
    ```

  - Loop over matrix rows
    ```R
    # Loop over my_matrix
    for(row in 1:nrow(my_matrix)) {
        for(col in 1:ncol(my_matrix)) {
            print(my_matrix[row, col])
        }
    }
    ```

- if you just want to skip the current iteration, and continue the loop, you can use the *next* statement.

- Functions
  - for accessing built in documentation ?fun_name
  - *Optional arguments* are ones that don't have to be set by the user, either because they are given a default value, or because    the function can infer them from the other data you have given it.
  - the basic structure of a function:
    ```R
      func_name <- function(arguments, arg_opt=123) {
        # body
      }
    ```
  - The value that a function returns is simply the last executed line of the function body.
  - present value in finanace
    ```R
    # Present value function
    pv <- function(cash_flow, i, year) {
        # Discount multiplier
        mult <- 1 + percent_to_decimal(i)
        # Present value calculation
        cash_flow * mult ^ -year
    }

    # Calculate a present value
    # Calculate the present value of $1200, at an interest rate of 7%, to be received 3 years from now.
    pv(1200, 7, 3)
    ```

- Packages
  - for installing in local machine *install.packages("tidyquant")*
  - for loading in current session *library(tidyquant)*

- Sharpe Ratio [Finance] {refer last chapter slides}

- Apply Family of functions.
  - lapply() on a list/dataframe
    ```R
      # Using lapply
      # Note that you don't need parenthesis when calling length
      lapply(my_iter, FUN = length)
    ```
  - In the call to lapply() you can specify the named optional arguments after the FUN argument, and they will get passed to the function that you are applying.
    ```R
      lapply(my_list, FUN = percent_to_decimal, digits = 4)
    ```
  - sapply() on a list/dataframe, returns the output in simplified format that is suitable for further analysis.
  - For interactive use, sapply() is great. It guesses the output type so that it can simplify, and normally that is fine. However, sapply() is not a   safe option to be used when writing functions. If sapply() cannot simplify your output, then it will default to returning a list just like lapply   (). This can be dangerous and break custom functions if you wrote them expecting sapply() to return a simplified vector.
  - vapply() : is more robust as it throws error if the output of the function doen't confirm FUN.VALUE
    ```R
      vapply(market_crash, class, FUN.VALUE = character(1))
    ```

- Named function And Anonymous function
  - anonymous functions are basically functions that aren't assigned a name
    ```R
      vapply(stock_return, FUN = function(percent) { percent / 100 }, FUN.VALUE = numeric(2))
    ```