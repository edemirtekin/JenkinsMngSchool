package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;


public class US13_db_TeacherValidateStepDefs {

    ResultSet resultSet;

    @Given("{string} ile ogretmeni cagir")
    public void ileOgretmeniCagir(String username) throws SQLException {

        String query = "SELECT * FROM teacher WHERE username = '" + username + "'";
        resultSet = getResultSet(query);

    }

    @Then("body sunlari icermeli: {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string},{string}")
    public void bodySunlariIcermeli(String birth_day, String birth_place, String gender, String name, String phone_number, String ssn, String surname, String username, String email, String is_advisor) throws SQLException {
        resultSet.next();
        String actUsername = resultSet.getString("username");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhone = resultSet.getString("phone_number");
        String actGender = resultSet.getString("gender");
        String actDateOfBirth = resultSet.getString("birth_day");
        String actSsn = resultSet.getString("ssn");
        String actEmail = resultSet.getString("email");
        Boolean actIsAdv = resultSet.getBoolean("is_advisor");

        assertEquals(username, actUsername);
        assertEquals(name, actName);
        assertEquals(surname, actSurname);
        assertEquals(birth_place, actBirthPlace);
        assertEquals(phone_number, actPhone);
        assertEquals(gender, actGender);
        assertEquals(birth_day, actDateOfBirth);
        assertEquals(ssn, actSsn);
        assertEquals(email, actEmail);
        assertEquals(is_advisor, actIsAdv.toString());
    }
}
