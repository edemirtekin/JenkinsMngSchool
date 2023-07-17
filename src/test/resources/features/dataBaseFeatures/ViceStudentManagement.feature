@db
Feature: Aday öğrenciler sisteme kayıt olabilmelidir.

  Scenario Outline: US15_ViceStudentManagement

    Given "<username>" ile student cagirma
    Then body sunlari icermeli: "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>","<password>","<fathername>","<mothername>","<teacher>"
    Examples:
      | username | name  | surname | birthplace | phone        | gender | Date Of Birth | ssn         | password | fathername | mothername | teacher |
      | bionic   | cemil | cem     | ankara     | 532-321-0023 | 1      | 2000-04-23    | 392-81-6745 | 12345678 | bade      | demir       | 1       |




    #Loop deneme senaryosu
 # @LoopDB
  #Scenario:
   # Given birthplace "batch129" ile guest useri cagir
    #Then kac tane user oldugunu bul


  #@DBNegative
  #Scenario: Silinen guest useri dogrula
   # Given silinen "alican129" ile guest useri cagir
    #Then tablein bos oldugunu dogrula



