@db
@US06DB
Feature:Admin Ekleme

  Scenario Outline: Admin_Eklendigi_Test_Edilir
    Given "<username>" ile admini cagirma
    Then vicedean body  "<birthDay>","<birthPlace>","<gender>","<name>","<phoneNumber>","<ssn>","<surname>","<username>" bilgilerini icermeli
    Examples:
      |  | birthDay   | birthPlace | gender | name  | phoneNumber  | ssn         | surname | username  |
      |  | 1980-01-01 | Ankara     | 0      | Salih | 245-358-6987 | 745-96-8547 | Hak     | Salihhak1 |






