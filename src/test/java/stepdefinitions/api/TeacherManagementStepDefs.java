package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateTeacherPojo;
import pojos.ResponseCreateTeacherPojo;

import java.util.ArrayList;
import java.util.List;

import static baseUrl.ManagementonSchoolsBaseUrl.*;
import static io.restassured.RestAssured.given;


public class TeacherManagementStepDefs {

    CreateTeacherPojo expectedDataPojo;
    Response response;
    public static String birthDay;
    public static String birthPlace;
    public static String genderCode;
    public static String name;
    public static String phoneNumber;
    public static String ssnNumber;
    public static String surName;
    public static String userName;
    public static String email;
    public static Boolean isAdvisor;

    @Given("kullanici expected data yi olusturur")
    public void kullanici_expected_data_yi_olusturur() {
        Faker faker = new Faker();
        int yil = faker.number().numberBetween(1960, 2010);
        int ay = faker.number().numberBetween(10, 12);
        int gun = faker.number().numberBetween(10, 30);
        birthDay = yil + "-" + ay + "-" + gun;
        birthPlace = faker.address().city();
        String[] cins = {"MALE", "FEMALE"};
        int randomGender = (int) (Math.random() * 2);
        String gender = cins[randomGender];

        if (gender.equals("MALE")) {
            genderCode = "0";
        } else {
            genderCode = "1";
        }
        name = Faker.instance().name().firstName();
        surName = Faker.instance().name().lastName();
        phoneNumber = faker.numerify("###-###-####");
        List<String> lessonList = new ArrayList<>(); // öğretmenin gireceği dersi seçmek için
        lessonList.add("5");

        email = Faker.instance().internet().emailAddress();
        ssnNumber = faker.numerify("###-##-####");
        userName = Faker.instance().name().username();

        Boolean[] adv = {true, false};
        int randomAdv = (int) (Math.random() * 2);
        isAdvisor = adv[randomAdv];

        expectedDataPojo = new CreateTeacherPojo(birthDay,
                birthPlace,
                email,
                gender,
                isAdvisor,
                lessonList,
                name,
                "87654321",
                phoneNumber,
                ssnNumber,
                surName,
                userName);
    }

    @Given("kullanici dogrulama yapar")
    public void kullanici_dogrulama_yapar() {

        ResponseCreateTeacherPojo actualData = null;
        try {
            actualData = response.as(ResponseCreateTeacherPojo.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedDataPojo.getBirthDay(), actualData.getObject().getBirthDay());
        Assert.assertEquals(expectedDataPojo.getBirthPlace(), actualData.getObject().getBirthPlace());
        Assert.assertEquals(expectedDataPojo.getEmail(), actualData.getObject().getEmail());
        Assert.assertEquals(expectedDataPojo.getGender(), actualData.getObject().getGender());
        Assert.assertEquals(expectedDataPojo.getName(), actualData.getObject().getName());
        Assert.assertEquals(expectedDataPojo.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        Assert.assertEquals(expectedDataPojo.getSsn(), actualData.getObject().getSsn());
        Assert.assertEquals(expectedDataPojo.getSurname(), actualData.getObject().getSurname());
        Assert.assertEquals(expectedDataPojo.getUsername(), actualData.getObject().getUsername());

    }

    @And("kullanici ogretmenin olusmadigini dogrulama yapar")
    public void kullaniciOgretmeninOlusmadiginiDogrulamaYapar() {
        Assert.assertEquals(400, response.statusCode());
    }

    @Given("kullanici api icin base url olusturur")
    public void kullaniciApiIcinBaseUrlOlusturur() {
        specViceDean.pathParams("first", "teachers", "second", "save");
        specAdmin.pathParams("first", "teachers", "second", "save");
    }

    @And("kullanici name surname username bilgilerini sembol olarak girerek expected data yi olusturur")
    public void kullaniciNameSurnameUsernameBilgileriniSembolOlarakGirerekExpectedDataYiOlusturur() {
        Faker faker = new Faker();
        int yil = faker.number().numberBetween(1960, 2010);
        int ay = faker.number().numberBetween(10, 12);
        int gun = faker.number().numberBetween(10, 30);
        birthDay = yil + "-" + ay + "-" + gun;
        birthPlace = faker.address().city();
        String[] cins = {"MALE", "FEMALE"};
        int randomGender = (int) (Math.random() * 2);
        String gender = cins[randomGender];

        if (gender.equals("MALE")) {
            genderCode = "0";
        } else {
            genderCode = "1";
        }
        name = "12/*-?()&%";
        surName = "!^+%&//**";
        phoneNumber = faker.numerify("###-###-####");
        List<String> lessonList = new ArrayList<>(); // öğretmenin gireceği dersi seçmek için
        lessonList.add("5");

        email = Faker.instance().internet().emailAddress();
        ssnNumber = faker.numerify("###-##-####");
        userName = Faker.instance().number().numberBetween(1, 1000) + "%&/^/***";

        Boolean[] adv = {true, false};
        int randomAdv = (int) (Math.random() * 2);
        isAdvisor = adv[randomAdv];

        expectedDataPojo = new CreateTeacherPojo(birthDay,
                birthPlace,
                email,
                gender,
                isAdvisor,
                lessonList,
                name,
                "87654321",
                phoneNumber,
                ssnNumber,
                surName,
                userName);
    }

    @And("kullanici {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} bilgileri ile expected data yi olusturur")
    public void kullaniciBilgileriIleExpectedDataYiOlusturur(String lesson, String name, String surname, String birthPlace, String email, String phoneNumber, String gender, String birthDay, String ssnNumber, String userName, String password) {

        List<String> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        isAdvisor = true;

        expectedDataPojo = new CreateTeacherPojo(birthDay,
                birthPlace,
                email,
                gender,
                isAdvisor,
                lessonList,
                name,
                password,
                phoneNumber,
                ssnNumber,
                surname,
                userName);
    }

    @Given("kullanici put islemi ile {string} li ogretmen icin base url olusturur")
    public void kullaniciPutIslemiIleLiOgretmenIcinBaseUrlOlusturur(String id) {
        specViceDean.pathParams("first", "teachers", "second", "update", "third", id);
        specAdmin.pathParams("first", "teachers", "second", "update", "third", id);
    }

    @And("kullanici {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} bilgileri ile expected datayi olusturur")
    public void kullaniciBilgileriIleExpectedDatayiOlusturur(String birthday, String birthPlace, String email, String gender, String name, String password, String phonenumber, String ssn, String surname, String username) {
        List<String> lessonList = new ArrayList<>();
        lessonList.add("5");

        expectedDataPojo = new CreateTeacherPojo(
                birthday,
                birthPlace,
                email,
                gender,
                false,
                lessonList,
                name,
                password,
                phonenumber,
                ssn,
                surname,
                username);
    }

    @And("kullanici admin ile post request yaparak bir ogretmen olusturur")
    public void kullaniciAdminIlePostRequestYaparakBirOgretmenOlusturur() {
        response = given(specAdmin).body(expectedDataPojo).post("{first}/{second}");
        response.prettyPrint();
    }

    @And("kullanici vice dean ile post request yaparak bir ogretmen olusturur")
    public void kullaniciViceDeanIlePostRequestYaparakBirOgretmenOlusturur() {
        response = given(specViceDean).body(expectedDataPojo).post("{first}/{second}");
        response.prettyPrint();
        //response.peek(); -->ARAŞTIR
    }

    @And("kullanici admin ile put request ile ogretmeni gunceller")
    public void kullaniciAdminIlePutRequestIleOgretmeniGunceller() {
        response = given(specAdmin).body(expectedDataPojo).put("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @And("kullanici vice dean ile put request ile ogretmeni gunceller")
    public void kullaniciViceDeanIlePutRequestIleOgretmeniGunceller() {
        response = given(specViceDean).body(expectedDataPojo).put("{first}/{second}/{third}");
        response.prettyPrint();
    }
}

