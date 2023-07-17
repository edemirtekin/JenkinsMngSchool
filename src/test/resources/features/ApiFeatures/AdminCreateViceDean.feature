@api
@US23Get
Feature: Admin kullanici olarak Vice Dean Olusturur


  Scenario Outline: US23_ViceDean
    Given kullanici vice deani olustururur
    Then kullanici vice deani dogrular "<name>", "<surname>", "<birthplace>", "<phoneNumber>", "<gender>", "<Date Of Birth>", "<ssn>","<username>"

    Examples:
      | name  | surname | birthplace | phoneNumber  | gender | Date Of Birth | ssn         | username    |
      | Faruk | Kaptan  | Samsun     | 444-544-6786 | MALE   | 1980-01-01    | 665-77-6447 | dean_team55 |


  @US23Post
  Scenario Outline: : US23_Admin_Create_ViceDean

    Given kullanici admin olarak baseUrl olusturur
    Then kullanici admin olarak expected data yi olusturur "<userId>","<birthDay>","<birthPlace>","<gender>","<name>","<password>","<phoneNumber>","<ssn>","<surname>","<username>"
    And kullanici post request yaparak vicedean olusturur
    And kullanici admin olarak olusturdugu datayi dogrular
    Examples:
      | userId | birthDay   | birthPlace | gender | name  | password | phoneNumber  | ssn         | surname | username |
      |        | 1980-01-01 | Ankara     | MALE   | Salih | 14725839 | 245-358-6887 | 745-96-4997 | Han     | Farukhan3 |


  @US23Negative
  Scenario Outline: Eksik bilgi ile vicedean eklenememelidir
    Given kullanici admin olarak baseUrl olusturur
    Then kullanici admin olarak expected data yi olusturur "<userId>","<birthDay>","<birthPlace>","<gender>","<name>","<password>","<phoneNumber>","<ssn>","<surname>","<username>"
    And kullanici post request yaparak vicedeani olusturur
    And kullanici eksik bilgi ile vicedean olusmadigini dogrular
    Examples:
      | userId | birthDay   | birthPlace | gender | name  | password | phoneNumber  | ssn         | surname | username  |
      |        |            | Ankara     | MALE   | Faruk | 14725836 | 245-358-6857 | 745-96-4547 | Han     | Salihhan2 |
      |        | 1980-01-01 |            | MALE   | Faruk | 14725836 | 245-358-6857 | 745-96-4547 | Han     | Salihhan2 |
      |        | 1980-01-01 | Ankara     |        | Faruk | 14725836 | 245-358-6857 | 745-96-4547 | Han     | Salihhan2 |
      |        | 1980-01-01 | Ankara     | MALE   |       | 14725836 | 245-358-6857 | 745-96-4547 | Han     | Salihhan2 |
      |        | 1980-01-01 | Ankara     | MALE   | Faruk |          | 245-358-6857 | 745-96-4547 | Han     | Salihhan2 |
      |        | 1980-01-01 | Ankara     | MALE   | Faruk | 14725836 |              | 745-96-4547 | Han     | Salihhan2 |
      |        | 1980-01-01 | Ankara     | MALE   | Faruk | 14725836 | 245-358-6857 |             | Han     | Salihhan2 |
      |        | 1980-01-01 | Ankara     | MALE   | Faruk | 14725836 | 245-358-6857 | 745-96-4547 |         | Salihhan2 |
      |        | 1980-01-01 | Ankara     | MALE   | Faruk | 14725836 | 245-358-6857 | 745-96-4547 | Han     |           |

