# Extreme Gradient Boosting with XGBoost

## Notes

### Course Description

Gradient boosting is currently one of the most popular techniques for efficient modeling of tabular datasets of all sizes. XGboost is a very fast, scalable implementation of gradient boosting.

In this course, you'll learn how to use this powerful library alongside pandas and scikit-learn to build and tune supervised learning models.

### Classification with XGBoost(ensemble algorithm)

XGBoost is popular because of its Speed and performance. Its core algorithm is parallelizable even on GPUs.

### Regression with XGBoost


### Fine-tuning your XGBoost model

Early stopping works by testing the XGBoost model after every boosting round against a hold-out dataset and stopping the creation of additional boosting rounds (thereby finishing training of the model early) if the hold-out metric ("rmse" in our case) does not improve for a given number of rounds.

Bear in mind that if the holdout metric continuously improves up through when num_boosting_rounds is reached, then early stopping does not occur.

tuning the "eta", also known as the learning rate.

max_depth, which is the parameter that dictates the maximum depth that each tree in a boosting round can grow to. Smaller values will lead to shallower trees, and larger values to deeper trees.

Tuning colsample_bytree: (max_features in scikit). In both xgboost and sklearn, this parameter (although named differently) simply specifies the fraction of features to choose from at every split in a given tree. In xgboost, colsample_bytree must be specified as a float between 0 and 1.

"subsample", which dictates the fraction of the training data that is used during any given boosting round. 

GridSearchCV and RandomizedSearchCV : to find the best model exhaustively from a collection of possible parameter values across multiple parameters simultaneously.

 Scikit-learn has a LabelEncoder function that converts the values in each categorical column into integers. 

 Using a DictVectorizer on a DataFrame that has been converted to a dictionary allows you to get label encoding as well as one-hot encoding in one go.

### Kidney disease case study

[chronic kidney disease dataset](https://archive.ics.uci.edu/ml/datasets/chronic_kidney_disease)

The chronic kidney disease dataset contains both categorical and numeric features, but contains lots of missing values. The goal here is to predict who has chronic kidney disease given various blood indicators as features.

- sklearn_pandas, that allows you to chain many more processing steps inside of a pipeline than are currently supported in scikit-learn.
  - Categorical_Imputer(), impute missing categorical values
  - DataFrameMapper(), to apply any arbitrary sklearn-compatible transformer on DataFrame columns, where the resulting output can be either a NumPy array or DataFrame.

 FeatureUnion : Concatenates results of multiple transformer objects.

## For more in XGBoost

- Using XGBoost for ranking/recommendation problems (Netflix/Amazon problem)
- Using more sophisticated hyperparameter tuning strategies for tuning XGBoost models (Bayesian Optimization)
- Using XGBoost as part of an ensemble of other models for regression/classification

 Using a DictVectorizer on a DataFrame that has been converted to a dictionary allows you to get label encoding as well as one-hot encoding in one go.

 ### Using XGBoost in pipelines

 > Refer chapter slides.

 > A good source of links with example code and help is the [Awesome XGBoost page.](https://github.com/dmlc/xgboost/tree/master/demo)