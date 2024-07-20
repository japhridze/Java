# Condition Statements

Час виконання цієї вправи _30 хв_.

### Опис
Будь ласка, перейдіть до класу [`LoopStatements`](src/main/java/com/epam/rd/autotasks/LoopStatements.java)
і реалізувати його статичні методи:
---
* `int sumOfFibonacciNumbers(int n)`\
  Для натурального числа n обчисліть значення результату, яке дорівнює сумі перших n чисел Фібоначчі.

* Примітка. Числа Фібоначчі — це ряд чисел, у яких кожне наступне число дорівнює сумі двох
  попередні: 0, 1, 1, 2, 3, 5, 8, 13 ... (значення першого елемента в числах Фібоначчі дорівнює «0», значення другого та третього елементів дорівнюють «1 ", для інших елементів використовуйте формулу F(n)=F(n-1)+F(n-2))
### Приклад:
`n = 8 ` -> результат = 33
`n = 11` -> результат = 143


---
###  Приклади:

---
Code Sample:
```java
...
        System.out.println(LoopStatements.sumOfFibonacciNumbers(8));
        System.out.println(LoopStatements.sumOfFibonacciNumbers(11));
```

Output:
```
33
143
```