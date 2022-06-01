package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> fillLoginFormTest() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider//add string
    public Iterator<Object[]> RegValidData() {
        List<Object[]> list = new ArrayList<>();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        list.add(new Object[]{"noa" + i + "@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa" + i + "@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa" + i + "@gmail.com", "Nnoa12345$"});
        return list.iterator();
    }

    @DataProvider//add string
    public Iterator<Object[]> ContactValidData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Hay", "Low", "1234567890", "hay@gmail.com", "Haifa", "Mother"});
        list.add(new Object[]{"Hay", "Low", "1234567890", "hay@gmail.com", "Haifa", "Mother"});
        list.add(new Object[]{"Hay", "Low", "1234567890", "hay@gmail.com", "Haifa", "Mother"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginValidDataModel() {
        List<Object[]> list = new ArrayList<>();
        // list.add(new Object[]{User.builder().email("noa@gmail.com").password("Nnoa12345$") MAYBE .build});
        list.add(new Object[]{User.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{User.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{User.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
//        list.add(new Object[]{new User().withEmail("").withPassword("")});
//        list.add(new Object[]{new User().withEmail("").withPassword("")});
//        list.add(new Object[]{new User().withEmail("").withPassword("")});

        /*//list.add(new Object[]{Contact.builder().name("").lastName("").build()}); example for lombock
         */
        return list.iterator();
    }

    @DataProvider //read from file for Contact
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/contacts.csv")));
        String line = reader.readLine();//Mona,Dow,3214598765,mona@gmail.com,Haifa,friend

        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .Name(split[0])
                    .LastName(split[1])
                    .description(split[5])
                    .Address(split[4])
                    .email(split[3])
                    .Phone(split[2])
                    .build()});
            line = reader.readLine();
        }


        return list.iterator();
    }


}

