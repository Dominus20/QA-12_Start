package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();


  // WebDriver wd;

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }


}