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