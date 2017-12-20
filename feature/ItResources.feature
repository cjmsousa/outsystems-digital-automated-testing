Feature: IT Resources

Scenario: Download Report from IT Resources
	Given I open the OutSystems website
	And I navigate to "IT Resources" section
	When I download "Gartner Names OutSystems a Leader in High-Productivity aPaaS" report
	Then I see the Thank You page