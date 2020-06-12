# Neural Networks and Deep Learning

What is neural network ?
what is ReLu (Rectified Linear Units) function ?

Given enough/largeAmounts data neural networks are extremly good at figuring out the mapping function that maps x -> y.

m - size of training set.

Think{ Data, Computation, Algorithm}

Switching sigmoid with relu led to efficient computation.

derivative of sigmoid function ?

In computer science, an image is represented by a 3D array of shape (length,height,depth=3). 

However, when you read an image as the input of an algorithm you convert it to a vector of shape (length∗height∗3,1).

Note that you can divide matrices of different sizes and it works fine due to broadcasting in numpy.

what is softmax function ?

the difference between the dot/outer/elementwise product of matrix ?

The loss is used to evaluate the performance of your model. The bigger your loss is, the more different your predictions ($ \hat{y} $) are from the true values ($y$). In deep learning, you use optimization algorithms like Gradient Descent to train your model and to minimize the cost.

L1 loss definition ?

---
### Week 2

Binary classification.

Logistic Regression is the algorithm for binary classification.

forward pass -> forward propogation
backward pass -> backward propogation

(forward propagation): Calculate current loss

(backward propagation): Calculate current gradient



Difference between Loss function and cost function ?

Convex and non convex function.

local and global minima.

derivatives and partial derivatives.

what is computation graph ?

One step of backward propagation on a computation graph yields derivative of final output variable.

chain rule of differential calculus.

what is vectorization ?

---

What does a neuron compute?

write "Logistic Loss" function?

Suppose img is a (32,32,3) array, representing a 32x32 image with 3 color channels red, green and blue. How do you reshape this into a column vector?

a = np.random.randn(2, 3) # a.shape = (2, 3)
b = np.random.randn(2, 1) # b.shape = (2, 1)
c = a + b # shape?

difference between element-wise multiplication and np.dot() or matrix dot product ?

what is maximum likelihood estimate ?

---

One common preprocessing step in machine learning is to center and standardize your dataset, meaning that you substract the mean of the whole numpy array from each example, and then divide each example by the standard deviation of the whole numpy array.

