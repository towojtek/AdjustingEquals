import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyClass {




    public static void main(String args[]){
        List lista = new ArrayList();
        Map mapa = new HashMap();
        lista.add(new Obywatel("Jan","Kowalski","12345567"));
        lista.add(new Obywatel("Krzysztof","Niemy","123434535"));
        lista.add(new Obywatel("Wojciech","Awsome","1234556724"));
        lista.add(new Obywatel("Miachal","Coder","1234556722"));
        lista.add(new Obywatel("Marcin","Podlasin","1234556778"));

        System.out.println("Trzeci obywatel : " + lista.get(2));
        System.out.println("Usuwam obywatela 3 "+ lista.remove(2));
        System.out.println("Trzeci obywatel : " + lista.get(2));
        System.out.println(lista.size());
        System.out.println("Podmieniam obywatela 3");
        lista.add(2, new Obywatel("Zybi", "Sztan", "123455"));
        System.out.println("Wypisuje wszystkich obywateli");
        for (Object o:lista) {
            System.out.println("obywatel: " + o);
        }
        int pozycja = lista.indexOf(new Obywatel("","","1234556778"));
        System.out.println("odnaleziona pozycja " + (pozycja));
        for(Object o: lista){
            mapa.put(((Obywatel)o).pesel,o);
        }
        System.out.println("Obywatel z peselem 123455 :"+ mapa.get("123455"));
        Set klucze = mapa.keySet();
        for (Object klucz:klucze
             ) {System.out.println(klucz);

        }
    }

}
