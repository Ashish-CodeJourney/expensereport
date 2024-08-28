Feature: ExpenseReport

  Scenario: single breakfast expense
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

  Scenario: multiple expenses with some exceeding limits
    Given the following expenses:
      | Type       | Amount |
      | BREAKFAST  | 1200   |
      | DINNER     | 6000   |
      | CAR_RENTAL | 3000   |
    When printing the report
    Then the report MUST look like this:
      """
      Expenses <current date>
      breakfast 1200 X
      dinner 6000 X
      car rental 3000
      Meal expenses: 7200
      Total expenses: 10200
      """
