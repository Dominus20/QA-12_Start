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

    @Test
    public void successRegistrationTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistrationForm();
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());

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
        Assert.assertFalse(app.getUser().isLogged());



    }

}