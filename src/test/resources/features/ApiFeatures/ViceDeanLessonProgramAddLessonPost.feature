@api
Feature: ViceDean Lesson Program olusturabilmelidir
  Scenario: US10_ViceDeanAddLessonProgram

    Given kullanici add lesson  program icin base url olusturur
    And kullanici add lesson program icin expected data yi olusturur
    And kullanici post request yaparak ders programi  olusturur
    And kullanici olusturdugu ders programini dogrular


  Scenario: US_11Vice Dean ders programini cagirir
    Given kullanici get lesson program icin base url olusturur
    And kullanici get icin lesson program expected datayi olusturur
    And kullanici get request yaparak ders programi  olusturur
    And kullanici cagirdigi ders programini dogrular
