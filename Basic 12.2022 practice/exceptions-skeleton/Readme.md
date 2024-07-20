# Exceptions
[Matrix](src/main/java/com/epam/rd/qa/basicio/Matrix.java)

Expected time - 40 minutes

## Description

Create type `Matrix`, which encapsulates two-dimensional array-matrix
block of real (`double`) type.
`Matrix` is the cover for two-dimensional array of real values, storing matrix
values with operations of matrix addition, deduction and multiplication.

Real type values (`double`) can be in matrix, specifying during creation, the
number of array rows and columns, which will store these values. After
creation, the number of rows and columns are not changed. Values to matrix
elements can be set while creating matrix, and later with the help of indexer.
`Matrix` can provide information regarding the number of array rows and
columns, receive array elements in form of two-dimensional standard array,
add, deduct and multiply matrices compatible by size. If a user is trying to
perform operations with matrix of incompatible sizes – user type exceptions
`MatrixException` are thrown from operations. Other matrix methods also
throw exceptions, if a user applies them incorrectly (conveys incorrect
parameters into constructor, in indexer – non-existing index and so on).

> Take a look at the tests to understand which superclass for
`MatrixException` should be used.

Implementation of the following functionality is required in Matrix class:
- Creating of empty matrix with predetermined number of rows and columns
  (all values in matrix equal to 0).
- Creating of matrix based on existing two-dimensional array.
- `getRows()` - returns number of matrix rows.
- `getColumns()` - returns number of matrix columns.
- `toArray()` - returns standard two-dimensional array out of matrix.
- `get(int, int)` - returns the element using predetermined correct indexes.
- `set(int, int, double)` - sets new value using predetermined correct indexes.
- `add(Matrix)` - method of matrices addition. Should return a new `Matrix` object.
- `subtract(Matrix)` - method of matrices deduction. Should return a new `Matrix` object.
- `multily(Matrix)` - method of matrices multiplication. Should return a new `Matrix` object.
- Raise exceptions specified in Javadoc-comments on class methods.
