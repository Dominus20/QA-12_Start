package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContact extends TestBase{


    @BeforeMethod
    public void preCondition() {
        if(!app.getUser().isLogged()){
            app.getUser().login(User.builder()
                    .email("noa@gmail.com")
                    .password("Nnoa12345$")
                    .build());
        }

    }


    @Test(invocationCount = 3)
    public void addNewContactSuccess(){

        int countStart = app.contact().countOfContacts();
        logger.info("The test 'Add new contact starts with count of contact---->"+countStart );

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

        int countEnd = app.contact().countOfContacts();
        logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);

        app.contact().pause(3000);
       // Assert.assertTrue(isContactPageDisplayed());

        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName())); //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));



    }

    @Test(dataProvider = "ContactValidData", dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccesNew(){
            int countStart = app.contact().countOfContacts();
            logger.info("The test 'Add new contact starts with count of contact---->"+countStart );

            int index= (int) (System.currentTimeMillis()/1000)%3600;

            Contact contact = Contact.builder()
                    .Name("Zoa")
                    .LastName("Snow")
                    .Phone("1234567" + index)
                    .email("zoa"+index+ "@gmail.com")
                    .Address("Haifa")
                    .description("friend")
                    .build();

            app.contact().openContactForm();
            app.contact().fillContactForm(contact);
            app.contact().saveContact();

            int countEnd = app.contact().countOfContacts();
            logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);

            app.contact().pause(2000);

            Assert.assertEquals(countEnd-countStart, 1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));

    }
    @Test (dataProvider = "addContactValidDataCSV",dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccessScv(Contact contact){

        int countStart = app.contact().countOfContacts();
        // logger.info("The test 'Add new contact' starts with count of contact---->"+countStart );
        //logger.info("The test 'Add new contact' starts with data ---->" +contact.toString());

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();

        int countEnd = app.contact().countOfContacts();
        //logger.info("The test 'Add new contact' ends with count of contact in the end --->"+countEnd);

        app.contact().pause(2000);
        Assert.assertEquals(countEnd-countStart,1);
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName())); //if list contact with name + phone
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));
    }




}
