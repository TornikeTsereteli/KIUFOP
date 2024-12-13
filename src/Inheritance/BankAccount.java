package Inheritance;

public class BankAccount {
    // Attributes of all account classes:
    protected int account;
    protected double balance;
    // Constructor:
    public BankAccount (int id, double initial) {
        account = id; balance = initial;
    }
    // Object methods:
    public void deposit(double amount) {
        balance = balance+amount;
        System.out.print("Deposit into account "+account
                +"\n"+"Amount:\t\t"+amount+"\n"
                +"New balance:\t"+balance+"\n\n");
    }

    public boolean withdraw(double amount) {
        System.out.print("Withdrawal from account "+ account
                +"\n"+"Amount:\t\t"+ amount +"\n");
        if (amount > balance) {
            System.out.print("Sorry, insufficient funds...\n\n");
            return false;
        }
        balance = balance-amount;
        System.out.print("New balance:\t"+ balance +"\n\n");
        return true;
    }


}