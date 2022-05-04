package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

public class Registration extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }

    }
//    public void logout() {
//        click(By.xpath("//button[text()='Sign Out']"));
//    }
//
//    public boolean isLogged() {
//        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
//    }
//

    @Test
    public void successRegistrationTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email" + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistrationForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[text()='Sign Out']")));

    }



    @Test
    public void negativeRegistrationTest(){

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa"+i+"gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email" + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistrationForm();
        //  click();
//        WebElement element = wd.findElement(By.cssSelector("a[href='/login']"));
//        element.click();
//
//        List<WebElement> list = wd.findElements(By.tagName("input"));
//
//        WebElement inputEmail = list.get(0);
//        WebElement inputPassword = list.get(1);
//        inputEmail.click();
//        inputEmail.clear();
//        inputEmail.sendKeys("noa"+i+"gmail.com");
//
//        inputPassword.click();
//        inputPassword.clear();
//        inputPassword.sendKeys("Nnoa12345$");
//
//        WebElement buttonRegistration = wd.findElement(By.xpath("//*[text()=' Registration']"));
//        buttonRegistration.click();

    }

}