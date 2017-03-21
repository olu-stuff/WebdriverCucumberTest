Feature: recipes
  A user should be able to find recipes from the homepage

  Background: 
    Given am on the BBC food hompage

  @RunOnly
  Scenario Outline: use quick recipe finder to find recipes matching search criteria
    When I use the quick search to find "<query>" recipe
    Then I should see a Results Page with a list of recipe matching "<query>" search query

    Examples: 
      | query         |
      | pasta bake    |
      | shepherds pie |

  Scenario: Main Imagine on homepage should redirect user to the relevant ingredient and methods page
    When I click on the main image on the homepage
    Then I should be redirected to corresponding  recipes page
    And see displayed a summary
    And the chief
    And the ingredient
    And the prepartion guide

  Scenario: A ingredient page should have Related Recipes
    When I have select a recipe from the second carousel
    Then I should see displayed Related Recipes

  Scenario: A user should be able to paginate throught the main carousel
    When I select a dish from the main carousel other than the landing image
    Then I should be taken to the food collection page
    And see the similar recipes listed
    And see the relvant

  Scenario: verfiy all footer links redirect to the appraite pages
    When I cycle through all the links in the footer and get the http status
    Then each link should redirect to the corresponding page
