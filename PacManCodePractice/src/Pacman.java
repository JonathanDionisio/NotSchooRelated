

import javax.swing.JFrame;

public class Pacman extends JFrame {

    public Pacman() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setTitle("TIME-PAC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 440);
        setLocationRelativeTo(null);
    }

}