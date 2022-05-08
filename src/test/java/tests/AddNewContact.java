package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContact extends TestBase{


   /* @BeforeMethod
    public void preCondition() {
        if(!app.getUser().isLogged()){
            app.getUser().login(User.builder()
                    .email("noa@gmail.com")
                    .password("Nnoa123455$")
                    .build();
        }
    }*/


    @Test
    public void addNewContactSuccess(){


        int i = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println();

        Contact contact =  Contact.builder()
                .Name("Tina")
                .LastName("Tyan")
                .Phone("12345" + i)
                .email("tina" + i + "@gmail.com")
                .Address("Haifa")
                .description("friend")
                .build();

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();

        app.contact().pause(2000);
       // Assert.assertTrue(isContactPageDisplayed());



    }




}
