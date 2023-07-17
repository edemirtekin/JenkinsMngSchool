package stepdefinitions.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;
import utilities.ObjectMapperUtils;

import static baseUrl.ManagementonSchoolsBaseUrl.specDean;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeanCreateViceDeanGetStep {

    Response response;

    DeanCreateVicedeanPojo expectedData;

    CommonResponsePojo actualData;

    @Given("kullanici vice dean olustururur")
    public void kullanici_vice_dean_olustururur() {
        //Set the url
        //https://managementonschools.com/app/vicedean/getAll    --> Buraya gidilir
        specDean.pathParams("first","vicedean","second","getAll");

        //Send the reguest and get the response
        response = given(specDean)
                .get("{first}/{second}");
        response.prettyPrint();


    }
    @Then("kullanici vice dean dogrular {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void kullanici_vice_dean_dogrular(String name, String surname, String birthplace, String phoneNumber, String gender, String birthDay, String ssn, String username) {


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
        assertEquals(username,username);
    }

    @Given("kullanici Dean olarak baseUrl olusturur")
    public void kullaniciDeanOlarakBaseUrlOlusturur() {

        specDean.pathParams("first","vicedean","second","save");

    }

    @Then("kullanici Dean olarak expected data yi olusturur {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciDeanOlarakExpectedDataYiOlusturur(String userId, String birthDay, String birthPlace, String gender, String name, String password, String phoneNumber, String ssn, String surname, String username) {
        expectedData = new DeanCreateVicedeanPojo(userId, birthDay,birthPlace,gender,name,password,phoneNumber,ssn,surname,username);

        System.out.println("expectedData = " + expectedData);
    }




    @And("kullanici post request yaparak vicedeanolusturur")
    public void kullaniciPostRequestYaparakVicedeanolusturur() {
        response=given(specDean).body(expectedData).post("/{first}/{second}", "vicedean", "save");
        response.prettyPrint();
    }

    @And("kullanici Dean olarak olusturdugu datayi dogrular")
    public void kullaniciDeanOlarakOlusturduguDatayiDogrular() throws JsonProcessingException {

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
}
