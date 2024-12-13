package Inheritance;

public class SavingsAccount extends BankAccount {
    protected double interest_rate;
    // Constructor:
    public SavingsAccount (int id, double init, double rate) {
        super(id,init); interest_rate = rate;
    }
    // Extra object method:
    public void add_interest() {
        balance = balance * (1+interest_rate);
        System.out.print("Interest added to account: "+ account
                +"\nNew balance:\t"+ balance +"\n\n");
    }


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1, 100);
        bankAccount.deposit(200);
        System.out.println(bankAccount.balance);
        bankAccount.withdraw(150);
        System.out.println(bankAccount.balance);

        SavingsAccount savingsAccount = new SavingsAccount(12,400,0.2);
        savingsAccount.add_interest();
        System.out.println(savingsAccount.balance);


    }
}
