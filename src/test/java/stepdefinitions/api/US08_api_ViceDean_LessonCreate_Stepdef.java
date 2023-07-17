package stepdefinitions.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CommonLessonCreatePojo;
import pojos.CommonLessonResponsePojo;
import pojos.CommonResponsePojo;
import pojos.LessonGet1;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.ManagementonSchoolsBaseUrl.specViceDean;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class US08_api_ViceDean_LessonCreate_Stepdef {
    CommonLessonCreatePojo lessonExpectedData;
    CommonLessonCreatePojo lessonActualDataGet;

    CommonLessonResponsePojo lessonActualData;

    String lessonDeleteActualData;
    Response response;


    @Given("kullanici ViceDean olarak baseUrl olusturur")
    public void kullanici_vice_dean_olarak_base_url_olusturur() {

        specViceDean.pathParams("first", "lessons", "second", "save");


    }

    @Then("kullanici ViceDean olarak expected data yi olusturur {string},{string},{string},{string}")
    public void kullaniciViceDeanOlarakExpectedDataYiOlusturur(String lessonId, String compulsory, String creditScore, String lessonName) throws JsonProcessingException {
        lessonExpectedData = new CommonLessonCreatePojo(lessonId, compulsory, creditScore, lessonName);
        System.out.println("lessonExpectedData = " + lessonExpectedData);


    }

    @Then("kullanici post request yaparak lesson olusturur")
    public void kullanici_post_request_yaparak_lesson_olusturur() throws JsonProcessingException {

        response = given(specViceDean).body(lessonExpectedData).post("/{first}/{second}", "lessons", "save");
        response.prettyPrint();

        lessonActualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CommonLessonResponsePojo.class);

        System.out.println("lessonExpectedData = " + lessonExpectedData);


    }

    @Then("kullanici ViceDean olarak olusturdugu datayi dogrular")
    public void kullanici_vice_dean_olarak_olusturdugu_datayi_dogrular() {

        lessonActualData = response.as(CommonLessonResponsePojo.class);
        System.out.println("lessonActualData = " + lessonActualData);

        Assert.assertEquals(200, response.statusCode());
        assertEquals(lessonExpectedData.getLessonName(), lessonActualData.getObject().getLessonName());
        assertEquals(lessonExpectedData.getCreditScore(), lessonActualData.getObject().getCreditScore());
        assertEquals(lessonExpectedData.getCompulsory(), lessonActualData.getObject().getCompulsory());

        String message = "Lesson Created";
        String httpStatus = "OK";

        Assert.assertEquals(message, lessonActualData.getMessage());
        Assert.assertEquals(httpStatus, lessonActualData.getHttpStatus());


    }

    @Given("kullanici ViceDean olarak get icin baseUrl olusturur")
    public void kullaniciViceDeanOlarakGetIcinBaseUrlOlusturur() {
        //https://managementonschools.com/app/lessons/getLessonByName?lessonName=SQL15
        specViceDean.pathParams("first", "lessons", "second", "getLessonByName").queryParams("lessonName", "SQL333");

    }

    @And("kullanici get request yaparak lesson cagirir")
    public void kullaniciGetRequestYaparakLessonCagirir() {
        response = given(specViceDean).get("{first}/{second}");
        response.prettyPrint();

    }


    @And("kullanici ViceDean olarak cagirdigi datayi dogrular")
    public void kullaniciViceDeanOlarakCagirdigiDatayiDogrular() throws JsonProcessingException {

        lessonActualDataGet = response.as(LessonGet1.class).getObject();
        assertEquals(200, response.statusCode());
        assertEquals(lessonExpectedData.getLessonName(), lessonActualDataGet.getLessonName());
//        assertEquals(lessonExpectedData.getCreditScore(), lessonActualDataGet.getCreditScore());
//        assertEquals(lessonExpectedData.getCompulsory(), lessonActualDataGet.getCompulsory());


    }

    @Given("kullanici ViceDean olarak delete icin baseUrl olusturur")
    public void kullaniciViceDeanOlarakDeleteIcinBaseUrlOlusturur() {
        //https://managementonschools.com/app/lessons/delete/1775
        specViceDean.pathParams("first","lessons","second","delete","third","1778");

        response =given(specViceDean).delete("{first}/{second}/{third}");
        response.prettyPrint();
    }

      @And("kullanici get request yaparak lesson siler")
    public void kullaniciGetRequestYaparakLessonSiler(){
        lessonDeleteActualData= response.as(LessonGet1.class).getObject().getLessonName();
    }

    @And("kullanici ViceDean olarak sildigi datayi dogrular")
    public void kullaniciViceDeanOlarakSildigiDatayiDogrular() {
        assertEquals(lessonExpectedData.getLessonName(), lessonDeleteActualData);
    }
}



