import java.util.Hashtable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    String Hpwd = "1986";
    String Husr = "EKNEG";

    private JFrame frame;

    private JTextField tFieldUser;
    private JTextField tFieldPasswort;
    private JButton btnLogin;
    private JButton btnClear;
    private JPanel mainPanel;

    public MainFrame(){
        frame  = new JFrame("Shit");
        frame.setContentPane(mainPanel);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usrInput = tFieldUser.getText();
                String pwdInput = tFieldPasswort.getText();

                if (usrInput.equals(Husr) && pwdInput.equals(Hpwd)){
                    menu vA = new menu();
                    frame.dispose();
                    } else {
                    tFieldUser.setText("");
                    tFieldPasswort.setText("");
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tFieldUser.setText("");
                tFieldPasswort.setText("");
            }
        });
    }


    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}
