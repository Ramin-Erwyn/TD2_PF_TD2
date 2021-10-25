package td2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    /* public static <ToString> void q1b() {
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

    }*/

    public static void question2() {
        Predicate<Integer> tailleTropPetit = taille -> taille < 100;
        Predicate<Integer> tailleTropGrand = taille -> taille > 200;
        Predicate<Integer> mauvaiseTaille = tailleTropPetit.or(tailleTropGrand);
        Predicate<Integer> tailleCorrecte = mauvaiseTaille.negate();
        Predicate<Double> poidsTropLourd = poids -> poids > 150.0;
        Predicate<Double> poidsCorrecte = poidsTropLourd.negate();
        Predicate<Paire<Integer, Double>> accesAutorise = acces -> tailleCorrecte.test(acces.fst) && poidsCorrecte.test(acces.snd);

        // refaire avec Paire

        Predicate<Paire<Integer,Double>> tropPetitPaire = taille -> taille.fst < 100; // int ou double
        Predicate<Paire<Integer,Double>> tropGrandPaire = taille -> taille.fst > 200; // int ou double
        Predicate<Paire<Integer,Double>> mauvaiseTaillePaire = tropPetitPaire.or(tropGrandPaire); // int ou double
        Predicate<Paire<Integer,Double>> TailleCorrectePaire = mauvaiseTaillePaire.negate(); // int ou double
        Predicate<Paire<Integer,Double>> tropLourdPaire = x -> x.snd > 150.0; // int ou double
        Predicate<Paire<Integer,Double>> PoidsCorrectePaire = tropLourdPaire.negate(); // int ou double
        Predicate<Paire<Integer,Double>> accesAutoriséPaire = TailleCorrectePaire.and(PoidsCorrectePaire); // int ou double

       // POUR LES TESTS
       // (210,-) -> c'est pas bon
       // (90,-) -> c'est pas bon
       // (-,160) -> c'est pas bon
       // (150, 100) -> c'est bon
        // Mais on remarque c'est ça fait un polyhèdre (200,150) (100,150) sont les bornes

    }
    public static void main(String[] args) {
        System.out.println("-------Q1.1--------");
        q1a();
        //q1b
    }
}