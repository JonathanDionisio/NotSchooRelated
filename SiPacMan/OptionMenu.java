import javax.accessibility.AccessibleAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class OptionMenu extends JFrame{

   

    OptionMenu(){

       

        // BUTTONS/LABELS/TEXTS/LISTS---------------------


        JLabel namelabel = new JLabel();
        namelabel.setText("Enter Player Name here:");
        namelabel.setFont(new Font("Monospaced", Font.BOLD, 15));

        JLabel op = new JLabel();
        op.setText("|OPTIONS|");
        op.setFont(new Font("Monospaced", Font.BOLD, 25));

        JTextField playername = new JTextField();
        playername.setText("                      ");
        playername.setFont(new Font("Monospaced", Font.BOLD, 20));

        JButton pmcolor = new JButton();
        pmcolor.setText("PacMan Color");
        pmcolor.setFont(new Font("Monospaced", Font.BOLD, 20));
        back2menu b = new back2menu();
        pmcolor.addActionListener(b);

        JButton bgcolor = new JButton();
        bgcolor.setText("BackGround Color");
        bgcolor.setFont(new Font("Monospaced", Font.BOLD, 20));



        // DIFFICULTY BUTTONS ------------

        JButton easyB = new JButton();
        easyB.setText("EASY");
        easyB.setFont(new Font("Monospaced", Font.BOLD, 20));
        Easy nmbg = new Easy(5);
        Medium sg = new Medium(2);
        hard pacshealth1 = new hard(3);
        easyB.addActionListener(nmbg);
        easyB.addActionListener(sg);
        easyB.addActionListener(pacshealth1);       

        JButton mediumB = new JButton();
        mediumB.setText("MEDIUM");
        mediumB.setFont(new Font("Monospaced", Font.BOLD, 20));
        Easy nmbg1 = new Easy(7);
        Medium sg1 = new Medium(3);
        hard pacshealth2 = new hard(2);
        mediumB.addActionListener(nmbg1);
        mediumB.addActionListener(sg1);
        mediumB.addActionListener(pacshealth2);

        JButton hardB = new JButton();
        hardB.setText("HARD");
        hardB.setFont(new Font("Monospaced", Font.BOLD, 20));
        Easy nmbg2 = new Easy(10);
        Medium sg2 = new Medium(5);
        hard pacshealth3 = new hard(1);
        hardB.addActionListener(nmbg2);
        hardB.addActionListener(sg2);
        hardB.addActionListener(pacshealth3);


        //-----------------------------------------

        this.setLayout(new FlowLayout());

        // THIS DOT ADD -------------------

        this.add(op);
        this.add(namelabel);
        this.add(playername);

        this.add(easyB);
        this.add(mediumB);
        this.add(hardB);

        this.add(pmcolor);
        this.add(bgcolor);

        // Frame -------------------------
        setTitle("Pacman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350, 450);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);

    }

    // EVENTS/LISTENERS/ACTIONS---------------------------


    private class Easy implements ActionListener{

        int Ghostnumber;
       
        Easy(int numbghost){
            this.Ghostnumber = numbghost;
        }

        public void actionPerformed(ActionEvent event){

            Board numbG = new Board();
            numbG.N_GHOSTS = Ghostnumber;
            dispose();
            
        }

    }

    private class Medium implements ActionListener{

        int speedofGh;

        Medium(int speedg){
            this.speedofGh = speedg;
        }

        public void actionPerformed(ActionEvent event){

            Board G_speed = new Board();
            G_speed.currentSpeed = speedofGh;

            dispose();
            
        }

    }

    private class hard implements ActionListener{

        int pachp;

        hard(int pacshp){
            this.pachp = pacshp;
        }
        public void actionPerformed(ActionEvent event){
            
            Board pHP = new Board();
            pHP.pacsLeft = pachp;    
            dispose();
           
            

        }

    }

    private class startt implements ActionListener{

        public void actionPerformed(ActionEvent event){

            Pacman ex3 = new Pacman();
            ex3.setVisible(true);

        }
    }

    

    private class back2menu implements ActionListener{

        public void actionPerformed(ActionEvent event){

            new MainMenu();
        }
    }


    
}
