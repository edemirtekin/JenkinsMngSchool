@api
@api2
Feature: Lesson Post and Lesson Get
  Scenario Outline: : ViceDean_create_Lesson

    Given kullanici ViceDean olarak baseUrl olusturur
    Then kullanici ViceDean olarak expected data yi olusturur "<lessonId>","<compulsory>","<creditScore>","<lessonName>"
    And kullanici post request yaparak lesson olusturur
    And kullanici ViceDean olarak olusturdugu datayi dogrular
    Examples:
      | lessonId | compulsory | creditScore | lessonName |
      |          | true       | 18          | SQL333      |


  @api
  @api2_Get
  Scenario Outline:ViceDean_olarak_lesson_cagirma
    Given kullanici ViceDean olarak get icin baseUrl olusturur
    Then kullanici ViceDean olarak expected data yi olusturur "<lessonId>","<compulsory>","<creditScore>","<lessonName>"
    And kullanici get request yaparak lesson cagirir
    And kullanici ViceDean olarak cagirdigi datayi dogrular
    Examples:
      | lessonId | compulsory | creditScore | lessonName |
      | 1869      | true       | 18          | SQL333     |


