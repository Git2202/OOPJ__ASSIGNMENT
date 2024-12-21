public class TestClass {
    public static void main(String[] args) {
        // Creating test accounts
        BankAccount account1 = new BankAccount("12345", "Alice", 1000);
        BankAccount account2 = new BankAccount("67890", "Bob", 500);
        BankAccount account3 = new BankAccount("11223", "Charlie", 2000);

        // Testing deposit method
        System.out.println("Initial Balance for Alice:");
        account1.displayBalance();
        account1.deposit(500);  // Alice deposits 500
        account1.deposit(-100); // Invalid deposit
        System.out.println("Updated Balance for Alice:");
        account1.displayBalance();

        // Testing withdraw method
        System.out.println("\nInitial Balance for Bob:");
        account2.displayBalance();
        account2.withdraw(200);  // Bob withdraws 200
        account2.withdraw(1000); // Insufficient balance
        System.out.println("Updated Balance for Bob:");
        account2.displayBalance();

        // Testing withdraw and deposit for Charlie
        System.out.println("\nInitial Balance for Charlie:");
        account3.displayBalance();
        account3.deposit(1500);  // Charlie deposits 1500
        account3.withdraw(1000); // Charlie withdraws 1000
        account3.withdraw(3000); // Insufficient balance
        System.out.println("Updated Balance for Charlie:");
        account3.displayBalance();
    }
}