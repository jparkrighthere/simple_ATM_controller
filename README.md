# simple_ATM_controller

A Simple ATM Controller that follows the flow : Insert Card => PIN number => Select Account => See Balance/Deposit/Withdraw

## Environment

- [Java](https://www.java.com/en/) - Java Language

- [JUnit](https://junit.org/junit4/)(v.4.13.2) - Testing Framework

## Requirement

- JDK (Java Development Kit)


## Usage

1. Git clone the repo and cd into the directory
```
git clone https://github.com/jparkrighthere/simple_ATM_controller.git
```

2. Run Test
```
make compile
make test

or

make run
```

3. Clean the compiled classes after test
```
make clean
```

## Tests check for the following:
* ### Initialized Setting
     * #### Card Number: 1234567890
     * #### PIN: 1234
     * #### Account Number: 1001
     * #### Balance: 500



- testValidPINAuthentication()
    - Test that entering a valid PIN authenticates the user successfully

- testInvalidPINAuthentication()
    - Test that entering an invalid PIN does not authenticate the user and throws an exception when trying to select an account.

- testSelectAccount()
    - Test selecting an account after valid PIN authentication and checking its balance.

- testDeposit()
    - Test depositing money into the account and checking the updated balance.

- testWithdraw()
    - Test withdrawing money from the account and checking the updated balance.

- testWithdrawInsufficientFunds()
    - Test withdrawing more money than the account balance to ensure an exception is thrown.

- testNoCardInserted()
    - Test attempting to enter PIN without having a card inserted, which should throw an exception.

- testNoAccountSelected()
    - Test attempting to check balance without selecting an account, which should throw an exception.

- testNoAuthentication()
    - Test inserting a card and attempting to select an account without proper authentication, which should throw an exception.

- testInvalidCardNumber()
    - Test inserting an invalid card to ensure that an exception is thrown.

- testAccountSelectionWithWrongPIN()
    - Test attempting to select an account with an incorrect PIN after authentication failure, which should throw an exception.

- testMultipleAccountSelection()
    - Test selecting multiple accounts to ensure that switching between accounts works correctly.

- testDepositAndWithdrawZeroAmount()
    - Test depositing and withdrawing zero amount to ensure that such operations throw exceptions.

- testNegativeDepositAndWithdraw()
    - Test depositing and withdrawing negative amounts to ensure that such operations throw exceptions.

- testEveryMethods()
    - Test case for balance handling with maximum integer value and ensure it handles deposits and withdrawals correctly.

#### 궁금하신 사항이 있으시다면 연락주시면 감사하겠습니다!
> fishbox0923@gmail.com