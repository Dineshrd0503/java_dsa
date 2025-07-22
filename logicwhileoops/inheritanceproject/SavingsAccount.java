package logicwhileoops.inheritanceproject;

public class SavingsAccount extends BankAccount {

   SavingsAccount(String accno, double balance) {
        super(accno,balance);
    }
    double interestRate=0.04;
    double addInterest() {
        if (balance > 0) {
            double interest = balance * interestRate / 100;
            balance += interest;
            System.out.println("intertes is" + interest);
            return balance;
        }
        return balance;
    }

}
