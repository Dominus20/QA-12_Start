package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {

   /* @Test
        public void successLoginTest(){
        WebElement element = wd.findElement(By.cssSelector("a[href='/login']"));

        List<WebElement> list = wd.findElements(By.tagName("a"));
        WebElement element2 = list.get(2);
        element.click();

        }*/

    @Test
    public void fillLoginFormTest() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        //   WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
        WebElement element = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        element.click();

        List<WebElement> list = wd.findElements(By.tagName("input"));
        WebElement inputEmail = list.get(0);
        WebElement inputPassword = list.get(0);
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("noa@gmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Nnoa12345$");

        WebElement buttonLogin = wd.findElement(By.tagName("button"));
        buttonLogin.click();

        // Assert.assertTrue(wd.findElement(By.xpath("//button[text()='Sign Out']")).size()>0);

    }

    @Test
    public void negativeLoginTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
        element.click();

        List<WebElement> list = wd.findElements(By.tagName("input"));

        WebElement inputEmail = list.get(0);
        WebElement inputPassword = list.get(0);

        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("noagmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Nnoa12345$");

        WebElement buttonLogin = wd.findElement(By.tagName("button"));
        buttonLogin.click();

    }


}

