# The Elements of Statistical Learning

## Overview of Supervised Learning

input/predictors/independent variables/features/

output/response/dependent variable

### Variable Types and Terminology

quantitative measurement

qualitative measures

Qualitative variables are also referred to as categorical or discrete variables as well as factors.

ordered categorical : such as small, medium and large, where there is an ordering between the values, but no metric notion is appropriate

regression when we predict quantitative outputs

classification when we predict qualitative outputs.

Qualitative variables are typically represented numerically by codes.
The most useful and commonly used coding is via dummy variables.
K-level qualitative variable is represented by a vector of K binary variables
or bits, only one of which is “on” at a time.

### Two Simple Approaches to Prediction: Least Squares and Nearest Neighbors

The linear model makes huge assumptions about structure and yields stable but possibly inaccurate predictions.

The method of k-nearest neighbors makes very mild structural assumptions: its predictions are often accurate but can be unstable.

#### Linear Models and Least Squares

