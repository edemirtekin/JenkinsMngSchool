
@api
Feature: ViceDean Lesson Program  Teacher Assignment olusturabilmelidir
  Scenario: US12_ViceDeanAddLessonProgramTeacherAssignment

    Given kullanici teacher assignment  icin base url olusturur
    And kullanici teacher assignment icin expected data yi olusturur
    And kullanici post request yaparak teacher assign  yapar
    And kullanici assign yaptigini dogrular
