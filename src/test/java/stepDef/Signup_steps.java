package stepDef;

import base.GlobalTestData;
import base.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Signup_page;


public class Signup_steps extends Setup {
    Faker faker = new Faker();
    Signup_page SIGNUP = new Signup_page(driver);


    @And("I click on Sign up now button")
    public void iClickOnSignUpNowButton() {
        SIGNUP.clickOnSignUpNowButtonFromSignUpPage();
    }

    @And("I fill out the sign up form with valid Info")
    public void iFillOutTheSignUpFormWithValidInfo() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter fake last name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("2004");
        SIGNUP.selectCurrentDate();
    }

    @And("I agree with Privacy Policy")
    public void iAgreeWithPrivacyPolicy() {
        SIGNUP.clickPrivacyPolicyCheckbox();
    }

    @And("I agree with Terms and Conditions")
    public void iAgreeWithTermsAndConditions() {
        SIGNUP.clickTermsAndConditionsCheckbox();
    }

    @When("I click on Sign Up button")
    public void iClickOnSignUpButton() {
        SIGNUP.clickSignUpButtonToRegister();
    }

    @Then("I will see a confirmation message upon new account creation")
    public void iWillSeeAConfirmationMessageUponNewAccountCreation() {
        SIGNUP.assertSignUpCompleteText();
        SIGNUP.assertAccountIsCreatedText();
    }

    @And("I fill out the sign up form with under aged")
    public void iFillOutTheSignUpFormWithUnderAged() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter fake last name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("2021");
        SIGNUP.selectCurrentDate();
    }

    @And("I fill out the sign up form having different password value under Confirm Password")
    public void iFillOutTheSignUpFormHavingDifferentPasswordValueUnderConfirmPassword() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter different password under Confirm Password Text box
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_DIFFERENT_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter fake last name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("1988");
        SIGNUP.selectCurrentDate();
    }

    @Then("I will verify error message under DOB")
    public void iWillSeeErrorMessageUnderDOB() {
        SIGNUP.assertUnderAgeErrorMessage();
    }

    @Then("I will verify error message under Terms and Conditions")
    public void iWillSeeErrorMessageUnderTermsAndConditions() {
            SIGNUP.assertTermsAndConditionsErrorMessage();
        }

    @Then("I will verify error message under Privacy Policy")
    public void iWillSeeErrorMessageUnderPrivacyPolicy() {
        SIGNUP.assertPrivacyPolicyErrorMessage();
    }

    @Then("I will verify error message under Confirm Password")
    public void iWillSeeErrorMessageUnderConfirmPassword() {
        SIGNUP.assertPasswordMatchErrorMessage();
    }

    @When("I click on Cancel button")
    public void iClickOnCancelButton() {
        SIGNUP.cancelSignUp();
    }

    @Then("I will verify user revert back to Sign In screen")
    public void iWillVerifyUserRevertBackToSignInScreen() {
        SIGNUP.assertSignInScreen();
    }

    @And("I fill out the sign up form without email address")
    public void iFillOutTheSignUpFormWithoutEmailAddress() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter fake last name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("1988");
        SIGNUP.selectCurrentDate();
        // Remove email address
        SIGNUP.clearEmailField();
    }

    @And("I fill out the sign up form with invalid email address")
    public void iFillOutTheSignUpFormWithInvalidEmailAddress() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter fake last name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("1988");
        SIGNUP.selectCurrentDate();
        // Enter invalid email address
        SIGNUP.enterEmailInSignUpPage("invalid@");
    }

    @Then("I will verify email required error message")
    public void iWillVerifyEmailRequiredErrorMessage() {
        SIGNUP.assertEmailIsRequired();
    }

    @Then("I will verify email address invalid error message")
    public void iWillVerifyEmailAddressInvalidErrorMessage() {
        SIGNUP.assertInvalidEmail();
    }

    @And("I fill out the sign up form without first name")
    public void iFillOutTheSignUpFormWithoutFirstName() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter fake last name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("1988");
        SIGNUP.selectCurrentDate();
        // Remove the first name
        SIGNUP.clearFirstNameField();
    }

    @And("I fill out the sign up form without last name")
    public void iFillOutTheSignUpFormWithoutLastName() throws InterruptedException {
        // Enter fake email address
        GlobalTestData.GLOBAL_CUSTOMER_EMAIL = faker.internet().safeEmailAddress();
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter Last Name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("1988");
        SIGNUP.selectCurrentDate();
        // Remove Last Name
        SIGNUP.clearLastNameField();
    }

    @Then("I will verify error message under first name")
    public void iWillVerifyErrorMessageUnderFirstName() {
            SIGNUP.assertFirstNameErrorMessage();
        }

    @Then("I will verify error message under last name")
    public void iWillVerifyErrorMessageUnderLastName() {
        SIGNUP.assertLastNameErrorMessage();
    }

    @Given("I have brand new email address which never used in past")
    public void createBrandNewEmailUsing_emailFake() throws Exception {
        SIGNUP.generateRandomMailUsing_emailFake();
    }

    @And("I fill out the sign up form newly created email info")
    public void iFillOutTheSignUpFormNewlyCreatedEmailInfo() throws InterruptedException {
        // Enter fake email address
        SIGNUP.enterEmailInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_BRAND_NEW_EMAIL);
        // Enter password
        SIGNUP.enterPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        SIGNUP.enterConfirmPasswordInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_PASSWORD);
        // Enter fake first name
        GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME = faker.name().firstName();
        SIGNUP.enterFirstNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_FIRST_NAME);
        // Enter Last Name
        GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME = faker.name().lastName();
        SIGNUP.enterLastNameInSignUpPage(GlobalTestData.GLOBAL_CUSTOMER_LAST_NAME);
        // DOB
        SIGNUP.viewCalender();
        SIGNUP.selectYear("1988");
        SIGNUP.selectCurrentDate();
    }
    @Then ("I should be able to activate the account from Mailbox")
    public void activateAccount() throws InterruptedException {
        SIGNUP.activateAccount_emailFake();
    }

}
