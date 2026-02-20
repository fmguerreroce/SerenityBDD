Feature: Login en SauceDemo
  Como usuario registrado
  Quiero ingresar mi username y password
  Para poder acceder al sistema

  @ESC01
  Scenario Outline: Login con diferentes credenciales
    Given el usuario navega a la página de login
    When ingresa el username
    | username | password |
    |<username>|<password>|
    Then debería ver "<resultado>"
    Examples:
      | username        | password      | resultado                         |
      | standard_user   | secret_sauce  | Products                          |
#      | locked_out_user | secret_sauce  | mensaje de usuario bloqueado      |
#      | standard_user   | wrong_pass    | mensaje de credenciales inválidas |


