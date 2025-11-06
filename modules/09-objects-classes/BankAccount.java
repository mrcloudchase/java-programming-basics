/**
 * BankAccount.java
 * Demonstrates class creation with encapsulation
 * Shows constructors, instance variables, methods, and the 'this' keyword
 */
public class BankAccount {
    // Instance variables (fields)
    // Private = can only be accessed within this class (encapsulation)
    private double balance;
    private String accountHolder;
    private int accountNumber;
    private static int nextAccountNumber = 1000;  // Shared across all accounts
    
    // Constructor - special method that creates new objects
    // Called when you use 'new BankAccount(...)'
    public BankAccount(String accountHolder, double initialBalance) {
        // 'this' refers to the current object being created
        this.accountHolder = accountHolder;
        
        // Validate initial balance
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Warning: Negative initial balance not allowed. Set to 0.");
        }
        
        // Assign unique account number
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;  // Increment for next account
    }
    
    // Overloaded constructor - default balance of 0
    public BankAccount(String accountHolder) {
        this(accountHolder, 0);  // Call the other constructor
    }
    
    // Instance methods - operate on a specific object
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited $%.2f to account %d%n", amount, accountNumber);
        } else {
            System.out.println("Error: Deposit amount must be positive");
        }
    }
    
    // Withdraw method with validation
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive");
            return false;
        }
        
        if (amount > balance) {
            System.out.printf("Insufficient funds! Balance: $%.2f, Requested: $%.2f%n", 
                            balance, amount);
            return false;
        }
        
        balance -= amount;
        System.out.printf("Withdrew $%.2f from account %d%n", amount, accountNumber);
        return true;  // Successful withdrawal
    }
    
    // Transfer money to another account
    public boolean transfer(double amount, BankAccount recipient) {
        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be positive");
            return false;
        }
        
        System.out.printf("Transferring $%.2f from account %d to account %d...%n",
                        amount, this.accountNumber, recipient.accountNumber);
        
        // Try to withdraw from this account
        if (this.withdraw(amount)) {
            // If successful, deposit to recipient
            recipient.deposit(amount);
            System.out.println("Transfer complete!");
            return true;
        } else {
            System.out.println("Transfer failed!");
            return false;
        }
    }
    
    // Getter methods - provide controlled access to private fields
    public double getBalance() {
        return balance;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    // Setter method (only for account holder name)
    public void setAccountHolder(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.accountHolder = newName;
            System.out.println("Account holder name updated to: " + newName);
        } else {
            System.out.println("Error: Invalid name");
        }
    }
    
    // Calculate interest
    public void applyInterest(double interestRate) {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.printf("Applied %.1f%% interest: $%.2f added to account %d%n", 
                        interestRate, interest, accountNumber);
    }
    
    // toString method - provides string representation of object
    @Override
    public String toString() {
        return String.format("Account[#%d, Holder: %s, Balance: $%.2f]",
                           accountNumber, accountHolder, balance);
    }
    
    // Print account statement
    public void printStatement() {
        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║     ACCOUNT STATEMENT         ║");
        System.out.println("╠═══════════════════════════════╣");
        System.out.printf("║ Account #: %-18d ║%n", accountNumber);
        System.out.printf("║ Holder:    %-18s ║%n", accountHolder);
        System.out.printf("║ Balance:   $%-17.2f ║%n", balance);
        System.out.println("╚═══════════════════════════════╝");
    }
    
    // Compare accounts by balance
    public boolean hasMoreMoneyThan(BankAccount other) {
        return this.balance > other.balance;
    }
}
