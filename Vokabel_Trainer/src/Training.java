import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Training {
    private JFrame frame0;

    Vokab Vokabel = new Vokab();

    private boolean lang = true;

    private String engVok = "";
    private String deuVok = "";
    private int VokVal = 0;
    int vokNr = 0;
    int wert = 1;

    private JTextField VokabelEnt;
    private JButton testBtn;
    private JButton backBtn;
    private JLabel deVok;
    private JLabel zuLernen;
    private JButton switchBtn;
    private JLabel zuSchreiben;
    private JPanel TrainingG;
    private JButton hintBtn;
    private JLabel hintTx;

    public Training(){
        frame0  = new JFrame("Shit");
        frame0.setContentPane(TrainingG);

        frame0.setSize(400, 300);
        frame0.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame0.setVisible(true);

        showVok();
        hintBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wert = 0;
                if(lang){
                hintTx.setText(engVok);
                } else { hintTx.setText(deuVok);}
            }
        });
        testBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkVok();
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu vA = new menu();
                frame0.dispose();
            }
        });

        switchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lang == true){
                    deVok.setText("Englische Vokabel");
                    zuSchreiben.setText("Deutsche Vokabel");
                } else {
                    zuSchreiben.setText("Englische Vokabel");
                    deVok.setText("Deutsche Vokabel");
                }
                lang = !lang;
            }
        });
    }

    public void checkVok(){
        if(lang && engVok.equals(VokabelEnt.getText())){
            TrainingG.setBackground(Color.green);
            VokVal += wert;
            try {
                Vokabel.setVal( deuVok, engVok, VokVal);
            } catch (IOException e) {
                e.printStackTrace();
            }
            showVok();
        } else if (lang && !engVok.equals(VokabelEnt.getText())){
            TrainingG.setBackground(Color.red);
            VokVal -= wert;
            try {
                Vokabel.setVal( deuVok, engVok, VokVal);
            } catch (IOException e) {
                e.printStackTrace();
            }
            showVok();
        } else if (!lang && deuVok.equals(VokabelEnt.getText())){
            TrainingG.setBackground(Color.green);
            VokVal += wert;
            try {
                Vokabel.setVal( deuVok, engVok, VokVal);
            } catch (IOException e) {
                e.printStackTrace();
            }
            showVok();
        } else if (!lang && !deuVok.equals(VokabelEnt.getText())){
            TrainingG.setBackground(Color.red);
            VokVal -= wert;
            try {
                Vokabel.setVal( deuVok, engVok, VokVal);
            } catch (IOException e) {
                e.printStackTrace();
            }
            showVok();
        }

    }
    public void showVok(){
        vokNr = Vokabel.randomVok();
        engVok = Vokabel.getVokEN(vokNr);
        deuVok = Vokabel.getVokDE(vokNr);
        VokVal = Vokabel.getVokValue(vokNr);
        if (lang){
            zuLernen.setText(deuVok);
        } else {
            zuLernen.setText(engVok);
        }
        wert = 1;
        hintTx.setText("");
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}


