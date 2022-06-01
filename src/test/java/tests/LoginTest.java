package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
//    @BeforeMethod
//    public void preCondition(){
//        if(app.getUser().isLogged()){
//            app.getUser().logout(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
//        }
//    }
   /* @Test
        public void successLoginTest(){
        WebElement element = wd.findElement(By.cssSelector("a[href='/login']"));
        List<WebElement> list = wd.findElements(By.tagName("a"));
        WebElement element2 = list.get(2);
        element.click();
        }*/

    //@Test(dataProvider = "fillLoginFormTest", dataProviderClass = MyDataProvider.class)
    @Test
    public void fillLoginFormTest() {
      //  int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//          User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        User user = User.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345$")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());

    }


    @Test
    public void negativeLoginTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "noa" + i + "gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email:"  + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();


        Assert.assertTrue(app.getUser().isWrongFormatPresent());

      //  Assert.assertFalse(app.getUser().isLogged());
    }
    @Test(dataProvider = "loginValidData", dataProviderClass = MyDataProvider.class)
    public void loginSuccessDataProvider(User user){

//
//        User user = User.builder()
//                .email("noa@gmail.com")
//                .password("Nnoa12345$")
//                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());


    }
    @Test
    public void loginSuccessTestModel() {


        User user = User.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345$")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());
    }

   @Test//(dataProvider = "loginValidData", dataProviderClass = MyDataProvider.class)
    public void loginSuccessTestModelDataProvider() {


        User user = User.builder()
                .email("noa@gmail.com")
                .password("Nnoa12345$")
                .build();

       app.getUser().openLoginRegistrationForm();
       app.getUser().fillLoginRegistrationForm(user);
       app.getUser().submitLogin();
       app.getUser().pause(1000);
       Assert.assertTrue(app.getUser().isLogged());
   }






}

