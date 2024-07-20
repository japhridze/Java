# Test Sorting

This exercise is about getting familiar with unit testing and JUnit 5 in particular.

### You can do

- Implement methods in the classes defined in the description.
- Create new classes and use them in your code.
- Create new methods if necessary.

### You can't do

- Change pom.xml file.
- Change the signature of existing methods.
- Remove existing methods/classes.
- Modify any files in `src/test/java` (you are supposed to work with `src/main/java` only)

### Run test
To validate your task locally run the following maven command:

`mvn clean test`

### Description

1. Design and code a simple sorting method in the [Sorting](src/main/java/com/epam/rd/autotasks/Sorting.java) class.
Here are some details:
- the method sorts an integer array in ascending order
- an integer array is passed as a parameter to the method
- when given array is null, the method must throw an IllegalArgumentException.


2. Complete the test methods in [SortingTest](src/main/java/com/epam/rd/autotasks/SortingTest.java) class.
Use assertions to check your sorting methods. Be sure your tests verify expected exceptions.

To pass the exercise, your tests must correctly detect flaws of some other sorting method implementations.
There are special tests in [SortingTestsTest](src/test/java/com/epam/rd/autotasks/SortingTestsTest.java) class that apply your tests to your and some of such bad implementations.
Your sorting method must pass your tests, and others must fail in some cases.
