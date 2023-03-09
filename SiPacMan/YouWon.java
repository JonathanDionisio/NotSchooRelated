import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class YouWon extends JFrame {

    YouWon(){

        this.setLayout(new FlowLayout());

        JLabel imageLabel = new JLabel();
        ImageIcon pac = new ImageIcon("youwon.gif");
        imageLabel.setIcon(pac);
        this.add(imageLabel);

        JButton tryAgainButton = new  JButton();
        tryAgainButton.setText("Play Again");
        OPtion op = new OPtion();
        tryAgainButton.addActionListener(op);
        this.add(tryAgainButton);

        JButton exitButton = new JButton();
        exitButton.setText("EXIT");
        ragequit rq= new ragequit();
        exitButton.addActionListener(rq);
        this.add(exitButton);

        setTitle("Pacman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 450);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 50, 50));
    }


    private class OPtion implements ActionListener{

        public void actionPerformed(ActionEvent event){
            new OptionMenu();
            dispose();
        }

    }

    private class ragequit implements ActionListener{

        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }

    }
  }
    

