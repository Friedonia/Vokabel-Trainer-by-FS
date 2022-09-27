import java.util.Arrays;
import java.util.Hashtable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    char[] Hpwd = {'1','9','8','6'};
    String Husr = "EKNEG";

    private JFrame frame;

    private JTextField tFieldUser;
    private JPasswordField tFieldPasswort;
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
                char[] password = tFieldPasswort.getPassword();

                if (usrInput.equals(Husr) && Arrays.equals(Hpwd, password)){
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
