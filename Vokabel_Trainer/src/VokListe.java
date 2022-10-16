import javax.swing.*;
import java.io.IOException;

public class VokListe {
    private JTextField deInput;
    private JTextField enInput;
    private JButton deleteButton;
    private JButton menuButton;
    private JPanel VokList;
    private JButton prevBtn;
    private JButton nextBtn;
    private JButton saveBtn;
    private final JFrame frame0;
    int current = 0;
    Vokab Vok = new Vokab();

    int vokCount = Vok.getCount();


    public VokListe(){


        frame0  = new JFrame("Shit");
        frame0.setContentPane(VokList);

        frame0.setSize(400, 300);
        frame0.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame0.pack();
        frame0.setVisible(true);


        deInput.setText(Vok.getVokDE(current));
        enInput.setText(Vok.getVokEN(current));

        saveBtn.addActionListener(e -> {
            if( !deInput.getText().equals(Vok.getVokDE(current)) || !enInput.getText().equals(Vok.getVokEN(current))){
                try {
                    Vok.setVok(Vok.getVokDE(current), Vok.getVokEN(current), deInput.getText(), enInput.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        prevBtn.addActionListener(e -> {
            if (0 == current){
                current = vokCount-1;
            } else {
                current -= 1;
            }
            deInput.setText(Vok.getVokDE(current));
            enInput.setText(Vok.getVokEN(current));
        });

        nextBtn.addActionListener(e -> {
            if (current == vokCount-1){
                current = 0;
            } else {
                current += 1;
            }
            deInput.setText(Vok.getVokDE(current));
            enInput.setText(Vok.getVokEN(current));
        });



        menuButton.addActionListener(e -> {
            new menu();
            frame0.dispose();
        });

        deleteButton.addActionListener(e -> {
            String deVok = deInput.getText();
            String enVok = enInput.getText();
            if (!deVok.equals("") && !enVok.equals("")){
                Vok.delete(deVok, enVok);
                deInput.setText("");
                enInput.setText("");
                if (current == vokCount-1){
                    current = 0;
                } else {
                    current += 1;
                }
                deInput.setText(Vok.getVokDE(current));
                enInput.setText(Vok.getVokEN(current));
                vokCount = Vok.getCount();
            }
        });

    }


    public static void main(String[] args) {
        new MainFrame();
    }
}


