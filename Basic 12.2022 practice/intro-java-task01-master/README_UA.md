# Condition Statements

Мета цієї задачі — навчитися працювати з умовними операторами.
Час виконання _30 хв_.

### Опис
Будь ласка, перейдіть до класу [`ConditionStatements`](src/main/java/com/epam/rd/autotasks/ConditionStatements.java)
і реалізуйте його статичний метод:
---
* `int task1(int n)`\
Для даного цілого числа n обчисліть значення, яке дорівнює:\
  • квадрат числа, якщо його значення додатне;\
  • модуль числа, якщо його значення від'ємне;\
  • нуль, якщо ціле число n дорівнює нулю.
### Приклад:
`n = 4 ` -> результат = 16

`n = -5` -> результат = 5

`n = 0` -> результат = 0


---
###  Приклади:

---
Code Sample:
```java
...
System.out.println(ConditionStatements.task1(4));
System.out.println(ConditionStatements.task1(-5));
System.out.println(ConditionStatements.task1(0));

```

Output:
```
16
5
0
```


