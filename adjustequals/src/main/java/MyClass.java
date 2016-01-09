import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyClass {




    public static void main(String args[]) throws SQLException, NamingException {
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
        List<Obywatel> l = new ArrayList<Obywatel>();
        l.add(new Obywatel("Jan","Kowalski","12345567"));
        l.add(new Obywatel("Krzysztof","Niemy","123434535"));
        l.add(new Obywatel("Wojciech", "Awsome", "1234556724"));
        l.add(new Obywatel("Miachal", "Coder", "1234556722"));
        l.add(new Obywatel("Marcin", "Podlasin", "1234556778"));
        Obywatel oby = l.get(3);
        Set<Obywatel> s = new HashSet<Obywatel>();
        s.add(new Obywatel("Jan","Kowalski","12345567"));
        s.add(new Obywatel("Krzysztof", "Niemy", "123434535"));
        s.add(new Obywatel("Wojciech", "Awsome", "1234556724"));
        s.add(new Obywatel("Miachal", "Coder", "1234556722"));
        s.add(new Obywatel("Marcin", "Podlasin", "1234556778"));
        for (Iterator<Obywatel> it = s.iterator(); it.hasNext(); ) {
            Obywatel f = it.next();
            if (f.equals(new Obywatel("", "", "1234556778")))
                System.out.println("Obywatel found");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/webappdb";
            Connection c = DriverManager.getConnection(url, "root", "root");
//            PreparedStatement st = c.prepareStatement("SELECT * FROM user_info");
//            System.out.println(st.toString());
//            PreparedStatement st = c.prepareStatement("insert into user_info values(?,?,?)");
//            st.setString(1, "syta");
//            st.setString(2, "zdrowa");
//            st.setString(3, "kupa");
//            st.execute();
//            st.close();
            java.sql.Statement statek = c.createStatement();
            ResultSet srs = statek.executeQuery("SELECT * FROM user_info");
            while(srs.next()){
                String name = srs.getString("name");
                String user_name = srs.getString("user_name");
                String user_pass = srs.getString("user_pass");
                System.out.println(name+" "+user_name+" "+ user_pass);
            }

//            System.out.println(srs);
            srs.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Context ctx = new InitialContext();
//        DataSource ds = ctx.lookup("")
        try {


        }
         catch (Exception e) {
            e.printStackTrace();
        }

    }

}
