import java.util.Scanner;

// BankAccount class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: RS:" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > balance || amount <= 0) {
            System.out.println("Insufficient funds or invalid withdrawal amount");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawn: RS." + amount);
            return true;
        }
    }
}

// ATM class representing the ATM machine
public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Current Balance: RS." + balance);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: RS.");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: RS.");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initialize account with balance $1000
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}
