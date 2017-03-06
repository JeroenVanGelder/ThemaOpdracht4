package nl.hu.to4.groep1.domain;

import java.util.Calendar;

public class AutoBuilder {
    private String kenteken;
    private Calendar laatsteOnderhoud;
    private String model;
    private boolean heeftSpoiler;
    private boolean heeftVerfbeurt;

    public AutoBuilder setKenteken(String kenteken) {
        this.kenteken = kenteken;
        return this;
    }

    public AutoBuilder setLaatsteOnderhoud(Calendar laatsteOnderhoud) {
        this.laatsteOnderhoud = laatsteOnderhoud;
        return this;
    }

    public AutoBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public AutoBuilder setHeeftSpoiler(boolean heeftSpoiler) {
        this.heeftSpoiler = heeftSpoiler;
        return this;
    }

    public AutoBuilder setHeeftVerfbeurt(boolean heeftVerfbeurt) {
        this.heeftVerfbeurt = heeftVerfbeurt;
        return this;
    }

    public Auto createAuto() {
        return new Auto(kenteken, laatsteOnderhoud);
    }
}