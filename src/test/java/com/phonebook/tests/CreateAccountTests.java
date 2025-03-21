package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


    @Test
    public void newUserRegistrationPositiveTest(){
        clickOnLoginLink();
        fillRegisterLoginForm("test@test.com", "");
        clickOnRegistrationButton();
        //verify SignOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(String mail, String password) {
        type(By.name("email"), mail);
        type(By.name("password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillRegisterLoginForm("", "");
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}
