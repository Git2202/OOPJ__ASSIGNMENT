public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize the bank account with account number, holder name, and initial deposit
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Getter method for current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully. Current balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully. Current balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to display the account details: account holder name, account number, and current balance
    public void displayBalance() {
        System.out.println("\nAccount Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}