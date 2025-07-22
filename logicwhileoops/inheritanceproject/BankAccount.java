package logicwhileoops.inheritanceproject;

public  class BankAccount implements Opeartions {
    static String accno;
    static double balance;
    public BankAccount(String accno1, double balance1) {
        accno = accno1;
        balance = balance1;
        System.out.println("account created successfully");
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println("amount deposited successfully. New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance-500 >=amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
