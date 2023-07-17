Feature: Vice Dean ders programi olusturma

  Scenario Outline: Ders programi ekledigi test edilir
    Given "<id>" ile ders programini cagir
    Then body  "<id>","<day>","<start_time>","<stop_time>","<education_term_id>" bilgilerini icermeli
    Examples:
      | id | day    | start_time | stop_time | education_term_id |
      | 5  | FRIDAY | 10:00:00   | 12:00:00  | 1                 |
