import javax.swing.JFrame;

public class GotoLevel2 extends JFrame {

    public GotoLevel2() {

        initUI();
    }

    private void initUI() {

        add(new level2());

        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 420);
        setLocationRelativeTo(null);
    }

}