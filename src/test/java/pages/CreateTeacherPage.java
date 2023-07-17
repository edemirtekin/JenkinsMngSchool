package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateTeacherPage extends CommonPage {

    @FindBy(xpath = "//*[@class='header_link ms-2']")
    public WebElement loginButtonHomePage;

    @FindBy(id = "username")
    public WebElement userNameLogin;

    @FindBy(id = "password")
    public WebElement passwordLogin;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement logoutYes;

    @FindBy(xpath = "//*[text()='Menu']")
    public WebElement menuButton;

    @FindBy(xpath = "//*[text()='Teacher Management']")
    public WebElement teacherManagementButton;

    @FindBy(xpath = "//*[@class=' css-19bb58m']")
    public WebElement selectLesson;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement addTeacherName;

    @FindBy(xpath = "//*[@id='surname']")
    public WebElement addTeacherSurname;

    @FindBy(xpath = "//*[@id='birthPlace']")
    public WebElement addTeacherbirthPlace;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement addTeacherEmail;

    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement addTeacherPhoneNumber;

    @FindBy(xpath = "//*[@id='isAdvisorTeacher']")
    public WebElement isAdvisorTeacherCheckbox;

    @FindBy(xpath = "//*[@value='MALE']")
    public WebElement addTeacherGender;

    @FindBy(xpath = "//*[@id='birthDay']")
    public WebElement addTeacherBirthday;

    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement addTeacherSsn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement addTeacherUserName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement addTeacherPassword;

    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement addTeacherSubmit;

    @FindBy(xpath = "//div[text()='Teacher saved successfully']")
    public WebElement teacherSavedSuccessfully;

    @FindBy(xpath = "//*[text()='Error: Lesson Programs not found']")
    public WebElement lessonNotFound;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement toastify;

    @FindBy(xpath = "//*[text()='Required']")
    public WebElement requiredAlert;

    @FindBy(xpath = "//*[text()='You have entered an invalid value. Valid values are: MALE, FEMALE']")
    public WebElement genderAlert;

    @FindBy(xpath = "//*[text()='Please enter valid SSN number']")
    public WebElement ssnAlert;

    @FindBy(xpath = "//*[text()='Minimum 11 character (XXX-XX-XXXX)']")
    public WebElement ssnMin11CharacterAlert;

    @FindBy(xpath = "//*[text()='Minimum 8 character']")
    public WebElement passwordMin8ChaAlert;

    @FindBy(xpath = "(//*[@class='page-item'])[4]")
    public WebElement endOfTeacherList;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> tableRowDatas;

    @FindBy(xpath = "//*[contains(text(),'Edit')]")
    public List<WebElement> editButtonList;

    @FindBy(xpath = " //*[@class=' css-hlgwow']")
    public WebElement editTeacherSelectLesson;

    @FindBy(xpath = "//div[text()='Teacher updated Successful']")
    public WebElement teacherUpdatedSuccessfull;





}
