Feature: More hard test for learning Cucumber

  Rule: work with standard user

    Background:
      Given Browser is open

    Scenario: Using AND
      Given The Login page is open
      Then Username input is displayed


    Scenario: Using AND v.2
      Given The Login page is open
      Then Username input is displayed

  Rule: work with admin user

    Background:
      Given Browser is open

    Scenario: Using AND
      Given The Login page is open
      Then Username input is displayed


    Scenario: Using AND v.2
      Given The Login page is open
      Then Username input is displayed