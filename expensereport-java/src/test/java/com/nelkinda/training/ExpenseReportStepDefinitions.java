package com.nelkinda.training;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseReportStepDefinitions {
    private List<Expense> expenses;
    private ByteArrayOutputStream outputStream;

    @Given("the following expenses:")
    public void the_following_expenses(List<List<String>> expenseData) {
        expenses = new ArrayList<>();
        for (List<String> row : expenseData) {
            Expense expense = new Expense();
            expense.type = ExpenseType.valueOf(row.get(0).toUpperCase());
            expense.amount = Integer.parseInt(row.get(1));
            expenses.add(expense);
        }
    }

    @When("printing the report")
    public void printing_the_report() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        ExpenseReport report = new ExpenseReport();
        report.printReport(expenses);
        System.setOut(System.out);
    }

    @Then("the report MUST look like this:")
    public void the_report_must_look_like_this(String expectedOutput) {
        String actualOutput = outputStream.toString().trim();
        String currentDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date());
        String expectedWithDate = expectedOutput.replace("<current date>", currentDate).trim();
        
        assertEquals(expectedWithDate, actualOutput);
    }
}
