

package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class StudentOrtancaResPojo {
//ortanca pojo
    private String id;
    private String midtermExam;
    private String finalExam;
    private String absentee;
    private String infoNote;
    private String lessonName;
    private String creditScore;
    private String educationTerm;
    private String average;
    private StudentOuterResPojo.StudentInnerResponsePojo studentResponse;
    private String compulsory;
    private String note;





    public StudentOrtancaResPojo(String lessonName, String absentee, String midtermExam, String finalExam, String infoNote) {
    }



}


