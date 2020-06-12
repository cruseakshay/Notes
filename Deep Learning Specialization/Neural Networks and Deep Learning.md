# Neural Networks and Deep Learning

What is neural network ?
what is ReLu (Rectified Linear Units) function ?

Given enough/largeAmounts data neural networks are extremly good at figuring out the mapping function that maps x -> y.

m - size of training set.

Think{ Data, Computation, Algorithm}

Switching sigmoid with relu led to efficient computation.

---
### Week 2

Binary classification.

Logistic Regression is the algorithm for binary classification.

forward pass -> forward propogation
backward pass -> backward propogation

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

