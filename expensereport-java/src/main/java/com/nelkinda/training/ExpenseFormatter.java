package com.nelkinda.training;

public interface ExpenseFormatter {
    String format(Expense expense);
    String formatHeader();
    String formatFooter(int mealExpenses, int totalExpenses);
}
