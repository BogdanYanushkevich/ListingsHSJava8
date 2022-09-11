package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Use an instance method reference along with different objects

// Functional interface with method, taking two reference arguments and
// returning a boolean value

interface MyFunc1<T> {
    boolean func(T v1, T v2);
}

// Class for storing the maximum temperature for the day
class HighTemp {
    private int hTemp;

    HighTemp(int ht) {
        hTemp = ht;
    }

    //return boolean true if
//the calling object of type HighTemp contains the same temperature as the ht2 object
    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

// return boolean true if the caller of type HighTemp contains
//the temperature is lower than that of the ht2 object

    boolean lessThanTemp(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}


public class InstanceMethWithObjectRefDemo {

    // Method that returns the number of object instances
    // found according to the criteria specified by the
    // parameter of the functional interface MyFunc

    static <T> int counter(T[] vals, MyFunc1<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int count;

        // create an array of objects of type HighTemp

        HighTemp[] weekDaysHighs = {new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83),};
        // use the counter() method along with arrays of objects of type HighTemp.
        // Note that a reference to the sameTemp() instance method is passed as the second parameter.

        count = counter(weekDaysHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Days when the maximum" + "temperature was 89: " + count);

        // And now create and use with the given method another array of objects of type HighTemp

        HighTemp[] weekDaysHighs2 = {new HighTemp(32), new HighTemp(12),
                new HighTemp(24), new HighTemp(19),
                new HighTemp(18), new HighTemp(12),
                new HighTemp(-1), new HighTemp(13),};

        count = counter(weekDaysHighs2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println("Days when the maximum" + "temperature was 12: " + count);

        // Now use the lessThanTemp() method to find out how many
        // days the temperature was less than the given one

        count = counter(weekDaysHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Days when the maximum" + "temperature was less than 89: " + count);

        count = counter(weekDaysHighs2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println("Days when the maximum" + "temperature was less than 19: " + count);
    }
}


