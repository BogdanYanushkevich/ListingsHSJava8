package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneMail {
    String name;
    String phone;
    String email;

    NamePhoneMail(String n, String p, String e) {
        name = n;
        email = e;
        phone = p;
    }
}

class NamePhone {

    String name;
    String phone;

    NamePhone(String n, String p) {
        name = n;
        phone = p;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {

        // List of names, phone numbers and email addresses

        ArrayList<NamePhoneMail> myList = new ArrayList<>();
        myList.add(new NamePhoneMail("Larry", "555-5555", "Larry@HerbShildt.com"));
        myList.add(new NamePhoneMail("James", "555-4444", "James@HerbShildt.com"));
        myList.add(new NamePhoneMail("Mery", "555-3333", "Mery@HerbShildt.com"));

        System.out.println("Source elements from list myList: ");
        myList.forEach((a) -> System.out.println("Name: \t" + a.name + " " + "\t| Phone number: "
                + a.phone + " " + "\t| Email: " + a.email));

        System.out.println();


        // map to new data stream
        // only names and phone numbers

        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phone));
        System.out.println("List of names and phone numbers: ");
        nameAndPhone.forEach((a) -> System.out.println("Name: \t" + a.name + " " + "\t| Phone number: "
                + a.phone));

        System.out.println();
        nameAndPhone = myList.stream().filter((a) -> a.name.equals("James")).map((a)
                -> new NamePhone(a.name, a.phone));
        System.out.println("Record with James: ");
        nameAndPhone.forEach((a) -> System.out.println("Name: \t" + a.name + " " + "\t| Phone number: "
                + a.phone));
    }
}
