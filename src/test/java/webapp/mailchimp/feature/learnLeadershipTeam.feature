Feature: MailChimp leadership team info test
  Extracting Mail Chimp Leadership Team from webpage

  @leadershipteam
  Scenario: Save MailChimp Leadership team info to csv file
    Given I launch browser
    Then I open MailChimp WebPage
    Then I navigate to About Page
    And I click on learnmore leadership team link
    And I save leadership team info to a csv file

