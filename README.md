**Test scope covered as mentioned in the forms:**

1.**Automate the login functionality (successful login).**

Feature: Login and Dynamic Table Validation
  @LoginTest   **// Tag name to run the specific file**
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

2. **Automate the login functionality (failure scenarios)**
   
  @LoginTests  **// Tag name to run the specific file**
    Scenario: Validate Login error message
      When user enter invalid credentials
      Then User should throw message

  3. **Validate a dynamic table (e.g. verify data matches given criteria or calculate total from column values)**.

  Feature: Dynamic Table Validation
  @SmokeTests
  Scenario: Successful Login
    Given User launches the application
    When User enters click the dropdown
    And User able to get the total columns
    When User launches the another cascading application  **//Test a dropdown that dynamically updates based on other inputs (e.g. cascading dropdowns).**

4. **Implemneted the Page Object Model (POM) for test organization & integrate with Cucumber for behavior-driven development.**
         src/main/java/Pages

5.**Implemented reusable utilities (e.g. reading properties, logging).**
          src/main/java/utility/propertyreader
          src/main/java/utility/LoggerUtil

6.**Add support for running tests on multiple browsers.** - using driverfactory class
           src/main/java/utility/Driverfactory

7.**Provide an option for parameterized test execution (e.g. run tests with different data sets).** implemented in feature file using the example keyword
              src/main/test/resources/features/Login.feature

8.**Use Maven for build and dependency management.** 
      Implemented the maven dependency

9.**Configure a simple Jenkins pipeline script to run the tests.**
     Implemented the simple Jenkins pipeline script
    http://localhost:8080/job/CucumberFrameworkTests/org.example$Selenium_Framework/3/consoleText

10.**Generate detailed reports using a library like ExtentReport** 
      Implemented the Extendreports under Example/reports/Extendreport.html




