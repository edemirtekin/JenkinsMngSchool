package hooks;

import io.cucumber.java.Before;

import static baseUrl.ManagementonSchoolsBaseUrl.setUpApi;

public class Hooks {
    @Before("@VD_Login")
    public void setUp() {
        System.out.println("ViceDean olarak login işlemi gerçekleşti");
    }

    @Before("@api")


    public void beforeApi(){setUpApi();}

}
