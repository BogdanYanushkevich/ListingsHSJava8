package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneMail1 {
    String name;
    String phone;
    String email;

    NamePhoneMail1(String n, String p, String e) {
        name = n;
        email = e;
        phone = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamePhoneMail1 that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email);
    }
}

class NamePhone1 {

    String name;
    String phone;

    NamePhone1(String n, String p) {
        name = n;
        phone = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamePhone1 that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}


public class StreamDemo7 {
    public static void main(String[] args) {
        // List of names, phone numbers and email addresses

        ArrayList<NamePhoneMail1> myList = new ArrayList<>();
        myList.add(new NamePhoneMail1("Larry", "555-5555", "Larry@HerbShildt.com"));
        myList.add(new NamePhoneMail1("James", "555-4444", "James@HerbShildt.com"));
        NamePhoneMail1 c = new NamePhoneMail1("Mery", "555-3333", "Mery@HerbShildt.com");
        NamePhoneMail1 b = new NamePhoneMail1("Mery", "555-3333", "Mery@HerbShildt.com");
        myList.add(c);
        myList.add(c);
        // myList.add(new NamePhoneMail1("Mery", "555-3333", "Mery@HerbShildt.com"));


        System.out.println("Source elements from list myList: ");
        myList.forEach((a) -> System.out.println("Name: \t" + a.name + " " + "\t| Phone number: "
                + a.phone + " " + "\t| Email: " + a.email));

        System.out.println();


        // map to new data stream
        // only names and phone numbers

        Stream<NamePhone1> nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phone));

        // call the collect() method to compose list of type List of names and phone numbers

        List<NamePhone1> npList = nameAndPhone.toList();
        System.out.println("List of names and phone numbers: ");

        for (NamePhone1 e : npList) {
            System.out.println("Name: \t" + e.name + " " + "\t| Phone number: "
                    + e.phone);
        }

        // get a different display of names and phone numbers
        nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phone));

        // and now create a set of type Set, by calling the collect() method

        Set<NamePhone1> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("\nNames and phone numbers in a set of type Set:");

        for (NamePhone1 e : npSet) {
            System.out.println("Name: \t" + e.name + " " + "\t| Phone number: "
                    + e.phone);
        }
        nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phone));

        // LinkedList<NamePhone1> npList1 = nameAndPhone.collect(() -> new LinkedList<>(),
        //       (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));

        LinkedList<NamePhone1> npList1 = nameAndPhone.collect(LinkedList::new,
                LinkedList::add, LinkedList::addAll);

        System.out.println("\nLinked list: ");
        npList1.forEach((n) -> System.out.println("Name: \t" + n.name + " " + "\t| Phone number: "
                + n.phone));


        nameAndPhone = myList.stream().map((a) -> new NamePhone1(a.name, a.phone));

        HashSet<NamePhone1> npList2 = nameAndPhone.collect(HashSet::new,
                HashSet::add, HashSet::addAll);

        System.out.println("\nHash set: ");
        npList2.forEach((n) -> System.out.println("Name: \t" + n.name + " " + "\t| Phone number: "
                + n.phone));
    }
}
