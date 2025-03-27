package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("karl@gmail.com")
                .setAddress("Rishon")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
    }
@Test
    public void deleteContactTest(){int sizeBefore= app.getContact().sizeOfContacts();
    app.getContact().deleteContact();
    app.getContact().pause(1000);
    int sizeAfter = app.getContact().sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore-1);
}


}
