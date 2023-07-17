package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication.*;

public class ManagementonSchoolsBaseUrl {

    public static RequestSpecification specAdmin;
    public static RequestSpecification specDean;
    public static RequestSpecification specViceDean;
    public static RequestSpecification specTeacher;

    public static void setUpApi(){
        specAdmin= new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateTokenForAdmin()).setBaseUri("https://managementonschools.com/app").build();
        specDean= new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateTokenForDean()).setBaseUri("https://managementonschools.com/app").build();
        specViceDean= new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateTokenForViceDean()).setBaseUri("https://managementonschools.com/app").build();
        specTeacher= new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateTokenForTeacher()).setBaseUri("https://managementonschools.com/app").build();
    }
}
