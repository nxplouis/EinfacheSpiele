package view;

import  model.GewinnModel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;



public class GewinnView extends JFrame {

    public static final String EINGABE = "eingabe";
    public static final String NOCH_EINMAL = "nochEinmal";

    private static final String TITEL = "Zahlen-Gewinnspiel";
    private static final String HINWEIS = "Tippe eine Zahl von 1 bis 9";
    private static final Font WERT_SCHRIFT = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    private static final Font ZAHL_SCHRIFT = new Font(Font.SANS_SERIF, Font.BOLD, 40);

    private final JLabel ergebnisLabel =  erzeugeWertLabel(HINWEIS);
    private final JLabel punkteLabel = erzeugeWertLabel("");
    private final JTextField eingabeFeld = erzeugeZahlFeld();
    private final JTextField computerFeld = erzeugeZahlFeld();
    private final JButton nochEinmalButton = new JButton("Noch einmal!");

    public GewinnView(GewinnModel model, ActionListener listener) {
        super(TITEL);

        punkteLabel.setText("Gesamtpunkte: " + model.getGesamtPunkte());
        computerFeld.setEditable(false);
        computerFeld.setBackground(Color.WHITE);

        eingabeFeld.setActionCommand(EINGABE);
        eingabeFeld.addActionListener(listener);
        nochEinmalButton.setActionCommand(NOCH_EINMAL);
        nochEinmalButton.addActionListener(listener);

        JPanel anzeigePanel = new JPanel(new GridLayout(3, 2, 8, 4));
        anzeigePanel.add(erzeugeTitelLabel("Rundenergebnis:"));
        anzeigePanel.add(erzeugeTitelLabel("Gesamtpunkte:"));
        anzeigePanel.add(ergebnisLabel);
        anzeigePanel.add(punkteLabel);
        anzeigePanel.add(erzeugeTitelLabel("Deine Zahl;"));
        anzeigePanel.add(erzeugeTitelLabel("Computer"));

        JPanel zahlenPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        zahlenPanel.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 6));
        zahlenPanel.add(eingabeFeld);
        zahlenPanel.add(computerFeld);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nochEinmalButton);

        add(anzeigePanel, BorderLayout.NORTH);
        add(anzeigePanel, BorderLayout.CENTER);
        add(anzeigePanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 360);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static JLabel erzeugeTitelLabel(String text) {
        return new JLabel(text, SwingConstants.CENTER);
    }

    private static JLabel erzeugeWertLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(WERT_SCHRIFT);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        return label;
    }

    private static JTextField erzeugeZahlFeld() {
        JTextField feld = new JTextField();
        feld.setFont(ZAHL_SCHRIFT);
        feld.setHorizontalAlignment(SwingConstants.CENTER);
        return feld;
    }
}
