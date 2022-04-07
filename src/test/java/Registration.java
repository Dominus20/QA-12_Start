
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Registration {

        WebDriver wd;

        @BeforeMethod
        public void init(){
                wd = new ChromeDriver();
                wd.manage().window().maximize();
                wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home\n");
                wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }


        @Test

        public void successRegistrationTest(){
            //url
            // click "LOGIN" button
            // open LoginRegistration form
            // fill LoginRegistration form
            // submit
            //Logout
                WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
                element.click();

                List<WebElement> list = wd.findElements(By.tagName("input"));

                WebElement inputEmail = list.get(0);
                WebElement inputPassword = list.get(1);


                inputEmail.click();// click "LOGIN" button
                inputEmail.clear();
                inputEmail.sendKeys("noar@gmail.com");

                inputPassword.click();
                inputPassword.clear();
                inputPassword.sendKeys("Nnoar12345$");

                //WebElement buttonRegistration = wd.findElement(By.name("Registration"));
                //buttonRegistration.click();
        }

        @Test

        public void negativeRegistrationTest(){
                WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
                element.click();

                List<WebElement> list = wd.findElements(By.tagName("input"));

                WebElement inputEmail = list.get(0);
                WebElement inputPassword = list.get(1);


                inputEmail.click();// click "LOGIN" button
                inputEmail.clear();
                inputEmail.sendKeys("noas@gmail.com");

                inputPassword.click();
                inputPassword.clear();
                inputPassword.sendKeys("Nnoas12345$");

                WebElement buttonRegistration = wd.findElement(By.cssSelector("div[class] button:last-child"));
              //OR  //WebElement buttonRegistration = wd.findElement(By.cssSelector(".login_login__3EHKB button:last-child"));
                buttonRegistration.click();

                //url
            // click "LOGIN" button
            // open LoginRegistration form
            // fill LoginRegistration form
            //wrong email
            // submit
            //Logout
        }

        @AfterMethod
        public void tearDown(){
                wd.quit();

        }





}
