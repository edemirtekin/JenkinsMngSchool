package pojos;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CreateTeacherPojo {

    private String birthDay;
    private String birthPlace;
    private String email;
    private String gender;
    private Boolean isAdvisorTeacher;
    private List<String> lessonsIdList;
    private String name;
    private String password;
    private String phoneNumber;
    private String ssn;
    private String surname;
    private String username;
}
