# OOPJ-Assignment

## Software Requirements
1. Java Development Kit (JDK) version 8 or higher.
2. Code Editor: You can use Visual Studio Code, IntelliJ IDEA, Eclipse, or any other Java IDE.
3. Git: For version control to manage and track your code changes.
4. Basic Understanding of Object-Oriented Programming (OOP) concepts like classes, objects, inheritance, encapsulation, etc.
5. Command Line or Terminal: For compiling and running Java programs.

## Project Overview
This project simulates a simple banking application that allows users to:
- Create new bank accounts.
- Deposit money into accounts.
- Withdraw money from accounts.
- Check account balances.

The project demonstrates the use of classes, methods, and file handling in Java.

## Classes and Interfaces

### BankAccount Class
- Attributes:
  - `String accountNumber` - Unique identifier for the bank account.
  - `String accountHolderName` - Name of the account holder.
  - `double balance` - Current balance of the account.

- Methods:
  - `public BankAccount(String accountNumber, String accountHolderName, double initialDeposit)` - Constructor to initialize the account with account number, holder name, and initial deposit.
  - `public String getAccountNumber()` - Returns the account number.
  - `public String getAccountHolderName()` - Returns the name of the account holder.
  - `public double getBalance()` - Returns the current balance.
  - `public void deposit(double amount)` - Deposits a specified amount into the account.
  - `public void withdraw(double amount)` - Withdraws a specified amount from the account.
  - `public void displayBalance()` - Displays the current balance, account number, and account holder's name.

### BankingApplication Class
- Attributes:
  - `ArrayList<BankAccount> accounts` - List to store all bank accounts.

- Methods:
  - `public static void main(String[] args)` - The main method where the program starts. Provides a menu-driven interface for banking operations.
  - `private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountNumber)` - Helper method that searches for a bank account by account number.

### TestClass Class
- Methods:
  - `public static void main(String[] args)` - Creates test instances of `BankAccount`, performs deposit, withdrawal, and balance checks to test the functionality of the `BankAccount` class.

## Program Execution Flow

1. Account Creation: Users can create a new account by entering the account holder's name, account number, and an initial deposit amount. 
2. Deposit: Users can deposit money into an existing account by specifying the account number and the deposit amount.
3. Withdraw: Users can withdraw money from an existing account by providing the account number and the withdrawal amount. Withdrawals are subject to balance availability.
4. Check Balance: Users can check the current balance of an account by entering the account number.
5. File Handling:
   - Input File: The program reads account data from `input1.txt` to create bank account objects.
   - Output File: The program writes deposit, withdrawal, and balance check operations to `output.txt`.

## Sample Input (input1.txt)
This file contains the initial data for creating bank accounts, with each row representing an account:
```plaintext
12345,Alice,1000
67890,Bob,500
11223,Charlie,2000
54321,David,1500
67891,Emma,3000
34567,Frank,1000
98765,Grace,2500
23456,Hannah,1000
65432,Ian,500
76543,Jack,2000
