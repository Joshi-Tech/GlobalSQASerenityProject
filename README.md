# Serenity BDD Automation Framework

## Why Serenity?
<div style="font-size:18px; line-height:1.7;">
<ul>
  <li>Serenity is an <strong>open-source</strong> framework designed to automate testing for <strong>Java-based</strong> applications.</li>
  <li>It integrates seamlessly with BDD tools like <strong>Cucumber</strong>.</li>
  <li>Promotes the <strong>Page Object Model</strong> and separation of concerns.</li>
  <li>Supports <strong>parameterized tests</strong> and <strong>parallel execution</strong> to save time.</li>
  <li>Has an active community and extensive documentation.</li>
  <li>Provides excellent <strong>HTML reports</strong> useful for both technical and non-technical stakeholders.</li>
  <li>Integrates well with <strong>Maven</strong>, <strong>Gradle</strong>, <strong>Jenkins</strong>, and <strong>Selenium WebDriver</strong>.</li>
  <li>Reduces verbosity compared to plain Selenium (e.g., no need to write <code>driver.findElement()</code> explicitly).</li>
</ul>
</div>


## Tools Used

<table style="font-size:17px; line-height:1.6; width:100%;">
  <thead>
    <tr>
      <th style="text-align:left;">Tool / Library</th>
      <th style="text-align:left;">Purpose</th>
    </tr>
  </thead>
  <tbody>
    <tr><td>Serenity BDD</td><td>Test automation framework</td></tr>
    <tr><td>Java 21</td><td>Programming language</td></tr>
    <tr><td>Maven 3.8</td><td>Build and dependency management tool</td></tr>
    <tr><td>JUnit</td><td>Test runner</td></tr>
    <tr><td>Serenity Reports</td><td>Reporting tool</td></tr>
    <tr><td>Lombok</td><td>Reduces boilerplate code</td></tr>
    <tr><td>Java Faker API</td><td>Fake data generation</td></tr>
    <tr><td>Headless Mode</td><td>Runs browser tests without GUI (faster)</td></tr>
  </tbody>
</table>


## How to Run Tests

<font size="4">Tests can be executed in several ways:</font>

1. <font size="4">**Via Terminal**  
   Run all tests using:</font>
   ```bash
   mvn clean verify
   ```
   
   
2. <font size="4">**Alternatively**
   * Runner class : Test can be run from **CucumberTestSuite** class. Which in src->test->runner->tests foler.
   * Feature Files : In order to run tests for a particular feature, tests can be run by opening 
   a particular feature file.
   * Tags : Tags are being used so that a particular type of tests can be run.
   For example, @unitTest or @smoke. These tags can be edited in the runner file.</font>

## How to access Serenity report?
   <div style="font-size:17px; line-height:1.7;">
<ul>
  <li>Serenity report can be accessed by <strong>index.html</strong> file, which can be found in <strong>target → site → serenity</strong> folder.</li>
  <li>Alternatively, when running tests through terminal using <strong>mvn clean verify</strong>, a link will be generated with <strong>Full Report</strong>.</li>
</ul>
</div>

        
