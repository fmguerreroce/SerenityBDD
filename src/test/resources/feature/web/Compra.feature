Feature: Realizar una compra
  Como usuario de la pagina web
  Quiero marcar productos
  Para realizar una compra

  Background:
    Given el usuario navega a la página de login

  @ESC01_COMPRAA
  Scenario Outline: Validar que se realice una compra de manera exitosa
    When ingresa el username
      | username   | password   |
      | <username> | <password> |
    Then debería ver "<resultado>"
    And agredo los productos a la cesta
      | producto1   | producto2   | producto3   |
      | <producto1> | <producto2> | <producto3> |
    And le doy click en el icono de carrito
    And le doy click en el boton checkout
    And lleno el formulario con los datos
      | firstName   | lastName   | postalCode   |
      | <firstName> | <lastName> | <postalCode> |
    And le doy click en el boton continue
    And valido que se muestre el resumen del "<precioTotal>"
    And doy click en el boton finalizar
    And Valido el mensaje exitoso "<Mensaje>"

    Examples:
      | username      | password     | resultado | producto1           | producto2             | producto3         | firstName | lastName | postalCode | precioTotal | Mensaje                    |
      | standard_user | secret_sauce | Products  | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Onesie | Flor      | Guerrero | 123456     | Price Total | Thank you for your order!  |

