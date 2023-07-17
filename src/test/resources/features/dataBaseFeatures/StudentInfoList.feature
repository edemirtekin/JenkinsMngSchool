@db
@US18DB
Feature:Student cagirma

  Scenario Outline:Student eklendigi test edilir
    Given "<student_id>" ile student cagir
    Then body  "<id>","<Absentee>","<exam_average>","<final_exam>","<info_note>","<letter_grade>","<midterm_exam>","<lesson_lesson_id>","<student_id>" bilgilerini icermeli


    Examples:
      | id         | Absentee | exam_average      | final_exam   | info_note           | letter_grade   | midterm_exam  | lesson_lesson_id | student_id   |
      |  148       | 6       |    83.6            | 96           |  sdasdasdasd        |   BA           |      65       |       2          |      38      |


