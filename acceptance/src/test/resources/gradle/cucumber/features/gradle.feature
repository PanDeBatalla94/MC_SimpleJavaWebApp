Feature: Gradle-Cucumber integration

  @positive
  Scenario: Passing scenario
    Given A passing scenario
    When I press start the page display a message
    Then I go to main page

  @positive
  Scenario: Passing scenario general
    Given A passing scenario
    When I press start the page display a success message
    Then I go to main page

  @negative
  Scenario: Failing scenario
    Given A failing scenario
    When I press start the page display an error message
    Then I go to error page
    
    