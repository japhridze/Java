# Test Factorial

This exercise is about getting familiar with unit testing and JUnit 5 approach in particular.

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


1. Design and code a `factorial` method in
the [Factorial](src/main/java/com/epam/rd/autotasks/Factorial.java) class. Here are some details:

- the method takes a String as a parameter, transforms it to an integer value and counts its factorial.
- The method returns a result as a String.
- String parameter `n` must represent a non-negative integer number. If it does not, throw an IllegalArgumentException.

2. Complete the test classes:

- [FactorialBadInputTesting](src/main/java/com/epam/rd/autotasks/FactorialBadInputTesting.java)\
  There are four empty methods that you must complete:
    - `testNullInput` - test a null input cases
    - `testNegativeInput` - test a negative number input cases
    - `testFractionalInput` - test a fractional cases
    - `testNonDigitalInput` - test a non-digit cases
- [FactorialCsvParametrizedTesting](src/main/java/com/epam/rd/autotasks/FactorialCsvParametrizedTesting.java)\
  it is a parameterized test, that takes arguments from the [csvCases.csv](src/main/resources/csvCases.csv) file. Do
  not change the csv file, only implement the method.
- [FactorialMethodSourceParametrizedTesting](src/main/java/com/epam/rd/autotasks/FactorialMethodSourceParametrizedTesting.java)\
  it is a parameterized test, that takes arguments from the `testCases` method. You must complete the test method and
  introduce the `testCases` method, that provides following cases:
    - "1", "1"
    - "2", "2"
    - "5", "120"
- [FactorialRegularInputTesting](src/main/java/com/epam/rd/autotasks/FactorialRegularInputTesting.java)\
  it is a test class where you can add regular test cases. Consider covering cases that are not present in other test
  classes.

To pass the exercise, your tests must correctly detect flaws of some other implementations. There are special
tests in several classes that apply your tests to your and other problematic("bad") implementations:

- [FactorialTestingsTest](src/test/java/com/epam/rd/autotasks/FactorialTestingsTest.java)
- [LazyFactorialTestingsTest](src/test/java/com/epam/rd/autotasks/LazyFactorialTestingsTest.java)
- [WrongOperationConcatIntFactorialTestingsTest](src/test/java/com/epam/rd/autotasks/WrongOperationConcatIntFactorialTestingsTest.java)
- [WrongOperationSumIntFactorialTestingsTest](src/test/java/com/epam/rd/autotasks/WrongOperationSumIntFactorialTestingsTest.java)

Your solution method must pass your tests while other implementation must fail your tests in some cases.

Also, there is one more secret test class that you do not have access to. It will be applied to your solution once you
submit it to Autocode. So, consider the variety of possible cases.

Hint: [Factorial reference](https://en.wikipedia.org/wiki/Factorial)
