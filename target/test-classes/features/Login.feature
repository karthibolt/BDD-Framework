Feature: Login and Dynamic Table Validation
  @LoginTest
 Scenario Outline: Successful Login
    Given User is on the login page
    When User enters "<username>" and "<password>"
    Then User is navigated to the dashboard
    And user is able to click the logout
    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | problem_user    | secret_sauce |

  @LoginTests
    Scenario: Validate Login error message
      When user enter invalid credentials
      Then User should throw message