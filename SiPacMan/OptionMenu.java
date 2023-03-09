import javax.accessibility.AccessibleAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.EventListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class OptionMenu extends JFrame{

    JTextField playername;
    JList backGroundColorList;

    private String[] backGroundColorSelectionArray = { "BLACK", "BLUE", "PURPLE", "DARK BLUE" };
    private Color[] backGroundColorClassArray = {Color.BLACK, Color.BLUE, new Color(123, 50, 250), new Color(50,50,50)};

    OptionMenu(){

       

        // BUTTONS/LABELS/TEXTS/LISTS---------------------


        JLabel namelabel = new JLabel();
        namelabel.setText("Enter Player Name here:");
        namelabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        namelabel.setForeground(Color.white);

        JLabel pcmncolor = new JLabel();
        pcmncolor.setText("Select PacMan Color");
        pcmncolor.setFont(new Font("Monospaced", Font.BOLD, 20));
        pcmncolor.setForeground(Color.white);

        JLabel bgcololrlabel = new JLabel();
        bgcololrlabel.setText("Select BackGround Color");
        bgcololrlabel.setFont(new Font("Monospaced", Font.BOLD,20));
        bgcololrlabel.setForeground(Color.white);

        JLabel difflabel = new JLabel();
        difflabel.setText("Select Difficulty:");
        difflabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        difflabel.setForeground(Color.white);


        JLabel op = new JLabel();
        op.setText("|OPTIONS|");
        op.setFont(new Font("Monospaced", Font.BOLD, 25));
        op.setForeground(Color.white);

        playername = new JTextField(12);
        EnterName NM = new EnterName();
        playername.addKeyListener(NM);
    

        JButton pmcolor = new JButton();
        pmcolor.setText("PacMan Color");
        pmcolor.setFont(new Font("Monospaced", Font.BOLD, 25));
        back2menu b = new back2menu();
        pmcolor.addActionListener(b);

        backGroundColorList = new JList(backGroundColorSelectionArray);
        backGroundColorList.setFont(new Font("Arial", Font.BOLD, 25));
        backGroundColorList.setVisibleRowCount(1);
        // Sets JList to selection one option at a time
        backGroundColorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane bgColorPane = new JScrollPane(backGroundColorList);
        BGColorEventHandler bgcolorHandler = new BGColorEventHandler();
        backGroundColorList.addListSelectionListener(bgcolorHandler);

        // DIFFICULTY BUTTONS ------------

        JButton easyB = new JButton();
        easyB.setText("EASY");
        easyB.setFont(new Font("Monospaced", Font.BOLD, 18));
        Easy nmbg = new Easy(5);
        Medium sg = new Medium(2);
        hard pacshealth1 = new hard(3);
        easyB.addActionListener(nmbg);
        easyB.addActionListener(sg);
        easyB.addActionListener(pacshealth1); 
        startt startg = new startt();
        easyB.addActionListener(startg);      

        JButton mediumB = new JButton();
        mediumB.setText("MEDIUM");
        mediumB.setFont(new Font("Monospaced", Font.BOLD, 18));
        Easy nmbg1 = new Easy(7);
        Medium sg1 = new Medium(3);
        hard pacshealth2 = new hard(2);
        startt startg1 = new startt();
        mediumB.addActionListener(startg1);
        mediumB.addActionListener(nmbg1);
        mediumB.addActionListener(sg1);
        mediumB.addActionListener(pacshealth2);

        JButton hardB = new JButton();
        hardB.setText("HARD");
        hardB.setFont(new Font("Monospaced", Font.BOLD, 18));
        Easy nmbg2 = new Easy(10);
        Medium sg2 = new Medium(5);
        hard pacshealth3 = new hard(1);
        startt startg2 = new startt();
        hardB.addActionListener(startg2);
        hardB.addActionListener(nmbg2);
        hardB.addActionListener(sg2);
        hardB.addActionListener(pacshealth3);


        //-----------------------------------------

        this.setLayout(new FlowLayout());

        // THIS DOT ADD -------------------

        this.add(op);
        this.add(namelabel);
        this.add(playername);

        this.add(pcmncolor);
        this.add(pmcolor);
        this.add(bgcololrlabel);
        this.add(bgColorPane);
        
        this.add(difflabel);    
        this.add(easyB);
        this.add(mediumB);
        this.add(hardB);

        // Frame -------------------------
        setTitle("Pacman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350, 450);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 50, 50));

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
           
            Pacman ssstart = new Pacman();
            ssstart.setVisible(true);
        }
    }

    

    private class back2menu implements ActionListener{

        public void actionPerformed(ActionEvent event){

            new MainMenu();
        }
    }

    private class EnterName implements KeyListener  {

        public void keyPressed(KeyEvent event){
            Board shht = new Board();


            if(event.getKeyCode() == KeyEvent.VK_ENTER){
            
           shht.PlayerName =  playername.getText();    
           
          

            }   
           
        }

        public void keyTyped(KeyEvent event){

           
        }

        public void keyReleased(KeyEvent event){

           
        }
    }

    private class BGColorEventHandler implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent event) {
            Board board = new Board();
            board.backGroundColor = backGroundColorClassArray[backGroundColorList.getSelectedIndex()];
        }
    }



    
}
