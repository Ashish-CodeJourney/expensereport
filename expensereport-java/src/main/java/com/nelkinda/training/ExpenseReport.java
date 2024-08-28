package com.nelkinda.training;

import java.util.List;

public class ExpenseReport {
    private final ReportPrinter printer;

    public ExpenseReport(ReportPrinter printer) {
        this.printer = printer;
    }

    public void printReport(List<Expense> expenses) {
        printer.printReport(expenses);
    }
}
