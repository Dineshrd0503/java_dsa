package logicwhileproject;

import logicwhileproject.controller.ExpenseController;

public class Main {
    public static void main(String[] args) {
        ExpenseController expenseController = new ExpenseController();
        expenseController.start();
    }
}
