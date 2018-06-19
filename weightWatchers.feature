@regression @weightWatchers



Feature: weightWatchers feature


  Background
    Given I am on weightWatchers home page



  Scenario: Schedule a meeting by zipcode
    When I click on findMeeting a findMeetingwindow will appear
    And I verify the page title contains Get Schedules & Times Near You
    And I enter Zipcode on meeting search textbox
    And I click on searchBox to get the location nearby
    And I click on the firstLocationOption
    And I get hours of operation
    And I verify the first selection
