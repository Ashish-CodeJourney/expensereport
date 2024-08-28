package com.nelkinda.training;

public class SimpleExpenseFormatter implements ExpenseFormatter {

    @Override
    public String format(Expense expense) {
        String expenseName = switch (expense.type) {
            case DINNER -> "dinner";
            case BREAKFAST -> "breakfast";
            case CAR_RENTAL -> "car rental";
        };

        String mealOverExpensesMarker = expense.type == ExpenseType.DINNER && expense.amount > 5000 ||
                                        expense.type == ExpenseType.BREAKFAST && expense.amount > 1000 ? "X" : " ";

        return String.format("%s %d %s", expenseName, expense.amount, mealOverExpensesMarker);
    }

    @Override
    public String formatHeader() {
        return "Expenses " + new java.util.Date();
    }

    @Override
    public String formatFooter(int mealExpenses, int totalExpenses) {
        return String.format("Meal expenses: %d\nTotal expenses: %d", mealExpenses, totalExpenses);
    }
}
