package td2;

import java.util.ArrayList;
import java.util.List;

public class App {
    //Question 1.1
    public static void q1a() {
        //Integer
        Somme<Integer> sumInteger = (val1, val2) -> val1 + val2;
        System.out.println("La sum des Integer est :" + sumInteger.somme(1, 2));
        //pour les double
        Somme<Double> sumDouble = (val1, val2) -> val1 + val2;
        System.out.println("La sum des Double est :" + sumDouble.somme(2.1, 1.5));
        //pour les long
        Somme<Long> sumLong = (val1, val2) -> val1 + val2;
        System.out.println("La sum des Long est :" + sumLong.somme(12345L, 12345L));
        //pour les String
        Somme<String> sumString = (val1, val2) -> val1 + val2;
        System.out.println("La sum des Long est :" + sumString.somme("bob", "bjr"));

    }
    //Question 1.2

    public static <ToString> void q1b() {
        List<String> liste = List.of("bjr", "hello");
        // List<String> List = new ArrayList<>();
        // List.add("a");

        ToString <List<String>> liste = object -> {
            String liste = "";
            for (String val : liste) {
                liste = liste + val + ", ";
            }
            return liste;
        };

    }

    public static void main(String[] args) {
        System.out.println("-------Q1.1--------");
        q1a();
        //q1b
    }
}