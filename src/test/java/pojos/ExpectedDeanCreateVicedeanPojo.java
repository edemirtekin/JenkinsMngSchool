package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class ExpectedDeanCreateVicedeanPojo {

    //private String id;
    private String name;
    private String surname;
    private String birthPlace;
    private String phone;
    private String gender;
    private String birthDay;
    private String ssn;
    private String username;



}




