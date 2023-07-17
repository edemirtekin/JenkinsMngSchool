package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pojos.LessonProgramAddLessonResponsePojo;

import java.util.ArrayList;

import static baseUrl.ManagementonSchoolsBaseUrl.specViceDean;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class LessonProgramAddLessonStepDefPostElif {

    Response response;

    LessonProgramAddLessonExpectedPojo expectedData;

    public static int lessonProgramId;
    @Given("kullanici add lesson  program icin base url olusturur")
    public void kullanici_add_lesson_program_icin_base_url_olusturur() {

        //set the url https://managementonschools.com/app/lessonPrograms/save
        specViceDean.pathParams("first", "lessonPrograms", "second", "save");



    }


    @Given("kullanici add lesson program icin expected data yi olusturur")
    public void kullanici_add_lesson_program_icin_expected_data_yi_olusturur() {
        //set the expected data

        Faker faker = new Faker();
        int numberLessonId = faker.number().numberBetween(1,7);
        ArrayList<Integer> lessonIdlist = new ArrayList();
        lessonIdlist.add(numberLessonId);

       String day= faker.options().option("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY");
       int educationId=  faker.number().numberBetween(1,20);
     expectedData= new LessonProgramAddLessonExpectedPojo(day,educationId,lessonIdlist,"11:00","12:00");

        System.out.println("expectedData = " + expectedData);


    }

    @Given("kullanici post request yaparak ders programi  olusturur")
    public void kullanici_post_request_yaparak_ders_programi_olusturur() {

        //get the request set the expected data

       response= given(specViceDean).body(expectedData).post("{first}/{second}");
       response.prettyPrint();





    }

    @Given("kullanici olusturdugu ders programini dogrular")
    public void kullanici_olusturdugu_ders_programini_dogrular() {

        //Do assertion
       LessonProgramAddLessonResponsePojo actualData= response.as(LessonProgramAddLessonResponsePojo.class);
        System.out.println("actualData = " + actualData);


          assertEquals(200,response.statusCode());
          assertEquals(expectedData.getDay(),actualData.getObject().getDay());
        assertEquals(expectedData.getLessonIdList().get(0),actualData.getObject().getLessonName().get(0).getLessonId());

        String expectedStartTime = expectedData.getStartTime().trim();
        String actualStartTime = actualData.getObject().getStartTime().substring(0, 5);
        assertEquals(expectedStartTime, actualStartTime);

        String expectedStopTime = expectedData.getStopTime().trim();
        String actualStopTime = actualData.getObject().getStopTime().substring(0, 5);
        assertEquals(expectedStopTime, actualStopTime);


       lessonProgramId= response.jsonPath().getInt("object.lessonProgramId");

        System.out.println("lessonProgramId = " + lessonProgramId);

    }

}
