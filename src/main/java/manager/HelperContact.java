package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void openContactForm() {
     //   click(By.cssSelector("[href='/add']"));
        click(By.xpath("//a[normalize-space()='ADD']"));
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

//  //  public void login() {
//        click(By.xpath("//button[text()='Sign Out']"));
//    }

    public boolean isContactCreateByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }
        return false;
    }



    public boolean isContactCreateByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }
    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();//not count
    }

    public void removeOneContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public void removeAllContacts() {

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
            removeOneContactCount();
        }
    }
    public int removeOneContactCount(){
        int countBefore = countOfContacts();
        //logger.info("Before remove 'One contact tests' contact was --->"+countBefore);
        if(!isContactsListIsEmpty()) {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
//           logger.info("The removed number was----> " +phone);
            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(500);
        }
        int countAfter=countOfContacts();
//        //logger.info("After removing one contact the count is --->"+countAfter);
        return countAfter-countBefore;
    }

    private boolean isContactsListIsEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM h3")).isEmpty();
    }

    public void providerOfContacts(){
        if(countOfContacts()<3){
            int index=(int) (System.currentTimeMillis()/1000)%3600;
            for(int i=0; i<3;i++){

                Contact contact = Contact.builder().Name("Zoa")
                        .LastName("Snow")
                        .Phone("1212" +i+ index)
                        .email("zoa"+i+index+"@gmail.com")
                        .Address("Haifa")
                        .description("Friend").build();
                openContactForm();
                fillContactForm(contact);
                saveContact();
                pause(1000);
            }
            //Contact contact = Contact.builder().Name().LastName().build();
        }
    }



}



