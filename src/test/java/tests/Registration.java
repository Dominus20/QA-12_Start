package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Registration extends TestBase{


    @Test
    public void successRegistrationTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement element = wd.findElement(By.cssSelector("a[href='/login']"));
        element.click();

        List<WebElement> list = wd.findElements(By.tagName("input"));

        WebElement inputEmail = list.get(0);
        WebElement inputPassword = list.get(1);

        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("noa"+i+"@gmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Nnoa12345$");

        WebElement buttonRegistration = wd.findElement(By.xpath("//*[text()=' Registration']"));
        buttonRegistration.click();
    }


    @Test
    public void negativeRegistrationTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement element = wd.findElement(By.cssSelector("a[href='/login']"));
        element.click();

        List<WebElement> list = wd.findElements(By.tagName("input"));

        WebElement inputEmail = list.get(0);
        WebElement inputPassword = list.get(1);
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("noa"+i+"gmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Nnoa12345$");

        WebElement buttonRegistration = wd.findElement(By.xpath("//*[text()=' Registration']"));
        buttonRegistration.click();

    }




}