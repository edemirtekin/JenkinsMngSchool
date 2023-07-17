package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pojos.LessonProgramAddLessonGetPojjo;
import pojos.LessonProgramAddLessonResponsePojo;


import java.util.ArrayList;

import static baseUrl.ManagementonSchoolsBaseUrl.specViceDean;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class LessonProgramAddLessonStepDefGetElif {

    Response response;
    LessonProgramAddLessonGetPojjo expectedData;
    LessonProgramAddLessonResponsePojo.LessonProgramLessonNamePojo lessonProgramLessonNamePojo;
    @Given("kullanici get lesson program icin base url olusturur")
    public void kullanici_get_lesson_program_icin_base_url_olusturur() {
        //set url https://managementonschools.com/app/lessonPrograms/getById/622
        specViceDean.pathParams("first","lessonPrograms","second","getById","third",622);

    }
    @Given("kullanici get icin lesson program expected datayi olusturur")
    public void kullanici_get_icin_lesson_program_expected_datayi_olusturur() {
//set the expected data

        /*{
            "lessonProgramId": 622,
                "startTime": "10:00:00",
                "stopTime": "12:00:00",
                "lessonName": [
            {
                "lessonId": 6,
                    "lessonName": "Calculus",
                    "creditScore": 5,
                    "compulsory": true
            }
    ],
            "teachers": [],
            "students": [],
            "day": "MONDAY"
        }

         */

        ArrayList<String> teacherList = new ArrayList<>();
        ArrayList<String> studentList = new ArrayList<>();

        lessonProgramLessonNamePojo =  new LessonProgramAddLessonResponsePojo.LessonProgramLessonNamePojo(6,"Calculus",5,true);
        ArrayList<LessonProgramAddLessonResponsePojo.LessonProgramLessonNamePojo> lessonName=new ArrayList<>();
        lessonName.add(lessonProgramLessonNamePojo);


     expectedData= new LessonProgramAddLessonGetPojjo("10:00:00","12:00:00",lessonName,teacherList,studentList,"MONDAY");
        System.out.println("expectedData = " + expectedData);

    }
    @Given("kullanici get request yaparak ders programi  olusturur")
    public void kullanici_get_request_yaparak_ders_programi_olusturur() {
        //

        response=given(specViceDean).get("{first}/{second}/{third}");
        response.prettyPrint();

    }
    @Given("kullanici cagirdigi ders programini dogrular")
    public void kullanici_cagirdigi_ders_programini_dogrular() {
        //Do assertion
      LessonProgramAddLessonGetPojjo actualData=  response.as(LessonProgramAddLessonGetPojjo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
       assertEquals(expectedData.getStartTime(),actualData.getStartTime());
       assertEquals(expectedData.getStopTime(),actualData.getStopTime());
       assertEquals(expectedData.getLessonName().get(0).getLessonId(),actualData.getLessonName().get(0).getLessonId());
       assertEquals(expectedData.getLessonName().get(0).getLessonName(),actualData.getLessonName().get(0).getLessonName());
       assertEquals(expectedData.getLessonName().get(0).getCreditScore(),actualData.getLessonName().get(0).getCreditScore());
       assertEquals(expectedData.getLessonName().get(0).getCompulsory(),actualData.getLessonName().get(0).getCompulsory());
       assertEquals(expectedData.getTeachers(),actualData.getTeachers());
       assertEquals(expectedData.getStudents(),actualData.getStudents());
       assertEquals(expectedData.getDay(),actualData.getDay());




    }

}
