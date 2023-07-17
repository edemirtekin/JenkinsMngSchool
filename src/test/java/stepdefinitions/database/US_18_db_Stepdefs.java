package stepdefinitions.database;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;

public class US_18_db_Stepdefs {


    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("{string} ile student cagir")
    public void ileStudentCagir(String student_id) {

        String query = "SELECT * FROM student_info WHERE student_id= "+student_id+"";
        resultSet=getResultSet(query);
        
    }


    @Then("body  {string},{string},{string},{string},{string},{string},{string},{string},{string} bilgilerini icermeli")
    public void bodyBilgileriniIcermeli(String id, String Absentee, String exam_average, String final_exam, String info_note, String letter_grade, String midterm_exam, String lesson_lesson_id, String student_id) throws SQLException {


        resultSet.next();
        String actid = resultSet.getString("id");
        String actAbsentee = resultSet.getString("Absentee");
        String actexam_average = resultSet.getString("exam_average");
        String actfinal_Exam = resultSet.getString("final_Exam");
        String actinfo_Note = resultSet.getString("info_Note");
        String actletter_grade = resultSet.getString("letter_grade");
        String actmidterm_exam = resultSet.getString("midterm_exam");
        String aclesson_lesson_id = resultSet.getString("lesson_lesson_id");
        String actstudent_id = resultSet.getString("student_id");



        assertEquals(id,actid);
        assertEquals(Absentee,actAbsentee);
        assertEquals(exam_average,actexam_average);
        assertEquals(midterm_exam,actmidterm_exam);
        assertEquals(lesson_lesson_id,aclesson_lesson_id);
        assertEquals(final_exam,actfinal_Exam);
        assertEquals(info_note,actinfo_Note);
        assertEquals(student_id,actstudent_id);
        assertEquals(letter_grade,actletter_grade);

    }
}

