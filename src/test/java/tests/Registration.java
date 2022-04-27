package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    //WebDriver wd;
  @BeforeMethod
    public void preCondition() {
        if (isLogged()) {
            //logout();

        }
    }

    public boolean isLogged() {
      return true;
    }

    @Test
    public void successRegisrationTest() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLoginRegistrationForm();
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));


    }


    @Test
    public void negativeRegistrationTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        openLoginRegistrationForm();//open LoginRegistration form
        fillLoginRegistrationForm(email, password);//fill LoginRegistration form
        submitLoginRegistrationForm();
        //click();
        //type();
//        WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
//        element.click();
//
//        List<WebElement> list= wd.findElements(By.tagName("input"));
//
//        WebElement inputEmail=list.get(0);
//        WebElement inputPassword=list.get(1);
//
//        inputEmail.click();
//        inputEmail.clear();
//        inputEmail.sendKeys("noa"+i+"gmail.com");
//
//        inputPassword.click();
//        inputPassword.clear();
//        inputPassword.sendKeys("Nnoa12345$");
//
//        WebElement buttonRegistration = wd.findElement(By.xpath("//*[text()=' tests.Registration']"));
//        buttonRegistration.click();
    }


}