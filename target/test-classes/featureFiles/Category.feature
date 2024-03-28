@Category
Feature: Category

  Background: 
    Given User navigates to skillrary application
    And logs in into the application

  Scenario: Add and delete category
    When user navigates to category page
    And clicks on new category button
    And adds a new category
      | RPA |
    Then new category should be added to category list
    When user deletes the added category
    Then newly added category should be deleted from category list
    And User logs out of the application
