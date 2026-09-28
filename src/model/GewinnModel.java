package model;

public class GewinnModel {

    private static final int START_PUNKTE = 30;

    private int gesamtPunkte;
    private int spielerZahl;
    private int comuterZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = START_PUNKTE;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComuterZahl() {
        return comuterZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
}
