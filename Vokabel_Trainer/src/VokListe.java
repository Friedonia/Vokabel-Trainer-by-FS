import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JFrame frame0;
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

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( !deInput.getText().equals(Vok.getVokDE(current)) || !enInput.getText().equals(Vok.getVokEN(current))){
                    try {
                        Vok.setVok(Vok.getVokDE(current), Vok.getVokEN(current), deInput.getText(), enInput.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
            }
        });

        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (0 == current){
                    current = vokCount-1;
                } else {
                    current -= 1;
                }
                deInput.setText(Vok.getVokDE(current));
                enInput.setText(Vok.getVokEN(current));
            }

        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (current == vokCount-1){
                    current = 0;
                } else {
                    current += 1;
                }
                deInput.setText(Vok.getVokDE(current));
                enInput.setText(Vok.getVokEN(current));
            }
        });



        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu vA = new menu();
                frame0.dispose();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });

    }


    public static void main(String[] args) {

        MainFrame myFrame = new MainFrame();
    }
}


