package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




    public class LoginTest extends TestBase {

        @BeforeMethod
        public void preCondition() {
            if (app.getUser().isLogged()) {
                app.getUser().logout();

            }
        }


        // @Test
        //public void successLoginTest(){
        //WebElement element6 = wd.findElement(By.tagName("a"));
        //WebElement element4 = wd.findElement(By.cssSelector("a"));
        //WebElement element2 = wd.findElement(By.cssSelector("a[href='/login']"));
        //WebElement element3 = wd.findElement(By.cssSelector("[href='/login']"));
        //WebElement element1 = wd.findElement(By.id("root"));
        //WebElement element5 = wd.findElement(By.cssSelector("#root"));
        //WebElement elLink = wd.findElement(By.linkText("Login"));
        // WebElement elLink = wd.findElement(By.xpath("//*[text()='tests.Registration']"));
        // List<WebElement> list= wd.findElements(By.tagName("a"));
        // WebElement element=list.get(2);
        //element.click(); //click "LOGIN" button
        //element.clear();
        //element.sendKeys("Hello");//fill LoginRegistration form
        //}

        @Test
        public void fillLoginFormTest() {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String email = "noa"+i+"@gmail.com";
            String password = "Nnoa12345$";
            System.out.println("Email: " + email);

            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm(email, password);
            app.getUser().submitLogin();
        }



         /*   WebElement element = wd.findElement(By.xpath("//*[text()='LOGIN']"));
            element.click();
            List<WebElement> list = wd.findElements(By.tagName("input"));
            WebElement inputEmail = list.get(0);
            WebElement inputPassword = list.get(1);
            inputEmail.click();
            inputEmail.clear();
            inputEmail.sendKeys("noa@gmail.com");
            inputPassword.click();
            inputPassword.clear();
            inputPassword.sendKeys("Nnoa12345$");
            WebElement buttonLogin = app.getUser().findElement(By.tagName("button"));
            buttonLogin.click();*/

            // Assert.assertTrue(wd.findElement(By.xpath("//button[text()='Sign Out']")).size()>0);

       // }

        @Test
        public void negativeLoginTest() {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String email = "noa"+i+"gmail.com";
            String password = "Nnoa12345$";
            System.out.println("Email: " + email);

            app.getUser().openLoginRegistrationForm();//open LoginRegistration form
            app.getUser().fillLoginRegistrationForm(email, password);//fill LoginRegistration form
            app.getUser().submitLogin();
        }


    }

