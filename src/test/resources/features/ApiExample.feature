Feature: As an api user I want to execute request in order to get proper responses

  @Success
  Scenario: Check the hours recorded for a project
    Given My account created in clockify and my Api-Key generated
    And   I'm in the Projects tab
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   Got the status code <status>
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName    | status |
      | GET       | PROJECT | ProjetAPI | projects/rq | 200    |
      | GET       | PROJECT | ProjetAPI | projects/rq | 400    |
      | GET       | PROJECT | ProjetAPI | projects/rq | 401    |
      | GET       | PROJECT | ProjetAPI | projects/rq | 403    |
      | GET       | PROJECT | ProjetAPI | projects/rq | 404    |


  @Success
  Scenario: Add hours to the chosen project
    Given My account created in clockify and my Api-Key generated
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   Got the status code <status>
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName    | status |
      | POST      | PROJECT | ProjetAPI | projects/rq | 200    |

  @Success
  Scenario: Edit the time recorded
    Given My account created in clockify and my Api-Key generated
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   Got the status code <status>
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName    | status |
      | PUT       | PROJECT | ProjetAPI | projects/rq | 200    |


  @Success
  Scenario: Check the hours registered
    Given My account created in clockify and my Api-Key generated
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And Got the status code <status>
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName    | status |
      | GET       | PROJECT | ProjetAPI | projects/rq | 200    |

  @Success
  Scenario: Delete time recorded
    Given My account created in clockify and my Api-Key generated
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   Got the status code <status>
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName    | status |
      | DELETE    | PROJECT | ProjetAPI | projects/rq | 200    |

