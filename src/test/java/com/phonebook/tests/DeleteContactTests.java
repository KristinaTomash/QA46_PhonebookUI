package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition(){
        //login
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "noa@gmail.com");
        type(By.name("password"), "Nnoa12345$");
        click(By.name("login"));

        //add
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"),"Karl");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        type(By.cssSelector("input:nth-child(4)"),"karl@gmail.com");
        type(By.cssSelector("input:nth-child(5)"),"Rishon");
        type(By.cssSelector("input:nth-child(6)"),"QA");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }
@Test
    public void deleteContactTest(){
        int sizeBefore= sizeOfContacts();
    //click on the card
    driver.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
    driver.findElement(By.xpath("//button[.='Remove']")).click();
    pause(1000);
    int sizeAfter = sizeOfContacts();
    Assert.assertEquals(sizeAfter,sizeBefore-1);
}

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //click on Remove button
    //verify contact is deleted(by size)
}
