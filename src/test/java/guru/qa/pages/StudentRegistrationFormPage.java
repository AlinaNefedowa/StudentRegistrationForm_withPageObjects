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

    public StudentRegistrationFormPage setFirstName(String value){
        $("#firstName").setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String value){
        $("#lastName").setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setUserEmail(String value){
        $("#userEmail").setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        //$("#gender-radio-2").parent().click();
        return this;
    }

    public StudentRegistrationFormPage setUserNumber(String value){
        $("#userNumber").setValue(value);
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

    public StudentRegistrationFormPage setSubjects(String value){
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setHobbies(String value1, String value2){
        $("#hobbiesWrapper").$(byText(value1)).click();
        $("#hobbiesWrapper").$(byText(value2)).click();
        //$("#hobbies-checkbox-1").parent().click();
        return this;
    }

    public StudentRegistrationFormPage uplaodPicture(String path){
        $("#uploadPicture").uploadFromClasspath("img/"+path);
        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String value){
        $("#currentAddress").setValue(value);
        return this;

    }

    public StudentRegistrationFormPage setStateAndCity(String value1, String value2){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value1)).click();
        $("#city").click();
        $("#city").$(byText(value2)).click();
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

    public StudentRegistrationFormPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key))
                        .parent().shouldHave(text(value));
        return this;
    }


}
