package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    // "Admin" rolü için token veren method

    public static String generateTokenForAdmin() {
        String body = "{ \"password\": \""+ ConfigReader.getProperty("passwordAdmin")+"\", \"username\": \""+ ConfigReader.getProperty("usernameAdmin")+"\"}";
        Response response = given().contentType(ContentType.JSON).body(body).post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }

    // "Dean" rolü için token veren method

    public static String generateTokenForDean() {
        String body = "{ \"password\": \""+ ConfigReader.getProperty("passwordDean")+"\", \"username\": \""+ ConfigReader.getProperty("usernameDean")+"\"}";
        Response response = given().contentType(ContentType.JSON).body(body).post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }

    // "Vice Dean" rolü için token veren method

    public static String generateTokenForViceDean() {
        String body = "{ \"password\": \""+ ConfigReader.getProperty("passwordViceDean")+"\", \"username\": \""+ ConfigReader.getProperty("usernameViceDean")+"\"}";
        Response response = given().contentType(ContentType.JSON).body(body).post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");

    }



    // "Teacher" rolü için token veren method

    public static String generateTokenForTeacher() {
        String body = "{ \"password\": \""+ ConfigReader.getProperty("passwordTeacher")+"\", \"username\": \""+ ConfigReader.getProperty("usernameTeacher")+"\"}";
        Response response = given().contentType(ContentType.JSON).body(body).post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }

    // "Student" rolü için token veren method

    public static String generateTokenForStudent() {
        String body = "{ \"password\": \""+ ConfigReader.getProperty("passwordStudent")+"\", \"username\": \""+ ConfigReader.getProperty("usernameStudent")+"\"}";
        Response response = given().contentType(ContentType.JSON).body(body).post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }

}
