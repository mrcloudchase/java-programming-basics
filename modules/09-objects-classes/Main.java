/**
 * Main.java
 * Demonstrates object creation and usage
 * Shows how to work with multiple objects of the same class
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Bank Account Management System ===\n");
        
        // Creating objects using the 'new' keyword
        // Each object is a separate instance with its own data
        System.out.println("--- Creating Accounts ---");
        
        // Create first account with initial balance
        BankAccount account1 = new BankAccount("Alice Johnson", 1000.00);
        System.out.println("Created: " + account1);
        
        // Create second account using overloaded constructor (no initial balance)
        BankAccount account2 = new BankAccount("Bob Smith");
        System.out.println("Created: " + account2);
        
        // Create third account
        BankAccount account3 = new BankAccount("Charlie Davis", 500.00);
        System.out.println("Created: " + account3);
        
        // Each object has its own copy of instance variables
        System.out.println("\n--- Initial Balances ---");
        System.out.printf("Alice's balance: $%.2f%n", account1.getBalance());
        System.out.printf("Bob's balance: $%.2f%n", account2.getBalance());
        System.out.printf("Charlie's balance: $%.2f%n", account3.getBalance());
        
        // Perform operations on objects
        System.out.println("\n--- Performing Transactions ---");
        
        // Deposits
        account1.deposit(250.50);
        account2.deposit(1000.00);
        
        // Withdrawals
        account1.withdraw(100.00);
        account3.withdraw(600.00);  // Should fail - insufficient funds
        
        // Transfer between accounts
        System.out.println("\n--- Transfer Test ---");
        account1.transfer(200.00, account2);
        
        // Apply interest
        System.out.println("\n--- Applying Interest ---");
        double interestRate = 2.5;  // 2.5%
        account1.applyInterest(interestRate);
        account2.applyInterest(interestRate);
        account3.applyInterest(interestRate);
        
        // Print statements
        System.out.println("\n--- Account Statements ---");
        account1.printStatement();
        account2.printStatement();
        account3.printStatement();
        
        // Object comparison
        System.out.println("\n--- Account Comparisons ---");
        if (account1.hasMoreMoneyThan(account2)) {
            System.out.println(account1.getAccountHolder() + " has more money than " + 
                             account2.getAccountHolder());
        } else {
            System.out.println(account2.getAccountHolder() + " has more money than " + 
                             account1.getAccountHolder());
        }
        
        // Working with ArrayList of objects
        System.out.println("\n--- Bank Portfolio ---");
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(account1);
        bankAccounts.add(account2);
        bankAccounts.add(account3);
        
        // Calculate total bank assets
        double totalAssets = 0;
        for (BankAccount account : bankAccounts) {
            totalAssets += account.getBalance();
        }
        System.out.printf("Total bank assets: $%.2f%n", totalAssets);
        
        // Find richest account
        BankAccount richestAccount = bankAccounts.get(0);
        for (BankAccount account : bankAccounts) {
            if (account.getBalance() > richestAccount.getBalance()) {
                richestAccount = account;
            }
        }
        System.out.println("Richest account: " + richestAccount);
        
        // Interactive menu
        System.out.println("\n--- Interactive Banking ---");
        boolean running = true;
        
        while (running) {
            System.out.println("\n1. Check balance");
            System.out.println("2. Make deposit");
            System.out.println("3. Make withdrawal");
            System.out.println("4. Transfer funds");
            System.out.println("5. Update account holder name");
            System.out.println("6. Create new account");
            System.out.println("7. Show all accounts");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer
            
            switch (choice) {
                case 1:  // Check balance
                    System.out.print("Enter account number: ");
                    int checkAccNum = scanner.nextInt();
                    BankAccount checkAcc = findAccount(bankAccounts, checkAccNum);
                    if (checkAcc != null) {
                        System.out.printf("Balance: $%.2f%n", checkAcc.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 2:  // Deposit
                    System.out.print("Enter account number: ");
                    int depAccNum = scanner.nextInt();
                    BankAccount depAcc = findAccount(bankAccounts, depAccNum);
                    if (depAcc != null) {
                        System.out.print("Enter deposit amount: $");
                        double depAmount = scanner.nextDouble();
                        depAcc.deposit(depAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 3:  // Withdrawal
                    System.out.print("Enter account number: ");
                    int withAccNum = scanner.nextInt();
                    BankAccount withAcc = findAccount(bankAccounts, withAccNum);
                    if (withAcc != null) {
                        System.out.print("Enter withdrawal amount: $");
                        double withAmount = scanner.nextDouble();
                        withAcc.withdraw(withAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 4:  // Transfer
                    System.out.print("Enter source account number: ");
                    int srcAccNum = scanner.nextInt();
                    System.out.print("Enter destination account number: ");
                    int destAccNum = scanner.nextInt();
                    
                    BankAccount srcAcc = findAccount(bankAccounts, srcAccNum);
                    BankAccount destAcc = findAccount(bankAccounts, destAccNum);
                    
                    if (srcAcc != null && destAcc != null) {
                        System.out.print("Enter transfer amount: $");
                        double transAmount = scanner.nextDouble();
                        srcAcc.transfer(transAmount, destAcc);
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;
                    
                case 5:  // Update name
                    System.out.print("Enter account number: ");
                    int updateAccNum = scanner.nextInt();
                    scanner.nextLine();  // Clear buffer
                    BankAccount updateAcc = findAccount(bankAccounts, updateAccNum);
                    if (updateAcc != null) {
                        System.out.print("Enter new account holder name: ");
                        String newName = scanner.nextLine();
                        updateAcc.setAccountHolder(newName);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 6:  // Create new account
                    System.out.print("Enter account holder name: ");
                    String holderName = scanner.nextLine();
                    System.out.print("Enter initial deposit (0 for none): $");
                    double initialDep = scanner.nextDouble();
                    
                    BankAccount newAccount = new BankAccount(holderName, initialDep);
                    bankAccounts.add(newAccount);
                    System.out.println("Created: " + newAccount);
                    break;
                    
                case 7:  // Show all accounts
                    System.out.println("\n--- All Accounts ---");
                    for (BankAccount acc : bankAccounts) {
                        System.out.println(acc);
                    }
                    System.out.printf("Total accounts: %d%n", bankAccounts.size());
                    
                    // Recalculate total assets
                    totalAssets = 0;
                    for (BankAccount acc : bankAccounts) {
                        totalAssets += acc.getBalance();
                    }
                    System.out.printf("Total bank assets: $%.2f%n", totalAssets);
                    break;
                    
                case 0:  // Exit
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        // Demonstrate object concepts
        System.out.println("\n=== Key Object-Oriented Concepts ===");
        System.out.println("1. ENCAPSULATION: Private fields with public methods");
        System.out.println("   - balance is private, accessed via getBalance()");
        System.out.println("   - Protects data integrity");
        
        System.out.println("\n2. OBJECTS vs CLASSES:");
        System.out.println("   - BankAccount is a CLASS (blueprint)");
        System.out.println("   - account1, account2, etc. are OBJECTS (instances)");
        
        System.out.println("\n3. INSTANCE vs STATIC:");
        System.out.println("   - balance is an instance variable (each account has its own)");
        System.out.println("   - nextAccountNumber is static (shared by all accounts)");
        
        System.out.println("\n4. CONSTRUCTORS:");
        System.out.println("   - Special methods that initialize new objects");
        System.out.println("   - Can be overloaded (multiple versions)");
        
        System.out.println("\n5. THE 'this' KEYWORD:");
        System.out.println("   - Refers to the current object");
        System.out.println("   - Disambiguates parameter names from field names");
        
        scanner.close();
    }
    
    // Helper method to find account by number
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;  // Not found
    }
}
