package stepdefinitions.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CommonPojo;
import pojos.CommonResponsePojo;
import pojos.DeanCreateVicedeanPojo;
import pojos.ExpectedDeanCreateVicedeanPojo;
import utilities.ObjectMapperUtils;

import static baseUrl.ManagementonSchoolsBaseUrl.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AdminCreateViceDeanStep {
    Response response;

    DeanCreateVicedeanPojo expectedData;
    CommonPojo expectedData1;


    CommonResponsePojo actualData;



    @Given("kullanici admin olarak baseUrl olusturur")
    public void kullanici_admin_olarak_base_url_olusturur() {
        specAdmin.pathParams("first","vicedean","second","save");
    }


    @Then("kullanici admin olarak expected data yi olusturur {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullanici_admin_olarak_expected_data_yi_olusturur(String userId, String birthDay, String birthPlace, String gender, String name, String password, String phoneNumber, String ssn, String surname, String username) {
        expectedData = new DeanCreateVicedeanPojo(userId, birthDay,birthPlace,gender,name,password,phoneNumber,ssn,surname,username);
        System.out.println("expectedData = " + expectedData);
    }
    @And("kullanici post request yaparak vicedean olusturur")
    public void kullaniciPostRequestYaparakVicedeanOlusturur() {
        response=given(specAdmin).body(expectedData).post("/{first}/{second}", "vicedean", "save");
        response.prettyPrint();
    }
    @Then("kullanici admin olarak olusturdugu datayi dogrular")
    public void kullanici_admin_olarak_olusturdugu_datayi_dogrular() throws JsonProcessingException {
        CommonResponsePojo actualData = null;

        //actualData=response.as(CommonResponsePojo.class);


        actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CommonResponsePojo.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        Assert.assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        Assert.assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        Assert.assertEquals(expectedData.getName(), actualData.getObject().getName());
        Assert.assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        Assert.assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        Assert.assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        Assert.assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
    }

    @Given("kullanici vice deani olustururur")
    public void kullaniciViceDeaniOlustururur() {
        //Set the url
        //https://managementonschools.com/app/vicedean/getAll    --> Buraya gidilir
        specAdmin.pathParams("first","vicedean","second","getAll");

        //Send the reguest and get the response
        response = given(specAdmin)
                .get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("kullanici vice deani dogrular {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void kullaniciViceDeaniDogrular(String name, String surname, String birthplace, String phoneNumber, String gender, String birthDay, String ssn, String username) {


        JsonPath jsonPath = response.jsonPath();
        System.out.println("jsonPath = " + jsonPath);


        Object actualName = jsonPath.getList("findAll{it.username=='"+username+"'}.name").get(0);
        Object actualSurname = jsonPath.getList("findAll{it.username=='"+username+"'}.surname").get(0);
        Object actualBirthplace = jsonPath.getList("findAll{it.username=='"+username+"'}.birthPlace").get(0);
        Object actualphone = jsonPath.getList("findAll{it.username=='"+username+"'}.phoneNumber").get(0);
        Object actualgender = jsonPath.getList("findAll{it.username=='"+username+"'}.gender").get(0);
        Object actualbirthDay = jsonPath.getList("findAll{it.username=='"+username+"'}.birthDay").get(0);
        Object actualssn = jsonPath.getList("findAll{it.username=='"+username+"'}.ssn").get(0);
        Object actualusername = jsonPath.getList("findAll{it.username=='"+username+"'}.username").get(0);


        assertEquals( name,actualName);
        assertEquals(surname,actualSurname);
        assertEquals(birthplace,actualBirthplace);
        assertEquals(phoneNumber,actualphone);
        assertEquals(gender,actualgender);
        assertEquals(birthDay,actualbirthDay);
        assertEquals(ssn,actualssn);
        assertEquals(username,username);}

    @And("kullanici post request yaparak vicedeani olusturur")
    public void kullaniciPostRequestYaparakVicedeaniOlusturur() {
        response=given(specAdmin).body(expectedData).post("/{first}/{second}", "vicedean", "save");
        response.prettyPrint();
    }

    @And("kullanici eksik bilgi ile vicedean olusmadigini dogrular")
    public void kullaniciEksikBilgiIleVicedeanOlusmadiginiDogrular() {
        Assert.assertEquals(400,response.statusCode());

    }


}
