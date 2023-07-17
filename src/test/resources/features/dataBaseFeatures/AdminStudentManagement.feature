@db
Feature: Aday öğrenciler sisteme kayıt olabilmelidir.

  Scenario Outline: US25_AdminStudentManagement

    Given "<username>" ile admin student cagir
    Then admin body sunlari icermeli: "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>","<password>","<fathername>","<mothername>","<teacher>"
    Examples:
      | username    | name  | surname | birthplace | phone        | gender | Date Of Birth | ssn         | password | fathername | mothername | teacher |
      | Adminbionic | cemil | cem     | ankara     | 531-432-0021 | 1      | 2000-04-23    | 391-80-6753 | 12345678 | bade       | demir      | 1       |







