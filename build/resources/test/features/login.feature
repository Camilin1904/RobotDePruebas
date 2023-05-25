#Author: Camilo Carmona Valencia
@HistoriaDeUsuario
  Feature: Verify the validation form
    Me as a user WANT to enter the colorlib page TO verify the validation form

  Scenario Outline: Verify the validation form
    Given I enter with my credentials
    |User|Password|
    |<User>|<Password>|
    When I proceed with the authentication
    And enter submenu form validations
    And check the title of the form on the screen
    And fill all the fields
      |Required|Select|MultipleSelect|Url|Email|Password2|ConfirmPassword|MinField|MaxField|Number|IP|Date|DateEarlier|
      |<Required>|<Select>|<MultipleSelect>|<Url>|<Email>|<Password2>|<ConfirmPassword>|<MinField>|<MaxField>|<Number>|<IP>|<Date>|<DateEarlier>|
    And click button to validate
    Then field required will be empty

    Examples:
      |User|Password|Required|Select|MultipleSelect|Url|Email|Password2|ConfirmPassword|MinField|MaxField|Number|IP|Date|DateEarlier|
      |admin|admin|prueba|option2|option3|http://dfsdfd.com|a@q.com|123|123|111111|null|42.00|192.168.3.200|2023-5-22|2010-12-10|

