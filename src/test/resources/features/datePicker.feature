Feature: Date Picker Navigation


  @unitTest
  Scenario: Navigate to Date Picker Page
    Given user go the home page
    When they click "Date Picker" link within Tester's Hub
    Then they'll be able to see heading "DatePicker"

  Scenario: Navigate to Alert page
    Given user go the home page
    When they click "Alert" link within Tester's Hub
    Then they'll be able to see heading "AlertBox"

  Scenario: User can select correct date
    Given user is on "DatePicker" page
    When they select month "April" year "2026"
    And they select date "15"
    Then they will have date as "04/15/2026"
