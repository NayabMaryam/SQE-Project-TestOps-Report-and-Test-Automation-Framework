Feature: Category Navigation on DemoBlaze

  Scenario Outline: Verify category product display
    When I click on the "<category>" category
    Then I should see the products for "<category>" category

    Examples:
      | category |
      | Phones   |
      | Laptops  |
      | Monitors |
