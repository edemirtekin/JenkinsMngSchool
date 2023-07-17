package stepdefinitions.api;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.*;

import static baseUrl.ManagementonSchoolsBaseUrl.specTeacher;



public class StudentInfoStepdefsGET {


    Response response;
    StudentOrtancaResPojo expectedData;
    StudentOuterResPojo actualData;
    JsonPath jsonPath;


    @Given("kullanici get Student list base url olusturur..")
    public void kullaniciGetStudentListBaseUrlOlusturur() {


        specTeacher.pathParams("first", "studentInfo", "second", "get", "third", "751");

    }

    @And("kullanici student info'yu olusturur {string},{string},{string},{string},{string}")
    public void kullaniciStudentInfoYuOlusturur(String lessonName, String absentee, String midtermExam, String finalExam, String infoNote) {


        expectedData = new StudentOrtancaResPojo(lessonName, absentee, midtermExam, finalExam, infoNote);

        response = given(specTeacher).body(expectedData).get("{first}/{second}/{third}");
        response.prettyPrint();

}


    @Then("kullanici student info'yu alir ve dogrular1")
    public void kullaniciStudentInfoYuAlirVeDogrular1() {



        actualData = response.as(StudentOuterResPojo.class);
        System.out.println("actualData = " + actualData);

/*
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getLessonName(),actualData.getObject().getLessonName());
        Assert.assertEquals(expectedData.getFinalExam(),actualData.getObject().getFinalExam());
        Assert.assertEquals(expectedData.getAbsentee(),actualData.getObject().getAbsentee());
        Assert.assertEquals(expectedData.getInfoNote(),actualData.getObject().getInfoNote());
        Assert.assertEquals(expectedData.getMidtermExam(),actualData.getObject().getMidtermExam());




 */




    }



}

