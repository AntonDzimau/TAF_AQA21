Feature: Parameterized  test


  Scenario: Simple parameterization
    Given Browser is open
    * The Login page is open
    When User "atrostyanko+aqa21@gmail.com" with password "Qwertyu#1" logged in
    Then Dashboard page is displayed
    * project with ID = 23 is displayed

  Scenario Outline: Sheet
    Given Browser is open
    * The Login page is open
    When User "<username>" with password "<password>" logged in
    Then Dashboard page is displayed
    * project with ID = <projectID> is displayed
    Examples:
      | username                    | password  | projectID |
      | atrostyanko+aqa21@gmail.com | Qwertyu#1 | 23        |


  Scenario: Doc Strings
    Given a description with text
        """
        SOME TITLE!!!!
        LOREM IPSUM
        LOREM IPSUM
        LOREM IPSUM
        LOREM IPSUM
        LOREM IPSUM
        LOREM IPSUM
        """
