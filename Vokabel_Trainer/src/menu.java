import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    private JFrame frame0;

    private JLabel wilkommen1;
    private JLabel wilkommen2;
    private JButton addVokabelButton;
    private JButton practiceButton;
    private JButton logoutBut;
    private JLabel option;
    private JPanel MenuG;
    private JButton delBtn;

    public menu(){
        frame0  = new JFrame("Shit");
        frame0.setContentPane(MenuG);

        frame0.setSize(400, 300);
        frame0.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame0.setVisible(true);


        logoutBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame vA = new MainFrame();
                frame0.dispose();
            }
        });
        practiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Training vA = new Training();
                frame0.dispose();
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VokListe vA = new VokListe();
                frame0.dispose();
            }
        });
        addVokabelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddVok vA = new AddVok();
                frame0.dispose();
            }
        });
    }


    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}

