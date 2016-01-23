Feature: Facts about cats

  Scenario: Collecting cat images
    When I choose to get an image of a cat
    Then I should be displayed the image url
    And I should have the cat image on my filesystem

  Scenario: Various cat categories
    When I choose to find out more about the categories of cats
    Then I should be displayed the cat categories

  Scenario: Find out cat facts
    When I choose to read a fact about cats
    Then I should be displayed the cat fact