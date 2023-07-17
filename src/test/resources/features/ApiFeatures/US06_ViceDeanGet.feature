
@US06Apiyeni @api
Feature: Dean kullanici olarak Vice Dean Olusturur Apim

  Scenario Outline: US06_ViceDean
    Given kullanici vice dean olustururur
    Then kullanici vice dean dogrular "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>"

    Examples:
      | name  | surname | birthplace | phone        | gender | Date Of Birth | ssn         | username    |
      | Faruk | Kaptan  | Samsun     | 444-544-6786 | MALE   | 1980-01-01    | 665-77-6447 | dean_team55 |