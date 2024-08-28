Feature: ExpenseReport

  Scenario: one breakfast
    Given the following expenses:
      | Type      | Amount   | 
      | BREAKFAST | 100      |
    When printing the report 
    Then the report MUST look like this: 
      """
      Expenses <current date>
      breakfast 100 
      Meal expenses: 100
      Total expenses: 100
      """
