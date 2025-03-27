package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
     @Test
    public void loginPositiveTests(){
         clickOnLoginLink();
         fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
         clickOnLoginButton();
         Assert.assertTrue(isSignOutButtonPresent());

     }
     @Test
    public void loginNegativeWithoutEmailTests(){
         clickOnLoginLink();
         fillRegisterLoginForm(new User().setPassword("Nnoa12345$"));
         clickOnLoginButton();
         Assert.assertTrue(isAlertDisplayed());

     }

}
