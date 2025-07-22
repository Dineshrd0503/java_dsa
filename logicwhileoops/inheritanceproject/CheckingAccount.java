package logicwhileoops.inheritanceproject;

public class CheckingAccount extends BankAccount {

    double overdraftLimit = 10000;

    CheckingAccount(String accno,double balance){
        super(accno, balance);
        System.out.println("overdarft limit is "+ overdraftLimit);
    }



    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Withdrawal failed. Amount exceeds overdraft limit.");
        }


    }
}
