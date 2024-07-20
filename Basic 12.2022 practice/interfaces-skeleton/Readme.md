# Interface

The purpose of this exercise is to introduce you to abstraction in Java.

Estimated time - 60 minutes.

## Description

Create classes [`Deposit`](src/main/java/com/epam/rd/qa/collections/Deposit.java) (bank account),
[`BaseDeposit`](src/main/java/com/epam/rd/qa/collections/BaseDeposit.java) (regular deposit),
[`SpecialDeposit`](src/main/java/com/epam/rd/qa/collections/SpecialDeposit.java) (special deposit),
[`LongDeposit`](src/main/java/com/epam/rd/qa/collections/SpecialDeposit.java) (long-term deposit),
Create class [`Client`](src/main/java/com/epam/rd/qa/collections/Client.java) (bank client) with set functionality.

Create `abstract` class `Deposit` and declare within it:

- Public money property only for reading `amount` (deposit amount)
- Public integer property only for reading `period` (time of deposit in months)
- Constructor (for calling in class-inheritor) with parameters
  `depositAmount` and `depositPeriod`, which creates object
  deposit with specified sum for specified period.
  The constructor must throw `IllegalArgumentException`
  if `amount` or `period` is less or equal to 0.
- Abstract method `income`, which returns money value – amount of income from deposit. Income is the difference between sum, withdrawn from deposit upon expiration date and deposited sum.

Create classes that are inheritors of the class `Deposit`, which determine different options of deposit interest addition – class `BaseDeposit`, class `SpecialDeposit` and class `LongDeposit`. To implement in each class a constructor with parameters `amount` and `period`, which calls constructor of parent class.

For each inheritor class implement own interest addition scheme and accordingly profit margin definitions, overriding abstract method `income` in each class.

`BaseDeposit` implies each month 5% of interest from current deposit sum. Each following month of income is calculated from the sum, which was received by adding to current income sum of the previous month and is rounded to hundredth.

Example:

```
Base amount – 1000,00
In a month – 1050,00; income amount – 50,00
In two months – 1102,50; income amount – 102,50
In three months – 1157,62; income amount – 157,62 
```

`SpecialDeposit` implies income addition each month, amount of which (in percent) equals to deposit expiration period. If during the first month 1% is added, during the second month – 2% from the sum obtained after first month and so on.

Example:

```
Base amount – 1000,00
In a month – 1010,00; income amount – 10,00
In two months – 1030,20; income amount – 30,20
```

`LongDeposit` implies that during first 6 months, no percent is added to client’s deposit, but starting from 7th month, each month percent addition is 15% from current deposit sum, thus encouraging client to make long-term deposits.

Example:

```
Base amount – 1000,00
In 6 month – 1000,00; income amount – 0,00
In 7 month – 1150,00; income amount – 150,00
In 8 months – 1322.50; income amount – 322.50
```

Create interface [`Prolongable`](src/main/java/com/epam/rd/qa/collections/Prolongable.java) 
(prolonging deposit) and declare within it method `canToProlong` without parameters 
that returns logic value `true` or `false`, depending on the fact whether this specific deposit 
can be prolonged or not.

Implement interface `Prolongable` in classes `SpecialDeposit` and `LongDeposit`.  

In addition, special deposit (`SpecialDeposit`) can be prolonged only 
when more than 1000 UAH were deposited, and long-term deposit 
(`LongDeposit`) can be prolonged if the `period` of deposit 
is no longer than or equals to 3 years.

Implement standard generic interface `Comparable<Deposit>` in abstract class `Deposit`. 
The total amount (deposit amount plus interest in the entire period) 
should be considered as a criterion for comparing instances of "Deposit".

Create class `Client` (bank client) and declare within it:

- Private field `deposits` (client deposits) – objects array of type `Deposit`
- Constructor without parameters, which creates empty array deposits consisting of 10 elements
- Constructor with parameter to receive `deposits`. Should throw `IllegalArgumentException` if parameter is `null`
- Method `addDeposit` with parameter deposit for adding regular, special or long-term account into array on the first empty spot and returning `true`, or returning `false`, if accounts number limit is depleted (no empty space in array).
- Method `totalIncome`, returning total income amount based on all client’s deposits upon deposits expiration.
- Method `maxIncome`, returning maximum deposit income of all client’s deposits upon deposits expiration.
- Method `getIncomeByNumber` with integer parameter `number` (deposit number, which equals its index in array), returning income from deposit with such number. If deposit with such number does not exist, method returns `0` value.

Implement additionally in class `Client`:
- interface `Iterable<Deposit>`:
  - method `iterator()` must return new instance of inner (nonstatic) class `Iterator<Deposit>`;
  - implements `hasNext()` and `next()` methods;
  - method `remove()` must throw `UnsupportedOperationException`.
- method `sortDeposits`, which performs deposits sorting in array deposits in
descending order of total sum amount on deposit upon deposit expiration.
- method `countPossibleToProlongDeposit`, which returns integer – amount
of current client’s deposits that can be prolonged.
