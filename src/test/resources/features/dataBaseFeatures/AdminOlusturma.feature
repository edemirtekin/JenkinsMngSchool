@db
@US22_db_adminValidate
Feature:Admin Ekleme

  Scenario Outline: Admin_Eklendigi_Test_Edilir
    Given "<username>" ile admini cagir
    Then body  "<birthDay>","<birthPlace>","<gender>","<name>","<phoneNumber>","<ssn>","<surname>","<username>" bilgilerini icermeli
    Examples:
      | birthDay   | birthPlace | gender | name   | phoneNumber  | ssn         | surname | username  |  |  |
      | 1985-04-20 | Istanbul   | 0      | YusufT | 385-357-8753 | 751-85-9871 | AslanT  | ttyusuf18 |  |  |







