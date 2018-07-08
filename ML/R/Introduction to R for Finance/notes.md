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
    
The hierarchy for coercion is:
logical < integer < numeric < character

*names()* function to add names to vector values.

Vectors

- Matrix
  - [cbind()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/cbind) and [rbind()](https://www.rdocumentation.org/packages/base/versions/3.3.2/topics/cbind) (column bind and row bind respectively).

### Readings

1. Python for Finance Analyze Big Financial Data By Yves Hilpisch