import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // Read account data from the input file and create BankAccount objects
        try {
            Scanner fileScanner = new Scanner(new File("input1.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                
                String accountNumber = data[0];
                String accountHolderName = data[1];
                double initialDeposit = Double.parseDouble(data[2]);
                
                accounts.add(new BankAccount(accountNumber, accountHolderName, initialDeposit));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }

        // Create FileWriter to write to output.txt
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            // Menu-driven interface for banking operations
            while (true) {
                System.out.println("\n--- Banking Application ---");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Create a new account
                        System.out.print("Enter Account Holder Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Account Number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter Initial Deposit: ");
                        double initialDeposit = scanner.nextDouble();
                        BankAccount newAccount = new BankAccount(accountNumber, name, initialDeposit);
                        accounts.add(newAccount);
                        System.out.println("Account created successfully!");

                        // Write new account data to input1.txt
                        try (FileWriter fileWriter = new FileWriter("input1.txt", true)) {
                            fileWriter.write(accountNumber + "," + name + "," + initialDeposit + "\n");
                        } catch (IOException e) {
                            System.out.println("Error writing to input1.txt");
                        }
                        break;

                    case 2:
                        // Deposit money into an account
                        System.out.print("Enter Account Number: ");
                        String accNumForDeposit = scanner.nextLine();
                        BankAccount accountForDeposit = findAccount(accounts, accNumForDeposit);
                        if (accountForDeposit != null) {
                            System.out.print("Enter Deposit Amount: ");
                            double depositAmount = scanner.nextDouble();
                            accountForDeposit.deposit(depositAmount);
                            writer.write("Deposit: " + depositAmount + " to Account: " + accNumForDeposit + "\n");
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 3:
                        // Withdraw money from an account
                        System.out.print("Enter Account Number: ");
                        String accNumForWithdraw = scanner.nextLine();
                        BankAccount accountForWithdraw = findAccount(accounts, accNumForWithdraw);
                        if (accountForWithdraw != null) {
                            System.out.print("Enter Withdrawal Amount: ");
                            double withdrawAmount = scanner.nextDouble();
                            accountForWithdraw.withdraw(withdrawAmount);
                            writer.write("Withdrawal: " + withdrawAmount + " from Account: " + accNumForWithdraw + "\n");
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 4:
                        // Check balance of an account
                        System.out.print("Enter Account Number: ");
                        String accNumForCheck = scanner.nextLine();
                        BankAccount accountForCheck = findAccount(accounts, accNumForCheck);
                        if (accountForCheck != null) {
                            accountForCheck.displayBalance();
                            writer.write("Balance Check for Account: " + accNumForCheck + "\n");
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 5:
                        // Exit the program
                        System.out.println("Thank you for using the banking application. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file.");
        }
    }

    // Helper method to find an account by its account number
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
