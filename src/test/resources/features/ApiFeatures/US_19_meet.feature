@api
Feature:Meet Olusturma

  Scenario Outline:Meet olusturuldugu test edilir
    Given kullanici meet icin base url olusturur
    Then kullanici "<id>","<date>","<description>","<start_time>","<stop_time>" bilgileri ile expected datayi olusturur
    And kullanici post request yaparak bir meet olusturur
    And kullanici meet bilgilerini dogrulama yapar
    Examples:
      | id | date        | description | start_time | stop_time |
      | 10 | 22 Ara 2023 | devamsizlik | 11.00      | 13.00     |
