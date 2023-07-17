
@api @US18GET

Feature: Teacher Student bilgilerini alabilmeli

  Scenario Outline: US18 Student info list
    Given kullanici get Student list base url olusturur..
    And kullanici student info'yu olusturur "<lessonName>","<absentee>","<midtermExam>","<finalExam>","<infoNote>"
    Then kullanici student info'yu alir ve dogrular1
    Examples:
      | lessonName | absentee | midtermExam | finalExam | infoNote             |
      | Flexidy    | 12       | 9.0         | 12.0      | 12wwsdskkk jjjanmmas |



