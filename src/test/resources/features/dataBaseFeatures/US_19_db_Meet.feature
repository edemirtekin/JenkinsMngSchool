@US_19_db
Feature:Meet Olusturma

  Scenario Outline:Meet olusturuldugu test edilir
    Given "<id>" ile meet olustur
    Then body  "<id>","<date>","<description>","<start_time>","<stop_time>","<advisor_teacher_id>"bilgilerini icermeli
    Examples:
      | id | date        | description | start_time | stop_time | advisor_teacher_id |
      | 13 | 22 Ara 2023 | devamsizlik | 11.00      | 13.00     | 6                  |






