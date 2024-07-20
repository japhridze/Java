# Sum of the first positive elements.

The purpose of this exercise is to train you to work with functions.

Estimated workload of this exercise is _30 min_.

### Description

Please, proceed to [`FunctionsTask`](src/main/java/com/epam/rd/autotasks/FunctionsTask4.java) class
and implement its static methods:

---

* `double sumGeometricElements(int a1, double t, int alim)`

Create function `sumGeometricElements`, determining the sum of the first positive elements of a decreasing geometric
progression of real numbers with a given initial element of a progression a1 and a given progression step t,
while the last element must be greater than a given alim. an is calculated by the formula (an+1 = an * t),
0<t<1. The result must be rounded up to an integer.

### Example:

For a progression, where a1 = 100, and t = 0.5, the sum of the first elements, greater than alim = 20,
equals to 100+50+25 = 175

---
