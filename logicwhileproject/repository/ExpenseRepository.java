package logicwhileproject.repository;

import logicwhileproject.model.Category;
import logicwhileproject.model.Expense;
import logicwhileproject.service.ExpenseService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExpenseRepository {
    private final HashMap<Integer, Expense> expenseMap = new HashMap<>();
    private final HashMap<Integer, Category> categoryMap = new HashMap<>();

    public String addExpense(Expense expense) {
        if (expense != null) {
            expenseMap.put(expense.getId(), expense);
            // First, create a new Category object
            Category category = new Category(expense.getName(), expense.getDesc());

// Then, put it in the map
            categoryMap.put(expense.getId(), category);return "Expense added successfully!";

        } else {
            return "Expense cannot be null!";
        }
    }
    public Map<Integer,Expense> getAllExpenses() {
        // Returning a new ArrayList prevents external code from modifying our internal map directly.
        return expenseMap;
    }

    public Expense getExpenseById(int id) {
        if (expenseMap.containsKey(id)) {
            return expenseMap.get(id);
        } else {
            return null; // or throw an exception
        }
    }

    public boolean checkforId(int id){
        return expenseMap.containsKey(id);
    }

    public void updateExpense(Expense expense) {
        Expense existingExpense = expenseMap.get(expense.getId());
        if (existingExpense != null) {
            // Update the existing expense with new values
            existingExpense.setName(expense.getName());
            existingExpense.setDesc(expense.getDesc());
            existingExpense.setPrice(expense.getPrice());
            existingExpense.setDate(expense.getDate());
            // Update the category as well
            Category category = new Category(expense.getName(), expense.getDesc());
            categoryMap.put(expense.getId(), category);
        } else {
            throw new IllegalArgumentException("Expense with ID " + expense.getId() + " does not exist.");
        }
    }

    public void deleteExpense(int id) {
        if (expenseMap.containsKey(id)) {
            expenseMap.remove(id);
            categoryMap.remove(id); // Also remove the associated category
        } else {
            throw new IllegalArgumentException("Expense with ID " + id + " does not exist.");
        }
    }

    public Map<String, Expense> getExpensesByCategory(String category) {
        Map<String, Expense> filteredExpenses = new HashMap<>();
        for (Expense expense : expenseMap.values()) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                filteredExpenses.put(expense.getName(), expense);
            }
        }
        return filteredExpenses;
    }

    public Map<String, Expense> getExpensesByDate(String date) {
        Map<String, Expense> filteredExpenses = new HashMap<>();
        for (Expense expense : expenseMap.values()) {
            if (expense.getDate().equals(date)) {
                filteredExpenses.put(expense.getName(), expense);
            }
        }
        return filteredExpenses;
    }

    public Map<Double, Expense> getExpensesByAmount(double amount) {
        Map<Double, Expense> filteredExpenses = new HashMap<>();
        for (Expense expense : expenseMap.values()) {
            if (expense.getPrice() == amount) {
                filteredExpenses.put(expense.getPrice(), expense);
            }
        }
        return filteredExpenses;
    }
}
