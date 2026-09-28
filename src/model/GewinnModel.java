package model;

public class GewinnModel {

    public static final int MIN_ZAHL = 1;
    public static final int MAX_ZAHL = 9;
    private static final int START_PUNKTE = 30;

    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = START_PUNKTE;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * MAX_ZAHL) + MIN_ZAHL;
    }
}
