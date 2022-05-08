package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Contact {

    String Name;
    String LastName;
    String Phone;
    String email;
    String Address;
    String description;


}
