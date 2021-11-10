Feature: Practice Time tracker
  As an api user I want to execute request in order to get proper responses

  @Success  @Luna
  Scenario Outline: Check the hours recorded for a project
    Given My account created in clockify and my Api-Key generated
    And   My valid workspace id
    And   My valid project id
    When  I perform a '<operation>' to '<entity>' with the endpoint '<jsonName>' and ''
    And   status code <status> is obtained
    Then  Validate the expected response was obtained in <entity>
    @Project
    Examples:
      | operation | entity   | jsonName              | status |
      | GET       | GET_TIME | project/getTimeEntry  | 200    |

  @Success
  Scenario Outline: Add hours to the chosen project
    Given My account created in clockify and my Api-Key generated
    And   My valid workspace id
    And   My valid project id
    And   Add time to the project
    When  I perform a '<operation>' to '<entity>' with the endpoint '<jsonName>' and ''
    And   status code <status> is obtained
    Then  Validate that the corresponding <time> was added
  @Project
    Examples:
      | operation | entity   | jsonName             | status |
      | POST      | ADD_TIME | project/addTimeEntry | 201    |

  @Success
  Scenario Outline: Edit the time recorded
    Given My account created in clockify and my Api-Key generated
    And   My valid workspace id
    And   My valid project id
    And   I save time entry id
    And   I setting <startedHour>
    When   I perform a '<operation>' to '<entity>' with the endpoint '<jsonName>' and ''
    And   status code <status> is obtained
    Then  Validate that the edited time is as expected
  @Project
    Examples:
      | operation | entity    | jsonName               | status |
      | PUT       | EDIT_TIME | project/editTimeEntry  | 200    |


   @Success
  Scenario Outline: Delete time recorded
     Given My account created in clockify and my Api-Key generated
     And   My valid workspace id
     And   My valid project id
     When  I perform a '<operation>' to '<entity>' with the endpoint '<jsonName>' and ''
     And   status code <status> is obtained
     Then  Validate that the '<statusCode>' is as expected
  @Project
    Examples:
      | operation | entity      | jsonName                 | status |
      | DELETE    | DELETE_TIME | project/deleteTimeEntry  | 204    |