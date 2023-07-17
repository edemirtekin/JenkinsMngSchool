package stepdefinitions.api;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.StudentOuterResPojo;


import static baseUrl.ManagementonSchoolsBaseUrl.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StudentInfoStepdefsPOST {


    Response response;
    StudentOuterResPojo.StudentInnerResponsePojo.StudentilkPojo expectedData;
    StudentOuterResPojo actualData;


    @Given("kullanici base url olusturur..")
    public void kullaniciBaseUrlOlusturur() {

        specTeacher.pathParams("first", "studentInfo", "second", "save");


    }

    @And("kullanici expected data yi olusturur.{string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciExpectedDataYiOlusturur(String id, String absentee, String educationTermId, String finalExam, String infoNote, String lessonId, String midtermExam, String studentId) {

        expectedData = new StudentOuterResPojo.StudentInnerResponsePojo.StudentilkPojo(id, absentee, educationTermId, finalExam, infoNote, lessonId, midtermExam, studentId);

        System.out.println("expectedData = " + expectedData);
    }


    @And("kullanici post request yaparak bir student info olusturur")
    public void kullaniciPostRequestYaparakBirStudentInfoOlusturur() {


        response = given(specTeacher).body(expectedData).post("{first}/{second}");
       response.prettyPrint();

    }

    @And("kullanici student info olustugunu dogrular")
    public void kullaniciStudentInfoOlustugunuDogrular() {


       actualData = response.as(StudentOuterResPojo.class);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getFinalExam(),actualData.getObject().getFinalExam());
        Assert.assertEquals(expectedData.getAbsentee(),actualData.getObject().getAbsentee());
        Assert.assertEquals(expectedData.getInfoNote(),actualData.getObject().getInfoNote());
        Assert.assertEquals(expectedData.getMidtermExam(),actualData.getObject().getMidtermExam());





}


    }




