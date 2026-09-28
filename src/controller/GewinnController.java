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
        if (GewinnView.EINGABE.equals(e.getActionCommand())) {
            spieleRunde();
        }
    }

    private void spieleRunde() {
        int spielerZahl = Integer.parseInt(view.getEingabe());
        model.berechneComputerZahl();
        model.berechneRunde(spielerZahl);
        view.zeigeRunde(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GewinnController::new);
    }
}
