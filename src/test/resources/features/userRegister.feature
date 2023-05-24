@Test
Feature: User register
  ME AS A system user.
  I WANT to register new users.
  TO MAKE it possible to store and manage your data

  Background: enter the registration platform
    Given I enter the system

  @Register_user_with_all_empty_fields
  Scenario Outline: Register with all fields empty
    When I register without filling in the mandatory fields
    Then I should see that message "<expectedResult>"

    Examples:
      | expectedResult                |
      | O campo Nome é obrigatório.   |
      | O campo E-mail é obrigatório. |
      | O campo Senha é obrigatório.  |

  @Register_user_with_an_error_field
  Scenario Outline: Register user with an error field
    When I register with an error field "<userType>"
    Then I should see that message "<expectedResult>"

    Examples:
      | userType        | expectedResult                             |
      | OnlyFirstName   | Por favor, insira um nome completo.        |
      | invalidEmail    | Por favor, insira um e-mail válido.        |
      | invalidPassword | A senha deve conter ao menos 8 caracteres. |

  @register_user_successful
  Scenario Outline: register user successful
    When I register a user successfully by "<userType>"
    Then I should see that "<userType>" registered

    Examples:
      | userType          |
      | userSuccessfulI   |
      | userSuccessfulII  |
      | userSuccessfulIII |

  @register_multiple_users_successfully
  Scenario Outline: register multiple users successful
    When I register a user successfully by "<userTypeI>"
    And I register a user successfully by "<userTypeII>"
    And I register a user successfully by "<userTypeIII>"
    Then I should see that "<userTypeI>" registered with order id "1"
    And  I should see that "<userTypeII>" registered with order id "2"
    And  I should see that "<userTypeIII>" registered with order id "3"

    Examples:
      | userTypeI       | userTypeII       | userTypeIII       |
      | userSuccessfulI | userSuccessfulII | userSuccessfulIII |

  @Delete_user_successfully
  Scenario Outline: Delete user successful
    When I register a user successfully by "<userTypeI>"
    And I register a user successfully by "<userTypeII>"
    And I register a user successfully by "<userTypeIII>"
    And I delete the user "<userTypeII>"
    Then I should see that "<userTypeII>" deleted
    And  I should see that "<userTypeI>" registered with order id "1"
    And  I should see that "<userTypeIII>" registered with order id "3"

    Examples:
      | userTypeI       | userTypeII       | userTypeIII       |
      | userSuccessfulI | userSuccessfulII | userSuccessfulIII |










