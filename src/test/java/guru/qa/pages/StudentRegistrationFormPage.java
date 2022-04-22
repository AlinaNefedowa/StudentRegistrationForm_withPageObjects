package guru.qa.pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static guru.qa.utils.RandomUtils.getRandomGender;
import static guru.qa.utils.RandomUtils.getRandomStringOfDigits;
import static java.lang.String.format;

public class StudentRegistrationFormPage {

    //locators

    //actions

    public StudentRegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public StudentRegistrationFormPage setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }

    public StudentRegistrationFormPage setUserEmail(String userEmail){
        $("#userEmail").setValue(userEmail);
        return this;
    }

    public StudentRegistrationFormPage setGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();
        //$("#gender-radio-2").parent().click();
        return this;
    }

    public StudentRegistrationFormPage setUserNumber(String userNumber){
        $("#userNumber").setValue(userNumber);
        return this;
    }

    public StudentRegistrationFormPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public StudentRegistrationFormPage setSubjects(String subjects){
        $("#subjectsInput").setValue(subjects).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setHobbies(String[] hobby){
        $("#hobbiesWrapper").$(byText(hobby[0])).click();
        $("#hobbiesWrapper").$(byText(hobby[1])).click();
        //$("#hobbies-checkbox-1").parent().click();
        return this;
    }

    public StudentRegistrationFormPage uplaodPicture(String path){
        $("#uploadPicture").uploadFromClasspath("img/"+path);
        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
        return this;

    }

    public StudentRegistrationFormPage setStateAndCity(String state, String city){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        return this;
    }

    public StudentRegistrationFormPage scrollThePage(){
        $("#stateCity-wrapper").scrollIntoView(true);
        return this;
    }

    public StudentRegistrationFormPage clickSubmit(){
        $("#submit").click();
        return this;
    }

    public StudentRegistrationFormPage thanks(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public StudentRegistrationFormPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key))
                        .parent().shouldHave(text(value));
        return this;
    }


}
