package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;

public class MyMeetStepdefs_US19 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("{string} ile meet olustur")
    public void ileMeetOlustur(String id) {
        String query = "SELECT * FROM meet WHERE id="+id+"";
        resultSet=getResultSet(query);

    }

    @Then("body  {string},{string},{string},{string},{string},{string}bilgilerini icermeli")
    public void bodyBilgileriniIcermeli(String id, String date, String description, String start_time, String stop_time, String advisor_teacher_id) throws SQLException {

        resultSet.next();

        String actid = resultSet.getString("id");
        String actdate = resultSet.getString("date");
        String actdescription = resultSet.getString("description");
        String actstart_time = resultSet.getString("start_time");
        String actstop_time = resultSet.getString("stop_time");
        String actadvisor_teacher_id = resultSet.getString("advisor_teacher_id");



        assertEquals(id,actid);
        assertEquals(date,actdate);
        assertEquals(description,actdescription);
        assertEquals(start_time,actstart_time);
        assertEquals(stop_time,actstop_time);
        assertEquals(advisor_teacher_id,actadvisor_teacher_id);

    }
}
