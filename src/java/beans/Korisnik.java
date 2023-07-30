package beans;

/**
 *
 * @author Stefan
 */
public class Korisnik {
    
    private String username;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    
    public Korisnik() {
        
    }
    
    public Korisnik(String username, String lozinka, String ime, String prezime, String email) {
        this.username = username;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
