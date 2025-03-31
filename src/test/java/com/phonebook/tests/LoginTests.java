package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

    }
     @Test(priority = 1)
    public void loginPositiveTests(){
         app.getUser().clickOnLoginLink();
         app.getUser().fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
         app.getUser().clickOnLoginButton();
         Assert.assertTrue(app.getUser().isSignOutButtonPresent());

     }
     @Test(priority = 2)
    public void loginNegativeWithoutEmailTests(){
         app.getUser().clickOnLoginLink();
         app.getUser().fillRegisterLoginForm(new User().setPassword("Nnoa12345$"));
         app.getUser().clickOnLoginButton();
         Assert.assertTrue(app.getUser().isAlertDisplayed());

     }

}
