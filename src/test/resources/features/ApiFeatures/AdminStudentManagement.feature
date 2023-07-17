@api
Feature:  Aday öğrenciler sisteme kayıt olabilmelidir. API
  Scenario Outline: US25_StudentManagement
    Given ADMİN student icin post request yap "<advisorTeacherId>", "<birthDay>", "<birthPlace>", "<email>", "<fatherName>", "<gender>", "<motherName>","<name>","<surname>","<phoneNumber>","<ssn>","<username>","<password>"
    Then ADMİN body i dogrula
    Examples:
      | advisorTeacherId | birthDay | birthPlace | email | fatherName | gender | motherName | name | surname | phoneNumber | ssn | username | password |
      | advisorTeacherId | birthDay | birthPlace | email | fatherName | gender | motherName | name | surname | phoneNumber | ssn | username | password |

 # Scenario: US15_StudentManagement
  #  Given ADMİN send get request to url by id_
   # Then ADMİN Validate response body_

  #Scenario: US15_StudentManagement
   # Given ADMİN send DEL request to url by id_
    #Then ADMİN Validate DEL response body_