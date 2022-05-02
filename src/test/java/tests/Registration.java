package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

public class Registration extends TestBase{


    @Test
    public void successRegistrationTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa"+i+"@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email" + email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLoginRegistrationForm();
      //  click();
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));


//        WebElement element = wd.findElement(By.cssSelector("a[href='/login']"));
//        element.click();
//
//        List<WebElement> list = wd.findElements(By.tagName("input"));
//
//        WebElement inputEmail = list.get(0);
//        WebElement inputPassword = list.get(1);
//
//        WebElement buttonRegistration = wd.findElement(By.xpath("//*[text()=' Registration']"));
//        buttonRegistration.click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }


    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void openLoginRegistrationForm() {
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void type(By locator, String text) {
        if(text != null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }


    }

    public void submitLoginRegistrationForm() {
        click(By.xpath("//button[text()='Sign Out']"));
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