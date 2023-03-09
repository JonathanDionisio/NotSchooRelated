import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;


public class MainMenu extends JFrame{

    MainMenu(){

        // BUTTONS ====================================================

        JLabel imageLabel = new JLabel();
        ImageIcon pac = new ImageIcon("ppacman.gif");
        imageLabel.setIcon(pac);
        
        JButton StartButton = new JButton();
        StartButton.setText("Start Game");
        StartButton.setFont(new Font("Monospaced", Font.BOLD, 25));
        EventHandler handler = new EventHandler();
        StartButton.addActionListener(handler);
        // StartB starttt = new StartB();
        // StartButton.addActionListener(starttt);

        // JButton Option = new JButton();
        // Option.setText("option temp");
        // Option.setFont(new Font("Monospaced", Font.BOLD, 25));
        // options op = new options();
        // Option.addActionListener(op);

        JButton EXIT = new JButton();
        EXIT.setText("EXIT");
        EXIT.setFont(new Font("Monospaced", Font.BOLD, 25));
        EXITT quit = new EXITT();
        EXIT.addActionListener(quit);
        
        //=======================================================================

        // THIS DOT ADDS ==============================================================
        this.add(imageLabel);
        this.add(StartButton);
        // this.add(Option);
        this.add(EXIT);

        this.setLayout(new FlowLayout());

        setTitle("Pacman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 450);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);

        //========================================================================================
    }

    // HANDLERS =============================================================================

    // private class EventHandler implements ActionListener{

    //     int Ghostnumber;
    //     int speedofGh;
    //     int pachp;
       
    //         EventHandler(int numbghost, int speedg,int pacshp){
    //             this.Ghostnumber = numbghost;
    //             this.speedofGh = speedg;
    //             this.pachp = pacshp;
    //         }
        

    //     public void actionPerformed(ActionEvent event){

            
    //         Board ex = new Board();
    //         ex.N_GHOSTS = Ghostnumber;
    //          ex.currentSpeed = speedofGh;
    //         ex.pacsLeft = pachp;      
    //         dispose();

    //     }

    // }

    private class EventHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            new OptionMenu();
            dispose();
        }

    }


    private class EXITT implements ActionListener{

        public void actionPerformed(ActionEvent event){
            System.exit(0); 
        }
    }
//========================================================================= 
}