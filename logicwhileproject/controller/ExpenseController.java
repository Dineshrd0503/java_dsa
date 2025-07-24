package logicwhileproject.controller;

import logicwhileproject.model.Expense;
import logicwhileproject.service.ExpenseService;

import java.util.Scanner;

public class ExpenseController {
    ExpenseService expenseService = new ExpenseService();
    Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Welcome to Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3.edit expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. find expense by id");
            System.out.println("6.find expense by category");
            System.out.println("7. find expense by date");
            System.out.println("8.find expense by amount");
            System.out.println("9.find total expense by date");

            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    expenseService.addExpense();
                    System.out.println("expense added successfully!");
                }
                case 2 -> {
                    System.out.println("Expenses:");
                    expenseService.viewExpenses();
                    System.out.println("all expenses viewed successfully!");
                }
                case 3 -> {
                    System.out.print("Enter expense ID to edit: ");
                    int id = sc.nextInt();
                    expenseService.editExpense(id);
                    System.out.println("expense edited successfully!");
                }
                case 4 -> {
                    System.out.print("Enter expense ID to delete: ");
                    int id = sc.nextInt();
                    expenseService.deleteExpense(id);
                    System.out.println("expense deleted successfully!");
                }
                case 5 -> {
                    System.out.print("Enter expense ID to find: ");
                    int id = sc.nextInt();
                    Expense expense = expenseService.findExpenseById(id);
                    if (expense != null) {
                        System.out.println("Expense found: " + expense);
                    } else {
                        System.out.println("Expense not found.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter category to find expenses: ");
                    String category = sc.next();
                    expenseService.findExpenseByCategory(category);
                    System.out.println("Expenses in category '" + category + "' viewed successfully!");
                }
                case 7 -> {
                    System.out.print("Enter date to find expenses (YYYY-MM-DD): ");
                    String date = sc.next();
                    expenseService.findExpenseByDate(date);
                }
                case 8 -> {
                    System.out.print("Enter amount to find expenses: ");
                    double amount = sc.nextDouble();
                    expenseService.findExpenseByAmount(amount);
                }
                case 9 -> {
                    System.out.print("Enter date to find total expense: ");
                    String date = sc.next();
                    double totalExpense = expenseService.findTotalExpenseByDate(date);
                    System.out.println("Total expense on " + date + ": " + totalExpense);
                }
                case 10 -> {
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    sc.close();
                    return;
                }

            }
        }
    }
}
