package nl.hu.to4.groep1.domain;

public class Adres {
    private final String straatnaam;
    private final int huisnummer;
    private final String woonplaats;
    private final String postcode;

    public Adres(String straatnaam, int huisnummer, String woonplaats, String postcode) {
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getPostcode() {
        return postcode;
    }
}
