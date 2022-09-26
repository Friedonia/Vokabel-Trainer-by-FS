import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddVok {
    private JFrame frame0;

    private JTextField deVokInput;
    private JTextField enVokInput;
    private JButton addButton;
    private JButton backButton;
    private JLabel titel;
    private JLabel deVokTitel;
    private JLabel EnVokTitel;
    private JPanel AddVok;

    public AddVok(){
        Vokab Vok = new Vokab();

        frame0  = new JFrame("Shit");
        frame0.setContentPane(AddVok);

        frame0.setSize(400, 300);
        frame0.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame0.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu vA = new menu();
                frame0.dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deVok = deVokInput.getText();
                String enVok = enVokInput.getText();
                if (!deVok.equals("") && !enVok.equals("")){
                    try {
                        Vok.add(deVok, enVok);
                        deVokInput.setText("");
                        enVokInput.setText("");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

    }


    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}


