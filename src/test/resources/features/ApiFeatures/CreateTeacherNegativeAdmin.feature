@api
Feature: US24_TC02 vice dean ogretmen olusturabilmelidir(negative).

  Scenario Outline: bazi bilgiler eksik girilmesi durumunda teacher olusmamalidir
    Given kullanici api icin base url olusturur
    And kullanici "<lesson>","<name>","<surname>","<birth place>","<email>","<phone>","<gender>","<birthDay>","<SSN>","<username>","<password>" bilgileri ile expected data yi olusturur
    And kullanici admin ile post request yaparak bir ogretmen olusturur
    Then kullanici ogretmenin olusmadigini dogrulama yapar
    Examples:
      | lesson | name    | surname | birth place | email             | phone        | gender | birthDay   | SSN         | username | password |
      |        | ali     | veli    | newyork     | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      |         | veli    | newyork     | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     |         | newyork     | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     | veli    |             | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     | veli    | newyork     |                   | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     | veli    | newyork     | email93@gmail.com |              | 0      | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     | veli    | newyork     | email93@gmail.com | 165-252-8365 |        | 1978-10-12 | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     | veli    | newyork     | email93@gmail.com | 165-252-8365 | 0      |            | 194-90-3498 | ali67    | ali12345 |
      | 2      | ali     | veli    | newyork     | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 |             | ali67    | ali12345 |
      | 2      | ali     | veli    | newyork     | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 |          | ali12345 |
      | 2      | ali     | veli    | newyork     | email93@gmail.com | 165-252-8365 | 0      | 1978-10-12 | 194-90-3498 | ali67    |          |
