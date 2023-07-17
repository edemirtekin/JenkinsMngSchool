package stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CreateMeetPojo;
import pojos.OuterResponseMeetPojo;

import java.util.ArrayList;
import java.util.List;

import static baseUrl.ManagementonSchoolsBaseUrl.specTeacher;
import static io.restassured.RestAssured.given;

public class US19_Meet {

    CreateMeetPojo expectedDataMeetPojo;
    Response response;


    @Given("kullanici meet icin base url olusturur")
    public void kullaniciMeetIcinBaseUrlOlusturur() {
        specTeacher.pathParams("first", "meet", "second", "save");
    }

    @Then("kullanici {string},{string},{string},{string},{string} bilgileri ile expected datayi olusturur")
    public void kullaniciBilgileriIleExpectedDatayiOlusturur(String id, String date, String description, String startTime, String stopTime) {
        List<String> studentIdList = new ArrayList<>();
        studentIdList.add(id);
        expectedDataMeetPojo = new CreateMeetPojo(date, description, startTime, stopTime, studentIdList);
        System.out.println(expectedDataMeetPojo);
    }

    @And("kullanici post request yaparak bir meet olusturur")
    public void kullaniciPostRequestYaparakBirMeetOlusturur() {
        response = given(specTeacher).body(expectedDataMeetPojo).post("{first}/{second}");
        response.prettyPrint();
    }

    @And("kullanici meet bilgilerini dogrulama yapar")
    public void kullaniciMeetBilgileriniDogrulamaYapar() {

        OuterResponseMeetPojo actualData = response.as(OuterResponseMeetPojo.class);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedDataMeetPojo.getDate(), actualData.getObject().getDate());
        Assert.assertEquals(expectedDataMeetPojo.getDescription(), actualData.getObject().getDescription());
        Assert.assertEquals(expectedDataMeetPojo.getStartTime(), actualData.getObject().getStartTime());
        Assert.assertEquals(expectedDataMeetPojo.getStopTime(), actualData.getObject().getStopTime());
    }

}

