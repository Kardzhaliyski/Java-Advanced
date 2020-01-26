package bankaccount;

public class BankAccount {
    private static int accountsCount = 0;
    private static double interestRate = 0.02;
    private int id;
    private double balance = 0;

    public BankAccount() {
        this.id = ++accountsCount;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int getId() {
        return id;
    }

    public double getProfitAfterYears(int years) {
        return balance * interestRate * years;
    }
}
