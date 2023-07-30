package controller;

import beans.Korisnik;
import beans.Oglas;
import data.Podaci;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Stefan
 */
@Named(value = "controler")
@SessionScoped
public class Controler implements Serializable {
    
    private String username;
    private String lozinka;
    private String poruka;
    
    private List<Oglas> oglasi = Podaci.listaOglasa;
    private Oglas oglas = new Oglas();
    
    private Korisnik loggedKorisnik = new Korisnik();
    
    public Controler() {
        
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

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public List<Oglas> getOglasi() {
        return oglasi;
    }

    public void setOglasi(List<Oglas> oglasi) {
        this.oglasi = oglasi;
    }

    public Oglas getOglas() {
        return oglas;
    }

    public void setOglas(Oglas oglas) {
        this.oglas = oglas;
    }

    public Korisnik getLoggedKorisnik() {
        return loggedKorisnik;
    }

    public void setLoggedKorisnik(Korisnik loggedKorisnik) {
        this.loggedKorisnik = loggedKorisnik;
    }
    
    public String signOut() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
    
    public String signIn() {
        if(Podaci.postojiKorisnik(this.username, this.lozinka)) {
            Collections.sort(oglasi);
            this.loggedKorisnik.setUsername(this.getUsername());
            
            return "stanovi";
        }
        this.poruka = "Korisničko ime ili lozinka je neispravna!";
        return null;
    }
    
    public String goToAddPage() {
        for(Oglas o : this.oglasi) {
            if(o.getUser().getUsername().equals(this.loggedKorisnik.getUsername())) {
                this.poruka = "Ne mozete dodati vise od jednog oglasa!";
                return null;
            }
        }
        return "dodaj";
    }
    
    public String addNewOglas() {
        this.oglas.setUser(this.loggedKorisnik);
        this.oglasi.add(new Oglas(this.oglas));
        Collections.sort(oglasi);
        this.poruka = "";
        return "stanovi";
    }
    
    public String deleteOglas() {
        for(Oglas o : this.oglasi) {
            if(o.getUser().getUsername().equals(this.loggedKorisnik.getUsername())) {
                this.oglasi.remove(o);
                this.poruka = "Vaš oglas je obrisan!";
                return null;
            }
        }
        this.poruka = "Nemate trenutno nijedan oglas!";
        return null;
    }
    
}
