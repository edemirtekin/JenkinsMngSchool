package stepdefinitions.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
//import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CommonPojo;
import pojos.CommonResponsePojo;
import pojos.ResponseCreateTeacherPojo;
import utilities.ObjectMapperUtils;

import static baseUrl.ManagementonSchoolsBaseUrl.specAdmin;

import static io.restassured.RestAssured.given;

public class AdminCreateStepDefs {
    CommonPojo expectedData;
    CommonResponsePojo actualData;
    Response response;
    JsonPath jason;


    @Given("kullanici api icin base url olusturur.")
    public void kullanici_api_icin_base_url_olusturur() {

        specAdmin.pathParams("first", "admin", "second", "save");
    }





    @Given("kullanici expected data yi olusturur.{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullanici_expected_data_yi_olusturur(String userId, String birthDay, String birthPlace, String built_in, String gender, String name, String password, String phoneNumber, String ssn, String surname, String username) {
        expectedData = new CommonPojo(userId, birthDay, birthPlace, built_in, gender, name, password, phoneNumber, ssn, surname, username);

        System.out.println("expectedData = " + expectedData);
    }



    @Given("kullanici post request yaparak bir admin olusturur")
    public void kullanici_post_request_yaparak_bir_admin_olusturur() {
        //Send the request and get the response
        response = given(specAdmin).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

    }

    @Given("kullanici admin olustugunu dogrular")
    public void kullanici_admin_olustugunu_dogrular() throws JsonProcessingException {

        CommonResponsePojo actualData = null;

       // actualData=response.as(CommonResponsePojo.class);

       actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CommonResponsePojo.class);

     //   jason =response.jsonPath();
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        Assert.assertEquals(expectedData.getName(), actualData.getObject().getName());
        Assert.assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        Assert.assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        Assert.assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        Assert.assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        Assert.assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        Assert.assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());



    }

    @And("kullanici eksik bilgi ile admin olusmadigini dogrular")
    public void kullaniciEksikBilgiIleAdminOlusmadiginiDogrular() {
        Assert.assertEquals(400,response.statusCode());

    }
}



