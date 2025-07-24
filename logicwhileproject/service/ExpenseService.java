package logicwhileproject.service;

import logicwhileproject.model.Expense;
import logicwhileproject.repository.ExpenseRepository;

import java.util.Map;
import java.util.Scanner;

public class ExpenseService {
    Scanner sc = new Scanner(System.in);
    ExpenseRepository expenseRepository = new ExpenseRepository();

    public void addExpense() {
        System.out.println("enter expense id");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        System.out.println("enter expense name");
        String name = sc.nextLine();
        System.out.println("enter expense price");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline left-over
        System.out.println("enter expense date");
        String date = sc.nextLine();
        System.out.println("enter expense category");
        String categoryName = sc.nextLine();
        System.out.println("enter expense description");
        String description = sc.nextLine();
        Expense expense = new Expense(id, date, price, name, description, categoryName);
        expenseRepository.addExpense(expense);


    }

    public void viewExpenses() {
        Map<Integer, Expense> values = expenseRepository.getAllExpenses();
        if (values.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println("Expenses:");
            for (Map.Entry<Integer, Expense> entry : values.entrySet()) {
                Expense expense = entry.getValue();
                System.out.println("ID: " + expense.getId() + ", Name: " + expense.getName() +
                        ", Price: " + expense.getPrice() + ", Date: " + expense.getDate() +
                        ", Category: " + expense.getCategory() + ", Description: " + expense.getDesc());
            }
        }

    }

    public String editExpense(int id) {
        if (!expenseRepository.checkforId(id))
            return "Expense with ID " + id + " not found.";
        else {
            System.out.println("Enter new expense name:");
            String name = sc.nextLine();
            System.out.println("Enter new expense price:");
            double price = sc.nextDouble();
            sc.nextLine(); // Consume newline left-over
            System.out.println("Enter new expense date:");
            String date = sc.nextLine();
            System.out.println("Enter new expense category:");
            String categoryName = sc.nextLine();
            System.out.println("Enter new expense description:");
            String description = sc.nextLine();
            Expense expense = new Expense(id, date, price, name, description, categoryName);
            expenseRepository.updateExpense(expense);
            return "Expense updated successfully.";
        }

}

    public String deleteExpense(int id) {
        if(!expenseRepository.checkforId(id))
            return "Expense with ID " + id + " not found.";
        else {
            expenseRepository.deleteExpense(id);
            return "Expense with ID " + id + " deleted successfully.";
        }
    }

    public void findExpenseByCategory(String category) {
        Map<String, Expense> expensesByCategory = expenseRepository.getExpensesByCategory(category);
        for(Map.Entry<String, Expense> entry : expensesByCategory.entrySet()) {
            Expense expense = entry.getValue();
            System.out.println("ID: " + expense.getId() + ", Name: " + expense.getName() +
                    ", Price: " + expense.getPrice() + ", Date: " + expense.getDate() +
                    ", Category: " + expense.getCategory() + ", Description: " + expense.getDesc());
        }
    }

    public void findExpenseByDate(String date) {
        Map<String, Expense> expensesByDate = expenseRepository.getExpensesByDate(date);
        for(Map.Entry<String, Expense> entry : expensesByDate.entrySet()) {
            Expense expense = entry.getValue();
            System.out.println("ID: " + expense.getId() + ", Name: " + expense.getName() +
                    ", Price: " + expense.getPrice() + ", Date: " + expense.getDate() +
                    ", Category: " + expense.getCategory() + ", Description: " + expense.getDesc());
        }
    }

    public void findExpenseByAmount(double amount) {
        Map<Double,Expense> expensesByAmount = expenseRepository.getExpensesByAmount(amount);
        for(Map.Entry<Double, Expense> entry : expensesByAmount.entrySet()) {
            Expense expense = entry.getValue();
            System.out.println("ID: " + expense.getId() + ", Name: " + expense.getName() +
                    ", Price: " + expense.getPrice() + ", Date: " + expense.getDate() +
                    ", Category: " + expense.getCategory() + ", Description: " + expense.getDesc());
        }
    }

    public double findTotalExpenseByDate(String date) {
    Map<String, Expense> expensesByDate = expenseRepository.getExpensesByDate(date);
    double totalExpense = 0.0;
    for (Expense expense : expensesByDate.values()) {
        totalExpense += expense.getPrice();
    }
        return totalExpense;
    }

    public Expense findExpenseById(int id) {
        Expense expense=expenseRepository.getExpenseById(id);
        return expense;
    }
}
