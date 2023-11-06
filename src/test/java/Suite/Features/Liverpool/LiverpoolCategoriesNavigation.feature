Feature: Liverpool Categories Validation

  @LiverpoolTest
  Scenario: Categories navigation
    Given User navigate to "liverpool site" site
    When User wait until page is totally loaded
    And User click for "Belleza" category and click on "Perfumes Hombre" sub category
    Then User filter by "DIOR" brand
    And User is able to see listing of "Dior" brand selection