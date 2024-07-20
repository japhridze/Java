# Transform

Час виконання цієї вправи _30 хв_.

### Опис
Будь ласка, перейдіть до класу [`FunctionsTask`](src/main/java/com/epam/rd/autotasks/FunctionsTask2.java)
і реалізувати його статичні методи:



---
* `int transform(int[] array, SortOrder order)`\
  Створіть функцію transform, замінивши значення кожного елемента цілого масиву на суму
  значення цього елемента та його індексу, тільки якщо даний масив відсортовано в заданому порядку (порядок
  встановлюється значенням  SortOrder). Масив і порядок сортування передаються параметрами. Щоб перевірити, що
  масив відсортований, скористатися функцією isSorted.
* 
### Приклад:
For `{5, 17, 24, 88, 33, 2}` and “ascending” sort order values in the array do not change;\
For `{15, 10, 3}` and “ascending” sort order values in the array do not change;\
For `{15, 10, 3}` and “descending” sort order the values in the array are changing to {15, 11, 5}


