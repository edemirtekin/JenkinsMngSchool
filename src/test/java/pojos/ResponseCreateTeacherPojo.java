package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResponseCreateTeacherPojo {

    private CreateTeacherPojo object;

    }
