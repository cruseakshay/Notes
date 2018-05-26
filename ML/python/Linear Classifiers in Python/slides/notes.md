# Linear Classifiers in Python

## Applying logistic regression and SVM

[Dataset used](http://ai.stanford.edu/~amaas/data/sentiment/)

- Underfitting: model is too simple, low training accuracy
- Overfitting: model is too complex, low test accuracy
- Refer for Visualizing decision boundaries [Plot different SVM classifiers in the iris dataset](http://scikit-learn.org/stable/auto_examples/svm/plot_iris.html)

## Loss functions

0-1 loss function for classification

scipy.optimize.minimize for optimizing functions

w@X represents the DOT product.

Logistic Loss (use plot x = raw model output, y = loss)

Hinge loss in SVM

## Logistic regression

smaller values of C lead to less confident predictions. That's because smaller C means more regularization, which in turn means smaller coefficients, which means raw model outputs closer to zero and, thus, probabilities closer to 0.5 after the raw model output is squashed through the sigmoid function.