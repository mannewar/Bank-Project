import java.util.Scanner;

public class BankFrontOffice {

    public static void main(String[] args) {
        Bank hdfcBank = new Bank();
        Scanner scn = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n===== HDFC BANK MENU =====");
                System.out.println("1. Open Account");
                System.out.println("2. Display Account Details");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Balance Enquiry");
                System.out.println("6. Transfer Money");
                System.out.println("7. Display All Accounts");
                System.out.println("8. Exit");

                System.out.print("Enter option: ");
                int option = scn.nextInt();
                scn.nextLine();

                switch (option) {
                    case 1:
                        hdfcBank.openAccount();
                        break;
                    case 2:
                        System.out.print("Enter account number: ");
                        long accNum = scn.nextLong();
                        scn.nextLine();
                        hdfcBank.displayAccount(accNum);
                        break;
                    case 3:
                        System.out.print("Enter account number: ");
                        accNum = scn.nextLong();
                        System.out.print("Enter amount to deposit: ");
                        double depAmt = scn.nextDouble();
                        scn.nextLine();
                        hdfcBank.deposit(accNum, depAmt);
                        break;
                    case 4:
                        System.out.print("Enter account number: ");
                        accNum = scn.nextLong();
                        System.out.print("Enter amount to withdraw: ");
                        double withAmt = scn.nextDouble();
                        scn.nextLine();
                        hdfcBank.withdraw(accNum, withAmt);
                        break;
                    case 5:
                        System.out.print("Enter account number: ");
                        accNum = scn.nextLong();
                        scn.nextLine();
                        hdfcBank.balanceEnquiry(accNum);
                        break;
                    case 6:
                        System.out.print("Enter source account number: ");
                        long src = scn.nextLong();
                        System.out.print("Enter destination account number: ");
                        long dest = scn.nextLong();
                        System.out.print("Enter amount to transfer: ");
                        double amt = scn.nextDouble();
                        scn.nextLine();
                        hdfcBank.transferMoney(src, dest, amt);
                        break;
                    case 7:
                        System.out.println(hdfcBank);
                        break;
                    case 8:
                        System.out.println("Thank you for using HDFC Bank!");
                        scn.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scn.nextLine(); // clear input
            }
        }
    }
}
