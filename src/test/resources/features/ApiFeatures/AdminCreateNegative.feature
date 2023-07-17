@api
@api1_N
Feature:US22_Admin hesabi ile admin ekleme
  Scenario Outline: Eksik bilgi ile admin eklenememelidir
    Given kullanici api icin base url olusturur.
    And kullanici expected data yi olusturur."<userId>","<birthDay>","<birthPlace>","<built_in>","<gender>","<name>","<password>","<phoneNumber>","<ssn>","<surname>","<username>"
    And kullanici post request yaparak bir admin olusturur
    And kullanici eksik bilgi ile admin olusmadigini dogrular
    Examples:
      | userId | birthDay   | birthPlace | built_in | gender | name | password | phoneNumber  | ssn         | surname | username    |
      |        |            | Edirne     | true     | MALE   | Taha | 24681234 | 852-657-9246 | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 |            | true     | MALE   | Taha | 24681234 | 852-657-9246 | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     |          | MALE   | Taha | 24681234 | 852-657-9246 | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     |        | Taha | 24681234 | 852-657-9246 | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   |      | 24681234 | 852-657-9246 | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha |          | 852-657-9246 | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha | 24681234 |              | 657-81-2876 | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha | 24681234 | 852-657-9246 |             | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha | 24681234 | 852-657-9246 | 657812876   | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha | 24681234 | 852-657-9246 | 657-81-     | Taha1   | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha | 24681234 | 852-657-9246 | 657-81-2876 |         | TarikTaha11 |
      |        | 1976-05-05 | Edirne     | true     | MALE   | Taha | 24681234 | 852-657-9246 | 657-81-2876 | Taha1   |             |
