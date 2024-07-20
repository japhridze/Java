# Transform

The purpose of this exercise is to train you to work with functions.

Estimated workload of this exercise is _30 min_.

### Description

Please, proceed to [`FunctionsTask`](src/main/java/com/epam/rd/autotasks/FunctionsTask2.java) class
and implement its static methods:

---

* `int transform(int[] array, SortOrder order)`\
Create function `transform`, replacing the value of each element of an integer array with the sum of
  this element value and its index, only if the given array is sorted in the given order (the order
  is set up by enum value SortOrder). Array and sort order are passed by parameters. To check, if
  the array is sorted,use the function isSorted.

###  Example:
For `{5, 17, 24, 88, 33, 2}` and “ascending” sort order values in the array do not change;\
For `{15, 10, 3}` and “ascending” sort order values in the array do not change;\
For `{15, 10, 3}` and “descending” sort order the values in the array are changing to {15, 11, 5}

