# Functions

Час виконання цієї вправи _30 хв_.

### Опис
Будь ласка, перейдіть до класу [`FunctionsTask`](src/main/java/com/epam/rd/autotasks/FunctionsTask4.java)
і реалізувати його статичні методи:

---
* `double sumGeometricElements(int a1, double t, int alim)`\
  Створіть функцію `sumGeometricElements`, що визначає суму перших додатних елементів  геометричної
  прогресія дійсних чисел із заданим початковим елементом прогресії a1 і заданим кроком прогресії t,
  в той час як останній елемент має бути більшим за заданий alim. an обчислюється за формулою (an+1 = an * t),
  0<t<1. Результат повинен бути заокруглений до цілого.
### Приклад:
For a progression, where a1 = 100, and t = 0.5, the sum of the first elements, grater than alim = 20,
equals to 100+50+25 = 175
