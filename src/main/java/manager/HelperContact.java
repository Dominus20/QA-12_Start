package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }


    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2 button"));
        //click(By.xpath("//b"));
        pause(3000);
    }

    public void login() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

//    public  void isContactPageDisplayed() {
//    }
}

