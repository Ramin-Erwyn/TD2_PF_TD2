package td2;

import td2.universite.Annee;
import td2.universite.Etudiant;
import td2.universite.Matiere;
import td2.universite.UE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

 //EXO 3

    public static void question3(){
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

    }
    //boucle for
    public void afficheSi(String entete, Predicate<Etudiant> rtr, Annee a) {

        for (Etudiant e : a.etudiants()){
            if (rtr.test(e)){
                System.out.println(e);
            }
        }
        System.out.println(String.format(" %s\n", entete));
    }
    // utilisation du foreach
    public void afficheSi1(String entete, Predicate<Etudiant> T, Annee a) {
        System.out.println(String.format(" %s\n", entete));
        a.etudiants().forEach(e -> {
            if (T.test(e)){
                System.out.println(e);
            }

        });
    }
    public  final Predicate<Etudiant> aDEF = e -> {
        for (UE ue : e.annee().ues()) {
            //...
        }
        return false;
    };
    public static void main(String[] args) {
        System.out.println("-------Q1.1--------");
        q1a();
        //q1b
        question2();
        question3();


    }
}