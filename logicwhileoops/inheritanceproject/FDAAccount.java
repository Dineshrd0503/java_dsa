package logicwhileoops.inheritanceproject;

import org.w3c.dom.ls.LSOutput;

public class FDAAccount extends BankAccount{


    int termInYears=5;
    double fdInterestRate=0.12;
     public FDAAccount(String accno, double balance) {
        super(accno, balance);
         System.out.println("termsInYears "+ termInYears+ " fdInterestRate "+ fdInterestRate);
     }



    //ot be directly placed here as it's not inside a method or constructor.

//    System.out.println("Fixed Deposit Account created with account number: " + accno + " and balance: " + balance);

    double maturity=0.0;
    public double calculateMaturityAmount(){
        maturity=balance+(balance*fdInterestRate*termInYears)/100;
        return maturity;
    }
}
