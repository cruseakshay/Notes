# Functional Programming in JAVA

Imperative style:  low level, we tell Java every step of what we want it to do. code tends to get verbose, and we often wish the language were a tad more intelligent.

declarative Style: what we want rather than delve into how to do it.

## The Big Gains of Functional-Style Code

Functional-style code has a higher signal-to-noise ratio; we write fewer lines of code, but each line or expression achieves more.

1. We avoided explicit mutation or reassignment of variables, which are often sources of bugs and result in code that’s hard to make concurrent.
2. The functional version can easily be parallelized. If the computation was time consuming, we can easily run it concurrently for each element in the list.
3. In the functional version we gain access to the variable only after it’s fully baked, which removes the thread-safety concerns.
4. The code is more expressive.
5. The functional-style version is more concise.
6. The functional-style version is intuitive, code reads more like how we’d state the problem—and it’s easier to understand once we’re familiar with the syntax.

## OOP

In OOP we’re used to passing objects to methods, creating objects within methods, and returning objects from within methods.

## Functional Programming

- Higher-order functions:
  - how to pass functions to functions, create functions within functions, and return functions from within functions.

## Using the collect Method and the Collectors Class

The collect() method takes a stream of elements and collects or gathers them into a result container. To do that, the method needs to know three things:

- How to make a result container (for example, using the ArrayList::new method)
- How to add a single element to a result container (for example, using the ArrayList::add method)
- How to merge one result container into another (for example, using the ArrayList::addAll method)

## Listing All Files in a Directory

All Files in a Directory

```java
    Files.list(Paths.get(".")).forEach(System.out::println);
```

Only the subdirectories in the current directory:

```java
    Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
```

## Listing Select Files in a Directory

Traditional way to select only the java files in a DIR_PATH directory:

```java
    final String[] files = new File(DIR_PATH).list(new java.io.FilenameFilter(){
        public boolean accept(final File dir, final String name){
            return name.endsWith(".java");
        }
    });
    System.out.println(files);
```

The new DirectoryStream facility can help traverse large directory structures more efficiently.

```java
    Files.newDirectoryStream(
        Paths.get(DIR_PATH), path -> path.toString().endsWith(".java")
    ).forEach(System.out::println);
```