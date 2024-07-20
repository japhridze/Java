# Statements basics

The purpose of this exercise is to check if you understand conditional statements.

Duration: **15** minutes

## Description

Proceed to `StatementBasics` class and implement three methods:
- `public static int addPositive(int value)` \
  Given an integer `value`. If it is positive, then add 1 to it and return new value. 
  In other case don’t change it and return the value. 
```
value = 5  =>  value = 6
value = -6  =>  value = -6
```

- `public static int addPositiveSubtractNegative(int value)` \
  Given an integer `value`. If it is positive, then add 1 to it  and return new value. 
  Otherwise, subtract 2 from it  and return new value.
```
A = 12  =>  A = 13
A = -8  =>  A = -10
```

- `public static int addPositiveSubtractNegativeReplaceZero(int value)` \
  Given an integer `value`. If it is positive, then add 1 to it  and return new value; 
  if negative, then subtract 2 from it and return new value; 
  if zero, then replace it with 3 and return new value.
```
A = 45  =>  A = 46
A = -16  =>  A = -18
A = 0  =>  A = 3
```