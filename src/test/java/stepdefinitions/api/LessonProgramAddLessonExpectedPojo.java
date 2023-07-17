package stepdefinitions.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class LessonProgramAddLessonExpectedPojo {

    private String day;
    private int educationTermId;
    private  ArrayList<Integer> lessonIdList;
    private String startTime;
    private String stopTime;



}
