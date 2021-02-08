package _11_DefiningClasses_LAB.P03_BankAccount;

public class BankAccount {

    private static int accountsCount = 0;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount() {
        accountsCount++;
        this.id = accountsCount;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }


    public double getInterest(int years) {
        return this.balance * (this.interestRate * years);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}