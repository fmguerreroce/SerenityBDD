@LOGIN
Feature: Login en SauceDemo
  Como usuario registrado
  Quiero ingresar mi username y password
  Para poder acceder al sistema

  Background:
    Given el usuario navega a la página de login

  @ESC01_CP_POSITIVO
  Scenario Outline: Login con diferentes credenciales
    When ingresa el username
    | username | password |
    |<username>|<password>|
    Then debería visualizar la página "<resultado>"
    Examples:
      | username        | password      | resultado                         |
      | standard_user   | secret_sauce  | Products                          |

  @ESC02_CP_NEGATIVO
  Scenario Outline: Validar que se muestre un mensaje de error
    When ingresa sus credenciales invalidas
      | username   | password   |
      | <username> | <password> |
    Then debería visualizar el mensaje de error "<Mensaje>"
    Examples:
      | username      | password | Mensaje                                                                   |
      | standard_user | 1234     | Epic sadface: Username and password do not match any user in this service |



