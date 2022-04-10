package guru.qa.tests;

        import com.codeborne.selenide.Configuration;
        import com.codeborne.selenide.Selenide;
        import com.github.javafaker.Faker;
        import guru.qa.pages.StudentRegistrationFormPage;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.*;
        import static guru.qa.utils.RandomUtils.getRandomGender;
        import static guru.qa.utils.RandomUtils.getRandomStringOfDigits;
        import static java.lang.String.format;
        import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRegistrationFormTestsImproved {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           email = faker.internet().emailAddress(),
           currentAddress = faker.address().fullAddress(),
           mobile = getRandomStringOfDigits(10),
           gender = getRandomGender();

    String
           birthDay = "30",
           birthMonth = "April",
           birthYear = "1992",
           subjects = "Computer science",
           hobby1 = "Sports",
           hobby2 = "Reading",
           picture = "Picture.jpeg",
           state = "Haryana",
           city = "Karnal";

    String expectedFullName = format("%s %s", firstName, lastName),
           expectedStateAndCity = format("%s %s", state, city),
           expectedHobbies = format("%s, %s", hobby1, hobby2);

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        studentRegistrationFormPage.openPage()
                                   .setFirstName(firstName)
                                   .setLastName(lastName)
                                   .setUserEmail(email)
                                   .setGender(gender)
                                   .setUserNumber(mobile)
                                   .setDateOfBirth(birthDay, birthMonth, birthYear)
                                   .setSubjects(subjects)
                                   .setHobbies(hobby1, hobby2)
                                   .uplaodPicture(picture)
                                   .setStateAndCity(state, city)
                                   .setCurrentAddress(currentAddress)
                                   .scrollThePage()
                                   .clickSubmit();

        //Assertions
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        studentRegistrationFormPage.checkResult("Student name", expectedFullName)
                                   .checkResult("Student email", email)
                                   .checkResult("Student gender", gender)
                                   .checkResult("Student mobile", mobile)
                                   .checkResult("Student dateOfBirth", birthDay + " " + birthMonth + "," + birthYear)
                                   .checkResult("Student subjects", subjects)
                                   .checkResult("Student hobbies", expectedHobbies)
                                   .checkResult("Student picture", picture)
                                   .checkResult("Student currentAddress", currentAddress)
                                   .checkResult("Student stateAndCity", expectedStateAndCity);
    }
}
