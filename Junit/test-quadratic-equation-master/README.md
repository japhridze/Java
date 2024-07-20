# Test Quadratic Equation

This exercise is about getting familiar with parametrized unit testing and JUnit 5 approach in particular.

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

1. Design and code a `solve` method in the [QuadraticEquation](src/main/java/com/epam/rd/autotasks/QuadraticEquation.java) class.
Here are some details:
- the method must solve a quadratic equation specified by three coefficients given as parameters: a,b,c.
- first parameter `a` might not be zero. If it is the case, throw an IllegalArgumentException.
- the `solve` method returns a string in of three formats:
    - `x1 x2` (two roots in any order separated by space) if there are two roots,
    - `x1` (just the value of the root) if there is the only root,
    - `no roots` (just a string value "no roots") if there is no root.

2. Complete the test classes:
- [QuadraticEquationNoRootsCasesTesting](src/main/java/com/epam/rd/autotasks/QuadraticEquationNoRootsCasesTesting.java)
- [QuadraticEquationSingleRootCasesTesting](src/main/java/com/epam/rd/autotasks/QuadraticEquationSingleRootCasesTesting.java)
- [QuadraticEquationTwoRootsCasesTesting](src/main/java/com/epam/rd/autotasks/QuadraticEquationTwoRootsCasesTesting.java)
- [QuadraticEquationZeroACasesTesting](src/main/java/com/epam/rd/autotasks/QuadraticEquationZeroACasesTesting.java)

Please consider that these are parameterized test classes, so take that into account. You have to provide at least 4 test cases for each class.
You are not allowed to change signature of their methods.

To pass the exercise, your tests must correctly detect flaws of some other sorting method implementations.
There are special tests in several classes that apply your tests to your and some of such ("bad") implementations:
- [DefaultQuadraticEquationTestingTest](src/test/java/com/epam/rd/autotasks/DefaultQuadraticEquationTestingTest.java)
- [ParamCarefulIncapableQuadraticEquationTestingTest](src/test/java/com/epam/rd/autotasks/ParamCarefulIncapableQuadraticEquationTestingTest.java)
- [ParamCarefulTwoRootsReversedOrderQuadraticEquationTestingTest](src/test/java/com/epam/rd/autotasks/ParamCarefulTwoRootsReversedOrderQuadraticEquationTestingTest.java)
- [ParamCarelessSingleRootOnlyQuadraticEquationTestingTest](src/test/java/com/epam/rd/autotasks/ParamCarelessSingleRootOnlyQuadraticEquationTestingTest.java)
- [ParamCarelessTwoRootsOnlyQuadraticEquationTestingTest](src/test/java/com/epam/rd/autotasks/ParamCarelessTwoRootsOnlyQuadraticEquationTestingTest.java)

Your solution method must pass your tests while other implementations must fail your test in some cases.

Hint: [Quadratic formula reference](https://en.wikipedia.org/wiki/Quadratic_formula)
