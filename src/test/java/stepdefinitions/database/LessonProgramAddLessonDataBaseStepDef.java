package stepdefinitions.database;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;

public class LessonProgramAddLessonDataBaseStepDef {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("{string} ile ders programini cagir")
    public void ile_ders_programini_cagir(String id) {

        String query = "SELECT * FROM lesson_program WHERE id='5'";
        resultSet=getResultSet(query);


    }
    @Then("body  {string},{string},{string},{string},{string} bilgilerini icermeli")
    public void body_bilgilerini_icermeli(String id, String day, String start_time, String stop_time, String education_term_id) throws SQLException {

        resultSet.next();
       String actualId= resultSet.getString("id");
      String actualDay= resultSet.getString("day");
      String actualStart_time =resultSet.getString("start_time");
      String actualStop_time =resultSet.getString("stop_time");
      String actualEducation_term_id =resultSet.getString("education_term_id");

      assertEquals(id,actualId);
      assertEquals(day,actualDay);
      assertEquals(start_time,actualStart_time);
      assertEquals(stop_time,actualStop_time);
      assertEquals(education_term_id,actualEducation_term_id);




    }





    @And("gunu {string},baslangici {string} ve bitisi {string} olan ders program bilgilerini cagir")
    public void gunuBaslangiciVeBitisiOlanDersProgramBilgileriniCagir(String arg0, String arg1, String arg2) throws SQLException {

        String query = "SELECT * FROM lesson_program WHERE day='FRIDAY' and start_time='11:00:00' and stop_time='12:00:00'";
        ResultSet veri= resultSet=getResultSet(query);

        while (veri.next()){

            System.out.println(veri.getString("id")
                    +veri.getString("day")+
                    veri.getString("start_time")+
                    veri.getString("stop_time")+
                    veri.getString("education_term_id"));

        }
    }
}
