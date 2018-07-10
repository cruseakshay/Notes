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