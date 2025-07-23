package logicwhileoops.inheritanceproject;

import java.util.Scanner;
import logicwhileoops.inheritanceproject.BankAccount;
public class Main  {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter accno ");
        String accno=sc.nextLine();
        System.out.println("enter your baalnce");
        double balance=sc.nextDouble();
        BankAccount b=new BankAccount(accno, balance);
        b.setAccno(accno);
        b.setBalance(balance);
        SavingsAccount s=new SavingsAccount(accno, balance);
        while(true){
            System.out.println("1.Deposit\n2.Withdraw\n3.Check Balance\n4.Exit\n5.overdraftlimit\n6.fdaccount\n7.savingsaccount");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    s.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    s.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + s.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                case 5:
                    CheckingAccount c=new CheckingAccount(accno, balance);
                    System.out.println("Overdraft limit is: " + c.overdraftLimit);
                    System.out.println("enter amout to withdraw");
                    double overdraftAmount = sc.nextDouble();
                    c.withdraw(overdraftAmount);
                    break;
                case 6:

                    FDAAccount fdAccount = new FDAAccount(accno,balance);
                    System.out.println("Fixed Deposit created successfully.");
                    double fdamount=fdAccount.calculateMaturityAmount();
                    System.out.println("Maturity Amount: " + fdamount);
                    break;
                case 7:
                    SavingsAccount savingsAccount = new SavingsAccount(accno, balance);
                    System.out.println("Savings Account created successfully.");
                    System.out.println("Interest amount: " + savingsAccount.addInterest());
                    System.out.println("Current Balance: " + savingsAccount.getBalance());
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }





        }
    }
