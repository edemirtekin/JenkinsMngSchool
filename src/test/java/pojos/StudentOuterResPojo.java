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

public class StudentOuterResPojo {
//outer

    private StudentOrtancaResPojo object;
    private String message;
    private String httpStatus;




        @JsonIgnoreProperties(ignoreUnknown = true)

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @ToString


        public static class StudentInnerResponsePojo {

// inner pojo

            private StudentilkPojo object;
            private int userId;
            private String username;
            private String name;
            private String surname;
            private String birthDay;
            private String birthPlace;
            private String phoneNumber;
            private String gender;
            private String studentNumber;
            private String motherName;
            private String fatherName;
            private String email;
            private String active;


            @JsonIgnoreProperties(ignoreUnknown = true)

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @ToString

            public static class StudentilkPojo {


                private String id;
                private String absentee;
                private String educationTermId;
                private String finalExam;
                private String infoNote;
                private String lessonId;
                private String midtermExam;
                private String studentId;


            }
        }
    }
