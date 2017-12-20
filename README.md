# OutSystemsDigitalAutomatedTesting

Prrof of concept for a suite of automated tests for the Digital team, using Behavioral Driven Tests.

Here's an example of a BDT test:

      Feature: IT Resources

      Scenario: Download Report from IT Resources
        Given I open the OutSystems website
        And I navigate to "IT Resources" section
        When I download "Gartner Names OutSystems a Leader in High-Productivity aPaaS" report
        Then I see the Thank You page

Technlogies and Tools:

 - Development Environment: JetBrains IntelliJ IDEA
 - Test Framework: Cucumber and Gherkin
 - Execution Orchestration: Batch Scripting
 - Report Generation: Python Scripting


How to execute the tests:

 1. Open the project with JetBrains IntelliJ IDEA
 2. Compile full Java project
 3. Exeucte batch file runner\run.bat





