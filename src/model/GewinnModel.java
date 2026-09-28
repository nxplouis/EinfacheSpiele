package model;

public class GewinnModel {

    public static final int MIN_ZAHL = 1;
    public static final int MAX_ZAHL = 9;
    private static final int START_PUNKTE = 30;
    private static final int PUNKTE_TREFFER =20;
    private static final int PUNKTE_KNAPP = 5;
    private static final int PUNKTE_DANEBEN = -10;

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

    public void berechneRunde(int spielerZahl) {
        if (spielerZahl < MIN_ZAHL || spielerZahl > MAX_ZAHL) {
            throw new IllegalArgumentException("Die Zahl muss zwischen " + MIN_ZAHL + " und " + MAX_ZAHL + " liegen.");
        }
        this.spielerZahl = spielerZahl;
        int abstand = Math.abs(spielerZahl - computerZahl);
        if (abstand == 0) {
            rundenErgebnis = PUNKTE_TREFFER;
        } else if (abstand == 1) {
            rundenErgebnis = PUNKTE_KNAPP;
        } else {
            rundenErgebnis = PUNKTE_DANEBEN;
        }
        gesamtPunkte += rundenErgebnis;
    }
}
