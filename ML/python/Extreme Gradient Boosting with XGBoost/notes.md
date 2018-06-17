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