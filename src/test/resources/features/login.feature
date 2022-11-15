Feature: Login tests

  Scenario: Logging in with the correct credentials
    Given Browser is open
    * The Login page is open
    When User logins with correct credentials (login - "atrostyanko+aqa21@gmail.com", password - "Qwertyu#1")
    Then Dashboard page is displayed

  Scenario: Logging in with the incorrect password
    Given Browser is open
    * The Login page is open
    When User logins with incorrect password (login - "atrostyanko+aqa21@gmail.com", password - "error")
    Then  Login page is still displayed
    * The error text ("Email/Login or Password is incorrect. Please try again.") appeared on the page

  Scenario: Logging in with the incorrect username
    Given Browser is open
    * The Login page is open
    When User logins with incorrect password (login - "incrorrectLogin", password - "Qwertyu#1")
    Then Login page is still displayed
    * The error text ("Email/Login or Password is incorrect. Please try again.") appeared on the page