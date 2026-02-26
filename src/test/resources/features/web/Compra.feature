@COMPRAS
Feature: Realizar una compra
  Como usuario de la pagina web
  Quiero marcar productos
  Para realizar una compra

  Background:
    Given el usuario navega a la página de login
    When ingresa sus credenciales válidas
    Then debería visualizar la página "Products"

  @ESC01_COMPRA
  Scenario Outline: Validar que se realice una compra de manera exitosaa
    When agrega los siguientes productos a la cesta
      | producto1   | producto2   | producto3   |
      | <producto1> | <producto2> | <producto3> |
    And accede al carrito de compras
    And inicia el proceso de checkout
    And completa el formulario con los datos
      | firstName   | lastName   | postalCode   |
      | <firstName> | <lastName> | <postalCode> |
    And continúa con la compra
    Then debería visualizar el resumen con el total "<precioTotal>"
    When finaliza la compra
    Then debería visualizar el mensaje exitoso "<Mensaje>"

    Examples:
      | producto1           | producto2             | producto3         | firstName | lastName | postalCode | precioTotal | Mensaje                   |
      | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Onesie | Flor      | Guerrero | 123456     | Price Total | Thank you for your order! |


  @ORDEN_PRECIO_ASC
  Scenario Outline: Ordenar productos por precio ascendente
    When When selecciona el filtro "<Precio: menor a mayor>"
    Then los productos se muestran ordenados por precio de forma ascendente
    Examples:
      | Precio: menor a mayor |
      | Price (low to high)   |





