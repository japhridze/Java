# Transform Matrix

The purpose of this exercise is to train you to work with arrays.

Estimated workload of this exercise is *30 min*.

### Description

Please, proceed to [MatrixUtil](src/main/java/com/epam/rd/autotasks/matrix/MatrixUtil.java) class
and implement its static method:

`void transformMatrix(int[][] matrix)`

* In a predetermined two-dimensional integer array (square matrix) write 0 into elements to the left side of the main diagonal, and 1 into elements to the right side of the diagonal.

* Note that input array may be empty.

## Examples

Input:

```
{ {2, 3}, {4, 5} }
{ { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } }
```

Output:

```
[[2, 1], [0, 5]]
[[2, 1, 1, 1], [0, 7, 1, 1], [0, 0, 3, 1], [0, 0, 0, 5]]
```
