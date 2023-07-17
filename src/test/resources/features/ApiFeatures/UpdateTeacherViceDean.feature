@api
Feature: US14-TC03 vice dean ogretmen bilgilerini guncelleyebilmeli
  Scenario: api ile ogretmen bilgileri guncellenir
    Given kullanici put islemi ile "819" li ogretmen icin base url olusturur
    And kullanici "1975-11-02","adana","aliada@gmail.com","MALE","aliveli","ali12356","192-148-8671","128-23-1245","alibey","ali9834" bilgileri ile expected datayi olusturur
    And kullanici vice dean ile put request ile ogretmeni gunceller
    Then kullanici dogrulama yapar