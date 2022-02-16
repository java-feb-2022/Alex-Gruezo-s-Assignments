import java.util.Random;

public class BankAccount {

    private double checkingBalance;
    private double savingsBalance;
    private int accountNumber;

    public static int numAccounts = 0;
    public static int totalMoneyBalance = 0;

    private static int createAccountNumber() {

        Random rand = new Random();
        int randomAccount = rand.nextInt(1000000000) + 999999999;

        return randomAccount;
    }

    public int getAccountNumber() {

        return this.accountNumber;

    }

    public BankAccount () {

        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = BankAccount.createAccountNumber();
        BankAccount.numAccounts += 1;

    }
    
    public double getCheckingBalance() {
        
        return this.checkingBalance;

    }

    public double getSavingsBalance() {

        return this.savingsBalance;

    }

    public void depositMoney (String account, double amount) {

        if (account.equals("Savings Account")) {
            this.savingsBalance += amount;
        }
        else if (account.equals("Checking Account")) {
            this.checkingBalance += amount;
        }

        BankAccount.totalMoneyBalance += amount;

    }

    public void withdrawMoney (String account, double amount) {
        if (account.equals("Savings Account")){
            if (amount > this.savingsBalance) {
                System.out.println ("\nInsufficient funds");
            }
            else {
                this.savingsBalance -= amount;
                BankAccount.totalMoneyBalance -= amount;
            }    
        }
        else if (account.equals("Checking Account")) {
            if (amount > this.checkingBalance) {
                System.out.println ("\nInsufficient funds");
            }
            else {
                this.checkingBalance -= amount;
                BankAccount.totalMoneyBalance -= amount;
            }
        }
    }

    public void displayTotalBalance() {

        System.out.printf ("\nSavings Balance: $%.2f\nChecking Balance: $%.2f\n", this.savingsBalance, this.checkingBalance);

    }

}