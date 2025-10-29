import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankAccount {
    private static String bankName;
    private static String branchName;
    private static String ifsc;

    private static long accCounter = 1001; // for auto account number generation
    private long accNum;
    private String accHName;
    private double balance;

    static {
        out.println("\nBankAccount class loaded.");
        try {
            Thread.sleep(500);
            BufferedReader fileReader = new BufferedReader(new FileReader("bankdetails.txt"));
            bankName = fileReader.readLine();
            branchName = fileReader.readLine();
            ifsc = fileReader.readLine();
            fileReader.close();
            out.println("Bank details initialized from file.");
        } catch (IOException e) {
            out.println("Error reading bank details file: " + e.getMessage());
            bankName = "Default Bank";
            branchName = "Main Branch";
            ifsc = "IFSC0000";
        } catch (InterruptedException e) {}
    }

    public BankAccount(String accHName, double balance) {
        this.accNum = accCounter++;
        this.accHName = accHName;
        this.balance = balance;
    }

    public long getAccNum() {
        return accNum;
    }

    public String getAccHName() {
        return accHName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        balance -= amt;
    }

    @Override
    public String toString() {
        return "Account Number: " + accNum +
               "\nAccount Holder: " + accHName +
               "\nBalance: Rs. " + balance +
               "\nBank: " + bankName +
               "\nBranch: " + branchName +
               "\nIFSC: " + ifsc;
    }
}
