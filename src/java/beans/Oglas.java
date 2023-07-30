package beans;

/**
 *
 * @author Stefan
 */
public class Oglas implements Comparable<Oglas> {
    
    private Korisnik user = new Korisnik();
    private String opstina;
    private String tip;
    private int povrsina;
    private int cena;
    private String kontakt = "+381";
    private String[] opstine = {"Zvezadara","Karaburma","Vračar","Palilula","Novi Beograd","Vidikovac"};
    
    public Oglas() {
        
    }
    
    public Oglas(String userUsername, String opstina, String tip, int povrsina, int cena, String kontakt) {
        this.user.setUsername(userUsername);
        this.opstina = opstina;
        this.tip = tip;
        this.povrsina = povrsina;
        this.cena = cena;
        this.kontakt = kontakt;
    }
    
    public Oglas(Oglas o) {
        this.user = o.user;
        this.opstina = o.opstina;
        this.tip = o.tip;
        this.povrsina = o.povrsina;
        this.cena = o.cena;
        this.kontakt = o.kontakt;
    }

    public Korisnik getUser() {
        return user;
    }

    public void setUser(Korisnik user) {
        this.user = user;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(int povrsina) {
        this.povrsina = povrsina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String[] getOpstine() {
        return opstine;
    }

    public void setOpstine(String[] opstine) {
        this.opstine = opstine;
    }
    
    @Override
    public int compareTo(Oglas o) {
        if(o.cena - this.cena == 0) {
            return o.user.getUsername().compareTo(this.user.getUsername());
        }
        return o.cena - this.cena;
    }
}
