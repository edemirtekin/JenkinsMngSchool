@zz
Feature:Meet Guncelleme

  Scenario Outline:Meet guncellendigi test edilir
    Given "<meet_id>" ile meet secilir
    Then body  "<id>","<student_id>" bilgilerini icermeli
    Examples:
      | meet_id | student_id |
      | 24      | 5          |
