package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact().setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("karl@gmail.com")
                .setAddress("Rishon")
                .setDescription("QA"));
        clickOnSaveButton();
    }
@Test
    public void deleteContactTest(){int sizeBefore= sizeOfContacts();
    deleteContact();
    pause(1000);
    int sizeAfter = sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore-1);
}


}
