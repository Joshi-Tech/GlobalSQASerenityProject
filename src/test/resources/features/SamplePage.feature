Feature: Sample page feature

  @unitTest
  Scenario: Navigate to Sample Page
    Given user go the home page
    When they click "Sample Page" link within Tester's Hub
    Then they'll be able to see heading "Sample Page Test"

  @smoke
  Scenario: Complete Sample Page
    Given user is on "Sample Page" page
    When  I complete the Sample Page
    Then I can see text "Your message has been sent"
