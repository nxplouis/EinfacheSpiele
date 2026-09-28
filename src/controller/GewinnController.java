package controller;

import model.GewinnModel;
import view.GewinnView;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {

    private final GewinnModel model;
    private final GewinnView view;

    public GewinnController() {
        model = new GewinnModel();
        view = new GewinnView(model, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e == null || istSpielVorbei()) {
            return;
        }
        if (GewinnView.EINGABE.equals(e.getActionCommand())) {
            spieleRunde();
        } else if (GewinnView.NOCH_EINMAL.equals(e.getActionCommand())) {
            view.leereRunde();
        }
    }

    private boolean istSpielVorbei() {
        return model.hatGewonnen() || model.hatVerloren();
    }


    private void spieleRunde() {
        try {
            int spielerZahl = Integer.parseInt(view.getEingabe());
            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);
            view.zeigeRunde(model);
        } catch (IllegalArgumentException ex) {
            view.zeigeFehler("Ungültige Eingabe!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GewinnController::new);
    }
}
