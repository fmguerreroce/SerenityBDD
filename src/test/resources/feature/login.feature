Feature: Realizar el loggeo hacia la pagina

  @ESCENARIO1
  Scenario Outline: Logearse en la pagina exitosamente
    Given el usuario accede a la pagina
    When ingresa sus credenciales
      | user   | pass   |
      | <user> | <pass> |
    Then valido el texto en pantalla <mensaje>
    Examples:
      | user  | pass     | mensaje   |
      | admin | serenity | Dashboard |








