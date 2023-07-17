package stepdefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pojos.LessonProgramTeacherAssignmentExpectedPojo;


import java.util.ArrayList;

import static baseUrl.ManagementonSchoolsBaseUrl.specViceDean;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class LessonProgramTeacherAssignmentStepDef {
    LessonProgramTeacherAssignmentExpectedPojo expectedData;

    Response response;
    @Given("kullanici teacher assignment  icin base url olusturur")
    public void kullanici_teacher_assignment_icin_base_url_olusturur() {
        //set the url https://managementonschools.com/app/teachers/chooseLesson
        specViceDean.pathParams("first", "teachers", "second", "chooseLesson");

    }
    @Given("kullanici teacher assignment icin expected data yi olusturur")
    public void kullanici_teacher_assignment_icin_expected_data_yi_olusturur() {
        Faker faker = new Faker();
        int numberLessonId = faker.number().numberBetween(1,10);
        ArrayList<Integer> lessonProgramId = new ArrayList();
        lessonProgramId.add(numberLessonId);
         int teacherId=faker.number().numberBetween(1,10);


    expectedData=new LessonProgramTeacherAssignmentExpectedPojo(lessonProgramId,teacherId);
        System.out.println("expectedData = " + expectedData);

    }
    @Given("kullanici post request yaparak teacher assign  yapar")
    public void kullanici_post_request_yaparak_teacher_assign_yapar() {

        response= given(specViceDean).body(expectedData).post("{first}/{second}");
        response.prettyPrint();


    }
    @Given("kullanici assign yaptigini dogrular")
    public void kullanici_assign_yaptigini_dogrular() {

        assertEquals(200,response.statusCode());



    }


}
