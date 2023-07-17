package pojos;

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

public class LessonProgramAddLessonGetPojjo {
    private String startTime;
    private String stopTime;
    private ArrayList<LessonProgramAddLessonResponsePojo.LessonProgramLessonNamePojo> lessonName;
    private ArrayList<String > teachers;
    private ArrayList<String> students;
    private String day;


}
