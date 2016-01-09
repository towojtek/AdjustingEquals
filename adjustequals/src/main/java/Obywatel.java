/**
 * Created by Wojtek on 2016-01-07.
 */
class Obywatel {

    public final String imie;
    public final String nazwisko;
    public final String pesel;

    public Obywatel(String i, String n, String p) {
        imie = i;
        nazwisko = n;
        pesel = p;
    }
//    @Override
//    public  int hashCode() {
//        return hashCode();
//    }



//    @Override
//    public boolean equals(Object obj) {
//        return string.equals(((Foo) obj).string);
//    }

    @Override
    public int hashCode() {
        return pesel.hashCode();
    }
//
//    @Override
//    public String toString() {
//        return ("Imie : "+ imie + " Nazwisko : "+ nazwisko + " Pesel : "+pesel);
//    }
//
    @Override
    public boolean equals(Object o) {
//        System.out.println(((Obywatel)o).toString());
//        System.out.println(super.toString());
//        System.out.println((((Obywatel) o).imie).equals(imie));

        if (!(o instanceof Obywatel) || !((Obywatel) o).pesel.equals(pesel)) {
            return false;
        }
        return true;
    }
}