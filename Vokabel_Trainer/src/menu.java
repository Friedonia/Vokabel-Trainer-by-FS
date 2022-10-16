import javax.swing.*;


public class menu {
    private final JFrame frame0;

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


        logoutBut.addActionListener(e -> {
            new MainFrame();
            frame0.dispose();
        });
        practiceButton.addActionListener(e -> {
            new Training();
            frame0.dispose();
        });
        delBtn.addActionListener(e -> {
            new VokListe();
            frame0.dispose();
        });
        addVokabelButton.addActionListener(e -> {
            new AddVok();
            frame0.dispose();
        });
    }


    public static void main(String[] args) {
         new MainFrame();
    }
}

