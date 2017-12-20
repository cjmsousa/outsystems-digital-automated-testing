Feature: Community

  Scenario: Perform community search
    Given I open the OutSystems website
    And I navigate to "Community" section
    When I search for "Silk" in community
    Then I see community search results are displayed