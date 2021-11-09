Feature: Practice Time tracker
  As an api user I want to execute request in order to get proper responses

  @Success @Luna
  Scenario Outline: Check the hours recorded for a project
    Given My account created in clockify and my Api-Key generated
    And   My valid workspace id
    And   My valid project id
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   status code <status> is obtained
    Then  Validate the expected response was obtained in <entity>

    @Project
    Examples:
      | operation | entity  | jsonName              | status |
      | GET       | PROJECT | projects/getTimeEntry | 200    |

  @Success
  Scenario Outline: Add hours to the chosen project
    Given My account created in clockify and my Api-Key generated
    And   My valid workspace id
    And   My valid project id
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   status code <status> is obtained
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName              | status |
      | POST      | PROJECT | ProjetAPI | projects/addTimeEntry | 201    |

  @Success
  Scenario Outline: Edit the time recorded
    Given My account created in clockify and my Api-Key generated
    And   My valid workspace id
    And   My valid project id
    And   I save time entry id
    And   I setting <startedHour>
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName               | status |
      | PUT       | PROJECT | ProjetAPI | projects/editTimeEntry | 200    |


   @Success
  Scenario Outline: Delete time recorded
    Given My account created in clockify and my Api-Key generated
    And My valid workspace id
    And My valid project id
    When  I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And   Got the status code <status>
    Then  I will get the proper status code '<statusCode>'
  @Project
    Examples:
      | operation | entity  | name      | jsonName                 | status |
      | DELETE    | PROJECT | ProjetAPI | projects/deleteTimeEntry | 200    |

