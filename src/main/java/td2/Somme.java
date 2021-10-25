package td2;

@FunctionalInterface
public interface Somme<T> {
    T somme(T val1, T val2); // la generique fait qu'il y a pas de soucis du faite que ce soit un entier un double un long et une chaine de caratère
}
