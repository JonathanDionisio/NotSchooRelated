
import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Dimension;


public class Window extends Canvas {

    private static final long serialVersionUID = -2;

    public Window(int width, int height, String title, Game game){
        JFrame Frame = new JFrame(title);

        Frame.setPreferredSize(new Dimension(width, height));
        Frame.setMaximumSize(new Dimension(width, height));
        Frame.setMinimumSize(new Dimension(width, height));

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setLocationRelativeTo(null);
        Frame.add(game);
        Frame.setVisible(true);
        game.start();

    }
}
