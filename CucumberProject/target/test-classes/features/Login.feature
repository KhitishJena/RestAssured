Feature: Application Login

  Scenario: HomePage Default Login
    Given User is on Landing page
    When User Logins with id "satish" and password "Lulu123"
    And click sigin button
    Then Homepage is displayed
    And All cards are "true"
    
    Scenario: HomePage Default Login
    Given User is on Landing page
    When User Logins with id "Little" and password "Little123"
    And click sigin button
    Then Homepage is displayed
    And All cards are "false"

