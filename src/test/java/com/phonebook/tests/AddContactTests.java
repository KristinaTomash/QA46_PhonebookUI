package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

    app.getContact().clickOnAddLink();
    app.getContact().fillContactForm(new Contact().setName("Karl")
            .setLastName("Adam")
            .setPhone("1234567890")
            .setEmail("karl@gmail.com")
            .setAddress("Rishon")
            .setDescription("QA"));
    app.getContact().clickOnSaveButton();
    Assert.assertTrue(app.getContact().isContactAdded("Karl"));
}

    @AfterMethod
    public void postCondition(){
    app.getContact().deleteContact();
}

}




