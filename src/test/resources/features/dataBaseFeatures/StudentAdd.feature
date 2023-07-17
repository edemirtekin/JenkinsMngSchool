@db
@US17DB
Feature: Teacher ogrencilere not verebilmelidir
  Background: Baglantı Saglanir

  Scenario Outline: Teacher ogrencilere verdigi notlari gorur
    And Teacher ogrencinin "<id>" cagirir
    And Teacher ogrencinin "<id>", "<Lesson_lesson_id>","<Absentee>","<Midterm_Exam>","<Final_Exam>" ve "<Info_Note>" gorur
    Examples:
      | id | Lesson_lesson_id | Absentee | Midterm_Exam | Final_Exam | Info_Note          |
      | 334|    80            |  16      |     82       |  85        | Tebrik ederim      |
      | 310|    3             |  10      |     50       |  100       | Basarili bir donem |
      | 319|    1             |  3       |     95       |   60       | student is cool    |



