# XGBoost: Fit/Predict

# churn data: This dataset contains imaginary data from a ride-sharing app with user behaviors over their first month of app usage 
#             in a set of imaginary cities as well as whether they used the service 5 months after sign-up.

# Your goal is to use the first month's worth of data to predict whether the app's users will remain users of the service at the 5 month mark.
# This is a typical setup for a churn prediction problem.

# Import xgboost
import xgboost as xgb

# Create arrays for the features and the target: X, y
X, y = churn_data.iloc[:,:-1], churn_data.iloc[:,-1]

# Create the training and test sets
X_train, X_test, y_train, y_test= train_test_split(X, y, test_size=0.2, random_state=123)

# Instantiate the XGBClassifier: xg_cl
xg_cl = xgb.XGBClassifier(objective='binary:logistic', n_estimators=10, seed=123)

# Fit the classifier to the training set
xg_cl.fit(X_train, y_train)

# Predict the labels of the test set: preds
preds = xg_cl.predict(X_test)

# Compute the accuracy: accuracy
accuracy = float(np.sum(preds==y_test))/y_test.shape[0]
print("accuracy: %f" % (accuracy))