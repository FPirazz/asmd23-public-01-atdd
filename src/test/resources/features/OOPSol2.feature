Feature: Grid Cell Selection and Movement

  Scenario: Selecting non-adjacent cells
    Given I have a 10 x 10 grid
    When The user clicks on cell in position (5, 5)
    Then The cell in position (5, 5) is numbered incrementally starting from 1

  Scenario: Moving cells when clicking an adjacent cell
    Given I have a 10 x 10 grid grid with some numbered cells in positions (3, 3), (5, 3)
    When The user clicks on a cell adjacent to a numbered cell, for example position (2, 3)
    Then All numbered cells move one position up and to the right, for example position (4, 4)
    And The clicked cell is not numbered, so position (2, 3)

  Scenario: Moving cells on subsequent clicks
    Given I have a 10 x 10 grid grid with some numbered cells in positions (3, 3), (5, 3)
    And The cells are already moving, by clicking position (2, 3)
    When The user clicks on any cell, for example position (1, 1)
    Then All numbered cells move one position up and to the right, so check positions (4, 4), (6, 4)

  Scenario: Ending the game when a cell moves out of bounds
    Given I have a 10 x 10 grid grid with some numbered cells in positions (3, 3), (9, 9)
    When A numbered cell moves out of the grid bounds, by clicking position (8, 9)
    Then The game ends