package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.assertEquals;

import static utilities.DataBaseUtils.getResultSet;


public class ViceAndAdminStudentManagementDbstepdefs {
    ResultSet resultSet;

    @Given("{string} ile student cagirma")
    public void ileStudentCagirma(String username) {
        String query = "SELECT * FROM student WHERE username = '"+username+"'";
        resultSet=getResultSet(query);

    }

    @Then("body sunlari icermeli: {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string},{string},{string},{string}")
    public void bodySunlariIcermeli(String name, String surname, String birthplace, String phone, String gender, String dateOfBirth, String ssn , String username, String password, String mothername, String fathername, String teacher) throws SQLException {
        resultSet.next();//Pointer varsayılan olarak sütun isimlerini gösterir. Next methodu ile table üzerine alınarak data okunabilir.
        String actUsername = resultSet.getString("username");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhone = resultSet.getString("phone_number");
        String actGender = resultSet.getString("gender");
        String actDateOfBirth = resultSet.getString("birth_day");
        String actSsn = resultSet.getString("ssn");
        String actFatherName = resultSet.getString("father_name");
        String actMotherName = resultSet.getString("mother_name");
        String actTeacher = resultSet.getString("advisor_teacher_id");

        assertEquals(username,actUsername);
        assertEquals(name,actName);
        assertEquals(surname,actSurname);
        assertEquals(birthplace,actBirthPlace);
        assertEquals(phone,actPhone);
        assertEquals(gender,actGender);
        assertEquals(dateOfBirth,actDateOfBirth);
        assertEquals(ssn,actSsn);
        assertEquals(fathername,actFatherName);
        assertEquals(mothername,actMotherName);
        assertEquals(teacher,actTeacher);


    }

    @Given("{string} ile admin student cagir")
    public void ileAdminStudentCagir(String username) {
        String query = "SELECT * FROM student WHERE username = '"+username+"'";
        resultSet=getResultSet(query);

    }

    @Then("admin body sunlari icermeli: {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string},{string},{string},{string}")
    public void adminBodySunlariIcermeli(String name, String surname, String birthplace, String phone, String gender, String dateOfBirth, String ssn , String username, String password, String mothername, String fathername, String teacher) throws SQLException {
        resultSet.next();//Pointer varsayılan olarak sütun isimlerini gösterir. Next methodu ile table üzerine alınarak data okunabilir.
        String actUsername = resultSet.getString("username");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhone = resultSet.getString("phone_number");
        String actGender = resultSet.getString("gender");
        String actDateOfBirth = resultSet.getString("birth_day");
        String actSsn = resultSet.getString("ssn");
        String actFatherName = resultSet.getString("father_name");
        String actMotherName = resultSet.getString("mother_name");
        String actTeacher = resultSet.getString("advisor_teacher_id");

        assertEquals(username,actUsername);
        assertEquals(name,actName);
        assertEquals(surname,actSurname);
        assertEquals(birthplace,actBirthPlace);
        assertEquals(phone,actPhone);
        assertEquals(gender,actGender);
        assertEquals(dateOfBirth,actDateOfBirth);
        assertEquals(ssn,actSsn);
        assertEquals(fathername,actFatherName);
        assertEquals(mothername,actMotherName);
        assertEquals(teacher,actTeacher);
    }

    @Given("{string} ile message cagir")
    public void ileMessageCagir(String id) {
        String query = "SELECT * FROM contact_message WHERE id = '"+id+"'";
        resultSet=getResultSet(query);


    }

    @Then("messaj body sunlari icermeli: {string}, {string}, {string}, {string}")
    public void messajBodySunlariIcermeli(String email, String message, String name, String subject) throws SQLException {
        resultSet.next();//Pointer varsayılan olarak sütun isimlerini gösterir. Next methodu ile table üzerine alınarak data okunabilir.
        String actEmail = resultSet.getString("email");
        String actMessage = resultSet.getString("message");
        String actName = resultSet.getString("name");
        String actSubject = resultSet.getString("subject");


        assertEquals(email,actEmail);
        assertEquals(message,actMessage);
        assertEquals(name,actName);
        assertEquals(subject,actSubject);

    }


//    @Given("birthplace {string} ile guest useri cagir")
//    public void birthplaceIleGuestUseriCagir(String birthplace) throws SQLException {
//        //Connection ve Statement oluştur
//        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
//        statement = connection.createStatement();
//
//        //Query'yi çalıştır
//        String query = "SELECT * FROM guest_user WHERE birth_place = '"+birthplace+"'";
//        resultSet = statement.executeQuery(query);
//
//    }

//    @Then("kac tane user oldugunu bul")
//    public void kacTaneUserOldugunuBul() throws SQLException {
//        while (resultSet.next()){
//
//            System.out.println("resultSet = " + resultSet.getString("name" + "---" + resultSet.getString("name"));
//
//        }
//    }
//    @Given("silinen {string} ile guest useri cagir")
//    public void silinenIleGuestUseriCagir(String username) {
//
//        String query = "SELECT * FROM student WHERE username = '"+username+"'";
//        resultSet = getResultSet(query);
//
//    }
//
//    @Then("tablein bos oldugunu dogrula")
//    public void tableinBosOldugunuDogrula() throws SQLException {
//
//        assertFalse(resultSet.next());
//
//    }
}
