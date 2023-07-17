
@api

@US17API

Feature:US17 Add Student Ekleme

  Scenario Outline: Teacher Student ekleyebilmeli
    Given kullanici base url olusturur..

    And kullanici expected data yi olusturur."<id>","<absentee>","<educationTermId>","<finalExam>","<infoNote>","<lessonId>","<midtermExam>","<studentId>"
    And kullanici post request yaparak bir student info olusturur
    And kullanici student info olustugunu dogrular

    Examples:

      | id | absentee | educationTermId | finalExam | infoNote             | lessonId | midtermExam | studentId |
      |    | 12       | 18              | 12.0      | 12wwsdskkk jjjanmmas | 428      | 9.0         | 96        |

     









