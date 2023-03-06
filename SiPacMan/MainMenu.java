import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;


public class MainMenu extends JFrame{

    MainMenu(){

        JLabel imageLabel = new JLabel();
        ImageIcon pac = new ImageIcon("ppacman.gif");
        imageLabel.setIcon(pac);
        
        JButton StartButton = new JButton();
        StartButton.setText("Start Game");
        StartButton.setFont(new Font("Monospaced", Font.BOLD, 25));
        EventHandler handler = new EventHandler();
        StartButton.addActionListener(handler);

        JButton Quit = new JButton();
        Quit.setText("option temp");
        Quit.setFont(new Font("Monospaced", Font.BOLD, 25));
        Exit exit = new Exit();
        Quit.addActionListener(exit);


        this.add(imageLabel);
        this.add(StartButton);
        this.add(Quit);

        this.setLayout(new FlowLayout());

        setTitle("Pacman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 450);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);

    }

    private class EventHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            Pacman ex = new Pacman();
            ex.setVisible(true);
            dispose();

        }

    }

    private class Exit implements ActionListener{

        public void actionPerformed(ActionEvent event){
            new OptionMenu();

        }

    }
    
}