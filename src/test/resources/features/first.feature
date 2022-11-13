Feature: Beginning test for learning Cucumber

  Scenario: Simple test without body

  Scenario: Simple test with Given
      Given Browser is open

    Scenario: Simple test with Given and When
      Given Browser is open
      When The Login page is open

  Scenario: Simple test with all keywords
    Given Browser is open
    When The Login page is open
    Then Username input is displayed