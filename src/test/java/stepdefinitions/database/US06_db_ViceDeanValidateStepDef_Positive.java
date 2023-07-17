package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;

public class US06_db_ViceDeanValidateStepDef_Positive {
    Connection connection;  // Java ile database arasındaki bağlantı için
    Statement statement;    //Javanın SQL sorgularını (query) tanıması için
    ResultSet resultSet;    // SQL den gelen sonuçlar için




    @Given("{string} ile admini cagirma")
    public void ileAdminiCagirma(String username) throws SQLException {
        String query = "SELECT * FROM vice_dean WHERE username='Salihhak1'";
        resultSet = getResultSet(query);


    }

    @Then("vicedean body  {string},{string},{string},{string},{string},{string},{string},{string} bilgilerini icermeli")
    public void vicedeanBodyBilgileriniIcermeli(String birthDay, String birthPlace, String gender, String name, String phone, String ssn, String surname, String username) throws SQLException {
        resultSet.next();

        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualbirthPlace = resultSet.getString("birth_place");
        String actualgender = resultSet.getString("gender");
        String actualdateOfBirth = resultSet.getString("birth_day");
        String actualPhone = resultSet.getString("phone_number");
        String actualSsn = resultSet.getString("ssn");
        String actualUserName = resultSet.getString("username");


        assertEquals(username, actualUserName);
        assertEquals(name, actualName);
        assertEquals(surname, actualSurname);
        assertEquals(birthPlace, actualbirthPlace);
        assertEquals(gender, actualgender);
        assertEquals(birthDay, actualdateOfBirth);
        assertEquals(phone, actualPhone);
        assertEquals(ssn, actualSsn);
    }
}
