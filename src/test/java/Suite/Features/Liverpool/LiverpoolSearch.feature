Feature: Liverpool site search Validations

  @LiverpoolTest
  Scenario: Play Station search flow
    Given User navigate to "liverpool site" site
    When User wait until page is totally loaded
    And User search for "Playstation"
    Then User should see playstation "para Play" game items
    And User should see playstation console item as "Consola PlayStation"
    When User clicks on "Consola PlayStation" item
    Then User should be able to see title and price

  @LiverpoolTest
  Scenario: Smart Tv search flow
    Given User navigate to "liverpool site" site
    When User wait until page is totally loaded
    And User search for "smart tv"
    Then User should see size and price filters
    And User filter by 55 inches as "55 pulgadas", price as "Mas de $10000.0" and "SONY" brand
    Then User is able to see results count