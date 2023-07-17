package stepdefinitions.database;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static utilities.DataBaseUtils.getResultSet;

public class US_17_db_Stepdefs {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @And("Teacher ogrencinin {string} cagirir")
    public void teacherOgrencininCagirir(String id) {

        String query = "SELECT * FROM student_info WHERE id="+id+"";
        resultSet=getResultSet(query);


    }

    @And("Teacher ogrencinin {string}, {string},{string},{string},{string} ve {string} gorur")
    public void teacherOgrencininVeGorur(String id, String Lesson_lesson_id, String Absentee, String Midterm_Exam, String Final_Exam, String Info_Note) throws SQLException {

        resultSet.next();

        String actid = resultSet.getString("id");
        String actLesson_lesson_id = resultSet.getString("Lesson_lesson_id");
        String actAbsentee = resultSet.getString("Absentee");
        String actMidterm_Exam = resultSet.getString("Midterm_Exam");
        String actFinal_Exam = resultSet.getString("Final_Exam");
        String actInfo_Note = resultSet.getString("Info_Note");



        assertEquals(id,actid);
        assertEquals(Lesson_lesson_id,actLesson_lesson_id);
        assertEquals(Absentee,actAbsentee);
        assertEquals(Midterm_Exam,actMidterm_Exam);
        assertEquals(Final_Exam,actFinal_Exam);
        assertEquals(Info_Note,actInfo_Note);


    }
}
