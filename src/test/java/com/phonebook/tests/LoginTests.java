package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
     @Test
    public void loginPositiveTests(){//click on Login link
         click(By.cssSelector("[href='/login']"));
         //enter email
         type(By.name("email"), "noa@gmail.com");
         //enter password
         type(By.name("password"), "Nnoa12345$");
         //click on Login button
         click(By.name("login"));
         //verify SignOut button is displayed
         Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

     }
}
