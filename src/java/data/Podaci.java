package data;

import beans.Oglas;
import beans.Korisnik;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Podaci {
    
    public static Map<String, Korisnik> mapaKorisnici = new HashMap<String, Korisnik>();
    public static List<Oglas> listaOglasa = new ArrayList<Oglas>();
    
    static {
        mapaKorisnici.put("mmarko", new Korisnik("mmarko", "pass123", "Marko", "Markovic", "marko.markovic@ict.edu.rs"));
        mapaKorisnici.put("ppetar", new Korisnik("ppetar", "pass123", "Petar", "Petrovic","ppetar@ict.edu.rs"));
        mapaKorisnici.put("pnikola", new Korisnik("pnikola", "pass123", "Nikola", "Petrovic","p.nikola@ict.edu.rs"));
        mapaKorisnici.put("pana", new Korisnik("pana", "pass123", "Ana", "Popadic","p.ana@ict.edu.rs"));
        mapaKorisnici.put("ijelena", new Korisnik("ijelena", "pass123", "Jelena", "Ilic","ijelena@ict.edu.rs"));
        listaOglasa.add(new Oglas("mmarko", "Zvezdara", "Garsonjera", 33, 35000, "+381641234567"));
        listaOglasa.add(new Oglas("ppetar", "Palilula", "Dvosoban stan", 63, 70000, "+38162445566 "));
        listaOglasa.add(new Oglas("ijelena", "Vidikovac", "Trosoban stan", 95, 90000, "+381611113344"));
        listaOglasa.add(new Oglas("pnikola", "Novi Beograd", "Jednosoban stan", 42, 55000, "+381113343343"));

    }
    
    public static Korisnik getKorisnik(String korime) {
        return mapaKorisnici.get(korime);
    }
    
    public static boolean postojiKorisnik(String korime, String lozinka) {
        Korisnik k = mapaKorisnici.get(korime);
        return (k != null) && k.getLozinka().equals(lozinka);
    }
}
