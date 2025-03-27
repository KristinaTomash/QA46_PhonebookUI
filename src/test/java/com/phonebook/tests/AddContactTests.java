package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

    clickOnAddLink();
    fillContactForm(new Contact().setName("Karl")
            .setLastName("Adam")
            .setPhone("1234567890")
            .setEmail("karl@gmail.com")
            .setAddress("Rishon")
            .setDescription("QA"));
    clickOnSaveButton();
    Assert.assertTrue(isContactAdded("Karl"));
}

    @AfterMethod
    public void postCondition(){
    deleteContact();
}

}




