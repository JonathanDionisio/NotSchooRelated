import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class YouWon extends JFrame {

    Board board = new Board();
    


    YouWon(){
        
        boolean AddNewPlayerToList;
        int finalscore = board.score;
        String PPN = board.PlayerName;
        LinkedList PlayerNameScoreList = new LinkedList<String>();
        LinkedList PlayerScoreList = new LinkedList<Integer>();
        boolean PlayerWonAddBoard;
        Board PlayerScoreBoardConnect = new Board();
        LinkedList FirstPlayernamee = board.FirstPlayername;
        LinkedList FirstPlayerScorename = board.FirstPlayername;
        PlayerScoreBoardConnect.finished = AddNewPlayerToList = false;
       


        

         if (AddNewPlayerToList = true) {
            PlayerNameScoreList.add(PPN);
            PlayerScoreList.add(finalscore);
            PlayerScoreList.add(FirstPlayerScorename);
            PlayerNameScoreList.add(FirstPlayernamee);
          
           
        }


        this.setLayout(new FlowLayout());

        JLabel namelabel = new JLabel();
        namelabel.setText(PPN + "'s score is: " + Integer.toString(finalscore));
        namelabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        namelabel.setForeground(new Color(255, 234, 0));
        
        JLabel imageLabel = new JLabel();
        ImageIcon pac = new ImageIcon("ppacman.gif");
        imageLabel.setIcon(pac);
        this.add(imageLabel);
        this.add(namelabel);
        
        JLabel YOUWON = new JLabel();
        YOUWON.setText("!CONGRATULATIONS, YOU WON!");
        YOUWON.setFont(new Font("Monospaced", Font.BOLD, 17));
        YOUWON.setForeground(new Color(255, 234, 0));
        this.add(YOUWON);

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
        
        JButton Level2 = new  JButton();
        Level2.setText("NEXT LEVEL");
        gotolevel2 golvl2 = new gotolevel2();
        Level2.addActionListener(golvl2);
        this.add(Level2);

        JLabel ScoreBoardLabel = new JLabel();
        ScoreBoardLabel.setText(" SCORE BOARD: ");
        ScoreBoardLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        ScoreBoardLabel.setForeground(new Color(255, 234, 0));
        this.add(ScoreBoardLabel);

        JLabel PlayerScoreNameLabel = new JLabel();
        PlayerScoreNameLabel.setText(PlayerNameScoreList.toString());

        PlayerScoreNameLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        PlayerScoreNameLabel.setForeground(new Color(255, 234, 0));

        JLabel PlayerScoreLabel = new JLabel();
        PlayerScoreLabel.setText(PlayerScoreList.toString());
        
        PlayerScoreLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
        PlayerScoreLabel.setForeground(new Color(255, 234, 0));
        this.add(PlayerScoreNameLabel);
        this.add(PlayerScoreLabel);

        setTitle("Pacman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350, 490);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(26,2,2,255));

    }


    private class OPtion implements ActionListener{

         boolean AddNewPlayerToList;
        int finalscore = board.score;
        String PPN = board.PlayerName;
        LinkedList PlayerScoreList = new LinkedList<>();
        boolean PlayerWonAddBoard;
        Board PlayerScoreBoardConnect = new Board();
        

        public void actionPerformed(ActionEvent event){
               PPN = null;
               finalscore = 0;
                 PlayerNameScoreList.clear();
                 PlayerScoreList.clear();
            new OptionMenu();
            PlayerScoreList.push(PPN +" SCORE: "+ finalscore);
            dispose();
        }

    }

    private class gotolevel2 implements ActionListener{

        

        public void actionPerformed(ActionEvent event){
            GotoLevel2 ssstart = new  GotoLevel2();
            ssstart.setVisible(true);
             
            dispose();
        }

    }

    private class ragequit implements ActionListener{

        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }

    }
  }
    

