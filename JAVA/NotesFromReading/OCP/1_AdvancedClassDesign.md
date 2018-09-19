# Advanced Class Design

Contents to learn in this chapter:

## Reviewing OCA Concepts

Review following from OCA book:

### Access Modifiers

**Access modifiers** \
public, protected, and private and default access.

**Overloading and Overriding** \
overloading and overriding happen only when the method name is the same. \
overriding occurs only when the method signature is the same. \
The method signature is the method name and the parameter list. \
For overloading, the method parameters must vary by type and/or number.

- When multiple overloaded methods are present, Java looks for the closest match first. It tries to find the following:
  1. Exact match by type
  2. Matching a superclass type
  3. Converting to a larger primitive type
  4. Converting to an autoboxed type
  5. Varargs
  
- For overriding, the overridden method has a few rules:
  1. The access modifier must be the same or more accessible.
  2. The return type must be the same or a more restrictive type, also known as covariant return types.
  3. If any checked exceptions are thrown, only the same exceptions or subclasses of those exceptions are allowed to be thrown.

*The methods must not be static. (If they are, the method is hidden and not overridden.)*
