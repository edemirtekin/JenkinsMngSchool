@db @smoke
Feature: US13 TC01 vice dean ile ogretmen olustur

  Scenario Outline: varolan bir ögretmenin databese deki bilgileri test edilir
    Given "<username>" ile ogretmeni cagir
    Then body sunlari icermeli: "<birth_day>", "<birth_place>", "<gender>", "<name>", "<phone_number>", "<ssn>", "<surname>","<username>","<email>","<is_advisor>"
    Examples:
      | username         | birth_day  | birth_place | gender | name     | phone_number | ssn         | surname | email                           | is_advisor |
      | richard.volkman  | 1986-10-12 | Venez       | 0      | Enda     | 620-057-6755 | 171-19-7463 | Nader   | michelle.walker@hotmail.com     | false      |
      | amparo.wilderman | 1978-01-08 | New Ronald  | 1      | Maisha   | 523-446-6572 | 264-22-2326 | Sanford | albert.leuschke@yahoo.com       | true       |
      | loan.feil        | 1984-06-22 | Carrollside | 0      | Ahmad    | 883-935-4045 | 350-20-9168 | Quitzon | ollie.conroy@hotmail.com        | true       |
      | augustine.haley  | 1988-10-12 | Zambi       | 0      | Gilberto | 874-646-0667 | 842-08-1031 | Dicki   | roosevelt.jaskolski@hotmail.com | false      |
