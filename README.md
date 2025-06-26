# Serenity BDD Automation Framework

## Why Serenity?

- Serenity is an **open-source** framework designed to automate testing for **Java-based** applications.
- It integrates seamlessly with BDD tools like **Cucumber**.
- Promotes the **Page Object Model** and separation of concerns.
- Supports **parameterized tests** and **parallel execution** to save time.
- Has an active community and extensive documentation.
- Provides excellent **HTML reports** useful for both technical and non-technical stakeholders.
- Integrates well with **Maven**, **Gradle**, **Jenkins**, and **Selenium WebDriver**.
- Reduces verbosity compared to plain Selenium (e.g., no need to write `driver.findElement()` explicitly).

## Tools Used

| Tool/Library         | Purpose                                  |
|----------------------|------------------------------------------|
| **Serenity BDD**     | Test automation framework                |
| **Java 21**          | Programming language                     |
| **Maven 3.8**        | Build and dependency management tool     |
| **JUnit**            | Test runner                              |
| **Serenity Reports** | Reporting tool                           |
| **Lombok**           | Reduces boilerplate code                 |
| **Java Faker API**   | Fake data generation                     |
| **Headless Mode**    | Runs browser tests without GUI (faster)  |

## How to Run Tests

Tests can be executed in several ways:

1. **Via Terminal**  
   Run all tests using:
   ```bash
   mvn clean verify
   ```
2. **Alternatively**
   * Runner class : Test can be run from ###CucumberTestSuite### class. Which in src->test->runner->tests foler.
   * Feature Files : In order to run tests for a particular feature, tests can be run by opening 
   a particular feature file.
   * Tags : Tags are being used so that a particular type of tests can be run.
   For example, @unitTest or @smoke. These tags can be edited in the runner file.

## How to access Serenity report?
   * Serenity report can be accessed by index.html file. Which can be find in target -> site -> serenity folder.
   * Alternatively when running tests through terminal by **mvn clean verify**. 
   There will be a link generated with **Full Report**
        
