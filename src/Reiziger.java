import java.util.Date;

public class Reiziger {
    private String voornaam;
    private String tussenvoegsel = "";
    private String achternaam;
    private String gbdatum;
    private String reizigerid;
    public Reiziger(){

    }

    public String getReizigerid() {
        return reizigerid;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getGbdatum() {
        return gbdatum;
    }

    public void setReizigerid(String reizigerid) {
        this.reizigerid = reizigerid;
    }

    public void setGbdatum(String gbdatum) {
        this.gbdatum = gbdatum;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
}
