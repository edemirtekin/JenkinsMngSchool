@api
@US06Apiyeni
Feature: Dean kullanici olarak Vice Dean Olusturur Apim

  Scenario Outline: US06_ViceDean
    Given kullanici vice dean olustururur
    Then kullanici vice dean dogrular "<name>", "<surname>", "<birthplace>", "<phoneNumber>", "<gender>", "<Date Of Birth>", "<ssn>","<username>"

    Examples:
      | name  | surname | birthplace | phoneNumber  | gender | Date Of Birth | ssn         | username    |
      | Faruk | Kaptan  | Samsun     | 444-544-6786 | MALE   | 1980-01-01    | 665-77-6447 | dean_team55 |

  Scenario Outline: : ViceDean_create_Dean

    Given kullanici Dean olarak baseUrl olusturur
    Then kullanici Dean olarak expected data yi olusturur "<userId>","<birthDay>","<birthPlace>","<gender>","<name>","<password>","<phoneNumber>","<ssn>","<surname>","<username>"
    And kullanici post request yaparak vicedeanolusturur
    And kullanici Dean olarak olusturdugu datayi dogrular
    Examples:
      | userId | birthDay   | birthPlace | gender | name  | password | phoneNumber  | ssn         | surname | username  |
      |        | 1980-01-01 | Ankara     | MALE   | Salih | 14725836 | 245-358-6987 | 745-96-8547 | Hak     | Salihhak1 |

