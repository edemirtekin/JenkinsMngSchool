package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown=true)
    @ToString
 public class ViceDeanStudent {



        private String advisorTeacherId;

        private String birthDay;
        private String birthPlace;
        private String email;
        private String fatherName;
        private String gender;

        private String motherName;
        private String name;
        private String surname;

        private String phoneNumber;
        private String ssn;
        private String username;
        private String password;

//    "advisorTeacherId": 1,
//            "birthDay": "1999-06-27",
//            "birthPlace": "ankara",
//            "email": "asdf@gmail.com",
//            "fatherName": "string",
//            "gender": "MALE",
//            "motherName": "string",
//            "name": "str",
//            "password": "str00123g",
//            "phoneNumber": "567-365-7423",
//            "ssn": "294-65-9866",
//            "surname": "string",
//            "username
    }











