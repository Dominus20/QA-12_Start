package manager;


import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitRegistrationForm() {
        click(By.xpath("//button[text()=' Registration']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //////?
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("a[href='/login']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }
    public void submitLogin() {
        click(By.tagName("button"));
    }

    public boolean isAlertPresent() {
       Alert alert =  new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
       if(alert==null){
           return false;
       }else{
           wd.switchTo().alert();
           String error = alert.getText();
           System.out.println(error);
           alert.accept();//ok
          // alert.dismiss();//cancel
           return true;
       }
    }
    public void login(User user){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();

//        clickLoginBtn();
//        type(By.xpath("//*[@placeholder='Email']"), user.getEmail());
//        type(By.xpath("//*[@placeholder='Password']"), user.getPassword());
//        click(By.xpath("//button[text()=' Login']"));
    }

    public boolean isWrongFormatPresent() {
        Alert alert =  new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
        if(alert==null){
            return false;
        }else {
            wd.switchTo().alert();
            String error = alert.getText();
            System.out.println(error);
            alert.accept();//ok
            // alert.dismiss();//cancel
             return error.contains("Wrong email or password format");
        }

    }
}
