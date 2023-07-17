package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.sql.*;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;

public class US22_db_AdminValidateStepDef_Positive {
    Connection connection;  // Java ile database arasındaki bağlantı için
    Statement statement;    //Javanın SQL sorgularını (query) tanıması için
    ResultSet resultSet;    // SQL den gelen sonuçlar için


    @Given("{string} ile admini cagir")
    public void ile_admini_cagir(String username) throws SQLException {
        // connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        // statement = connection.createStatement();
        // resultSet = statement.executeQuery(query);

        String query = "SELECT * FROM admins WHERE username='ttyusuf18'";
        resultSet = getResultSet(query);

        resultSet.next();
    }

    @Then("body  {string},{string},{string},{string},{string},{string},{string},{string} bilgilerini icermeli")
    public void bodyBilgileriniIcermeli(String birthDay, String birthPlace, String gender, String name, String phoneNumber, String ssn, String surname, String username) throws SQLException {


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
        assertEquals(phoneNumber, actualPhone);
        assertEquals(ssn, actualSsn);


    }

}
