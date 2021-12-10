Feature: Homologar seccion empleos en ingles de ChoucairTesting

  Scenario: CP001 Cambiar banner
    Given visitar la seccion empleos de ChoucairTesting en version ingles
    When buscar la imagen del banner
    Then verificar el banner

  Scenario: CP003 insertar boton portal Magneto
    Given visitar la seccion empleos de ChoucairTesting en version ingles
    When insertar el boton del portal de empleos Magneto
    Then verificar ejecucion de popup y direccionamiento