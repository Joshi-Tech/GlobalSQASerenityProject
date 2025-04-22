Feature: Sample page feature


  Scenario: Navigate to Sample Page
    Given I go the home page
    When I click "Sample Page" link within Tester's Hub
    Then I'll be able to see heading "Sample Page Test"

  Scenario: Complete Sample Page
    Given User is on "Sample Page" page
    When  I complete the Sample Page
    Then I can see text "Message Sent (go back)"