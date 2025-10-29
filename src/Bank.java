import java.util.Scanner;

public class Bank {

    private BankAccount[] accounts;
    private int size;
    private Scanner scanner;

    public Bank() {
        accounts = new BankAccount[10];
        size = 0;
        scanner = new Scanner(System.in);
    }

    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }

    public void openAccount() {
        System.out.println("Enter Account Holder Name:");
        String accHName = scanner.nextLine();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Creating BankAccount object...");
        pause();

        BankAccount account = new BankAccount(accHName, balance);

        accounts[size] = account;
        size++;

        System.out.println("BankAccount object stored successfully in Bank.");
        pause();
    }

    private BankAccount getAccount(long accNum) throws IllegalArgumentException {
        if (accNum <= 0)
            throw new IllegalArgumentException("Account number cannot be negative or zero.");

        System.out.println("Searching for account number: " + accNum);
        pause();

        for (int i = 0; i < size; i++) {
            BankAccount account = accounts[i];
            if (account.getAccNum() == accNum)
                return account;
        }

        return null;
    }

    public void deposit(long accNum, double amt) throws IllegalArgumentException {
        System.out.println("Deposit operation started...");
        pause();

        BankAccount account = getAccount(accNum);
        if (account == null)
            throw new IllegalArgumentException("Account not found with given number.");

        if (amt <= 0)
            throw new IllegalArgumentException("Amount cannot be negative or zero.");

        account.deposit(amt);
        System.out.println("Rs. " + amt + " credited successfully to account " + accNum);
        pause();
    }

    public void withdraw(long accNum, double amt) throws IllegalArgumentException {
        System.out.println("Withdraw operation started...");
        pause();

        BankAccount account = getAccount(accNum);
        if (account == null)
            throw new IllegalArgumentException("Account not found with given number.");

        if (amt <= 0)
            throw new IllegalArgumentException("Amount cannot be negative or zero.");

        if (amt > account.getBalance())
            throw new IllegalArgumentException("Insufficient funds.");

        account.withdraw(amt);
        System.out.println("Rs. " + amt + " withdrawn successfully from account " + accNum);
        pause();
    }

    public void balanceEnquiry(long accNum) throws IllegalArgumentException {
        System.out.println("Balance enquiry started...");
        pause();

        BankAccount account = getAccount(accNum);

        if (account == null)
            throw new IllegalArgumentException("Account not found with given number.");

        System.out.println("Current balance: Rs. " + account.getBalance());
        pause();
    }

    public void transferMoney(long sourceAccNum, long destinationAccNum, double amt)
            throws IllegalArgumentException {
        System.out.println("Transfer money operation started...");
        pause();

        if (sourceAccNum == destinationAccNum)
            throw new IllegalArgumentException("Source and destination accounts cannot be the same.");

        withdraw(sourceAccNum, amt);
        deposit(destinationAccNum, amt);

        System.out.println("Transfer of Rs. " + amt + " completed successfully.");
        pause();
    }

    public void closeAccount(long accNum) throws IllegalArgumentException {
        System.out.println("Close account operation started...");
        pause();

        if (accNum <= 0)
            throw new IllegalArgumentException("Account number cannot be negative or zero.");

        for (int i = 0; i < size; i++) {
            BankAccount account = accounts[i];
            if (account.getAccNum() == accNum) {
                for (int j = i; j < size - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[size - 1] = null;
                size--;
                System.out.println("Account " + accNum + " closed successfully.");
                pause();
                return;
            }
        }

        throw new IllegalArgumentException("Account not found with given number.");
    }

    public void displayAccount(long accNum) throws IllegalArgumentException {
        System.out.println("\nDisplaying account details...");
        pause();

        BankAccount account = getAccount(accNum);
        if (account == null)
            throw new IllegalArgumentException("Account not found with given number.");

        System.out.println(account);
    }

    @Override
    public String toString() {
        if (size == 0)
            return "No accounts found.";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("\nAccount ").append(i + 1).append(" details:\n");
            sb.append(accounts[i]).append("\n");
        }
        return sb.toString();
    }
}
