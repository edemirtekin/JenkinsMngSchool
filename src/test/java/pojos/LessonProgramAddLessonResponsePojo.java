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
public class LessonProgramAddLessonResponsePojo {   //OUTER CLASS
    private LessonProgramAddLessonObjectPojo object;
    private String message;
    private String httpStatus;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @ToString
    public static class LessonProgramAddLessonObjectPojo { //INNER CLASS
        private int lessonProgramId;
        private String startTime;
        private String stopTime;
        private ArrayList<LessonProgramLessonNamePojo> lessonName;
        private String day;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @ToString
    public static class LessonProgramLessonNamePojo { //INNER CLASS
        private Integer lessonId;
        private String lessonName;
        private Integer creditScore;
        private Boolean compulsory;

    }
}
