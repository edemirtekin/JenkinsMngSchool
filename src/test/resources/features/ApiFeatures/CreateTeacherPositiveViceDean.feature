@api
Feature: US13_TC01 vice dean ogretmen olusturabilmelidir.
  Scenario: kullanici  ogretmen olusturur
    Given kullanici api icin base url olusturur
    And kullanici expected data yi olusturur
    And kullanici vice dean ile post request yaparak bir ogretmen olusturur
    And kullanici dogrulama yapar