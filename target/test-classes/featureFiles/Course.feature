@Course
Feature: Course

  Background: 
    Given User navigates to skillrary application
    And logs in into the application

  Scenario: Add and delete course
    When user navigates to course list page
    And clicks on new course button
    And adds a new course
    Then new course should be added to course list
    When user deletes the added course
    Then newly added course should be deleted from course list
    And User logs out of the application
