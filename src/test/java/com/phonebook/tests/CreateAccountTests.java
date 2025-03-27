package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}
