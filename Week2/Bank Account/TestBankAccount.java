public class TestBankAccount {

    public static void main(String[] args) {
        // Test new Bank Account with deposits
        BankAccount myAccount = new BankAccount();
        System.out.println("My Bank Account No: " + myAccount.getAccountNumber());
        myAccount.depositMoney("Checking Account", 1000);
        myAccount.depositMoney("Savings Account", 5000);
        myAccount.displayTotalBalance();
        // Test total monies and accounts after deposits
        System.out.printf("\nTotal Money: $%d\n", BankAccount.totalMoneyBalance);
        System.out.printf("Total Accounts: %d\n", BankAccount.numAccounts);
        // Test for both insufficient checking and sufficient savings withdrawals
        myAccount.withdrawMoney("Checking Account", 1100);
        myAccount.withdrawMoney("Savings Account", 500);
        myAccount.displayTotalBalance();
        // Test total monies and accounts after withdrawals
        System.out.printf("\nTotal Money: $%d\n", BankAccount.totalMoneyBalance);
        System.out.printf("Total Accounts: %d\n", BankAccount.numAccounts);
        // Test additional bank account 
        BankAccount otherAccount = new BankAccount();
        System.out.println("\nOther Bank Account No: " + otherAccount.getAccountNumber());
        otherAccount.depositMoney("Savings Account", 1000);
        otherAccount.depositMoney("Checking Account", 5000);
        otherAccount.displayTotalBalance();
        // Test total monies and accounts after addition of another bank account
        System.out.printf("\nTotal Money: $%d\n", BankAccount.totalMoneyBalance);
        System.out.printf("Total Accounts: %d\n", BankAccount.numAccounts);
        // Test for sufficient checking and insufficient savings withdrawals
        otherAccount.withdrawMoney("Checking Account", 500);
        otherAccount.withdrawMoney("Savings Account", 1100);
        otherAccount.displayTotalBalance();
        // Test total monies and accounts after withdrawals from second bank account
        System.out.printf("\nTotal Money: $%d\n", BankAccount.totalMoneyBalance);
        System.out.printf("Total Accounts: %d\n", BankAccount.numAccounts);




    }
    
}
