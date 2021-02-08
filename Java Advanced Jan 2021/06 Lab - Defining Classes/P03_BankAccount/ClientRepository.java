package _11_DefiningClasses_LAB.P03_BankAccount;

import java.util.LinkedHashMap;

public class ClientRepository {
    private LinkedHashMap<Integer, BankAccount> bankAccounts;

    public ClientRepository() {
        this.bankAccounts = new LinkedHashMap<>();
    }

    public void create() {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.put(bankAccount.getId(), bankAccount);
        System.out.println(String.format("Account ID%d created",
                bankAccount.getId()));
    }

    public void deposit(int[] commands) {


        int accountId = commands[0];
        int amount = commands[1];
        BankAccount bankAccount = getBankAccount(accountId);
        if (!isValidAccount(bankAccount)) {
            return;
        }

        System.out.printf("Deposited %d to ID%d%n", amount, bankAccount.getId());
        bankAccount.deposit(amount);
        bankAccounts.put(accountId, bankAccount);
    }

    public void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    public void getInterest(int[] commands) {
        int accountId = commands[0];
        int years = commands[1];

        BankAccount bankAccount = getBankAccount(accountId);

        if (!isValidAccount(bankAccount)) {
            return;
        }
        double interest = bankAccount.getInterest(years);
        System.out.printf("%.2f%n", interest);
    }

    private BankAccount getBankAccount(int accountId) {
        return bankAccounts.get(accountId);
    }

    private static boolean isValidAccount(BankAccount bankAccount) {
        if (bankAccount == null) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }
}