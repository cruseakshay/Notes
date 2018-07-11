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
**Logical Operators: For checking multiple relational conditions at once** 
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
This is the simplest loop. You must specify when you want to break out of the loop using *break* keyword. Otherwise it runs for eternity!

```R
repeat {
    # code goes here
    if(condition) {
        break
    }
}
```
