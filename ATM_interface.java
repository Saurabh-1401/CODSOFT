import java.util.Scanner;
class BankAcc {
    private double balance;

    public BankAcc(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAcc account;

    public ATM(BankAcc bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM MENU:");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSITE");
        System.out.println("3. WITHDRAW");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. Your balance: ₹ " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Your balance: ₹ " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAcc userAccount = new BankAcc(1000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
