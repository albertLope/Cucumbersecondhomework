Feature:  View all orders

  Scenario: View all orders

    Given Navigate to website and login
    And Verify 8 items are in the page
    When Click on items
    |checkAll|
    |deleteSelected|
    Then Verify 0 items are in the page

