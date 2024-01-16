import javax.accessibility.AccessibleAction;
import javax.swing.Action;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class OptionMenu extends JFrame{

    LinkedList EnteredPlayerName = new LinkedList<String>();

    boolean namecheck;
    boolean bgccolorcheck;
    boolean ghostskincheck;
    boolean pacmanskincheck;

    JTextField playername;
    JList backGroundColorList;
    JList ghostSkinList;
    JList PacManSkinList;
   
    private String[] backGroundColorSelectionArray = { "CLASSIC", "PINK CANDY", "LAVA", "FOREST", "AQUATIC"};
    private Color[] backGroundColorClassArray = {Color.BLACK, new Color(68,19,40,255), new Color(143,94,101,255), new Color(56,87,55,255), new Color(48,94,85,255)};
    private Color[] MazeColorClassArray = {new Color(57,81,226,255), new Color(204,83,154,255), new Color(235,16,5,255), new Color(139,224,152,255), new Color(36,102,201,255)};


    // MAP //
    private LinkedList<String> BGCSelectionList = new LinkedList<>();
    private LinkedList<Color> BGCList = new LinkedList<>();
    private LinkedList<Color> MazeColorList = new LinkedList<>();
    //

    // GHOST //
    private LinkedList<String> GhostSelectionList = new LinkedList<>();
    private LinkedList<String> GhostFilePathList = new LinkedList<>();
    //

    // PAC-MAN //

    private LinkedList<String> PacManSkinSelectionList = new LinkedList<>();
    private LinkedList<String> pacmanList = new LinkedList<>();
    private LinkedList<String> pacmanuplist1 = new LinkedList<>();
    private LinkedList<String> pacmanuplist2 = new LinkedList<>();
    private LinkedList<String> pacmanuplist3 = new LinkedList<>();
    private LinkedList<String> pacmandownlist1 = new LinkedList<>();
    private LinkedList<String> pacmandownlist2 = new LinkedList<>();
    private LinkedList<String> pacmandownlist3 = new LinkedList<>();
    private LinkedList<String> pacmanleftlist1 = new LinkedList<>();
    private LinkedList<String> pacmanleftlist2 = new LinkedList<>();
    private LinkedList<String> pacmanleftlist3 = new LinkedList<>();
    private LinkedList<String> pacmanrightlist1 = new LinkedList<>();
    private LinkedList<String> pacmanrightlist2 = new LinkedList<>();
    private LinkedList<String> pacmanrightlist3 = new LinkedList<>();
    

    //



    private String[] ghostskinselectionArray = { "SUS", "AMOGUS??", "GHOST", "ZOMGHOST", "BOCCHI", "KIRBY", "LUFFY", "MINION" };
    private String[] ghostfilepathArray = {
        "src/resources/images/amogus.gif",
        "src/resources/images/amogusyel.gif", 
        "src/resources/images/gost.gif", 
        "src/resources/images/zomghost.png", 
        "src/resources/images/bocchii.gif",
         "src/resources/images/kirby.gif",
         "src/resources/images/luffy.gif",
         "src/resources/images/minion.gif"}; 
    
    private String[] PacManSkinSelectionArray ={"APPLE", "COLD", "MSPAC-MAN", "PAC-MAN", "POCHITA", "TANGERINE", "THE ROCK"};
    private String[] pacmanArray ={"src/resources/apple/apleft1.png", "src/resources/Creepypacman/cpleft1.png", "src/resources/MsPacMan/mspleft1.png", "src/resources/OGpacman/ogp.png", "src/resources/pochita/pocleft1.png", "src/resources/tangerine/tanleft1.png", "src/resources/bocchi/bocleft1.png"};
    private String[] pacmanUpArray1 ={"src/resources/apple/apup1.png", "src/resources/Creepypacman/cpup1.png", "src/resources/MsPacMan/mspup1.png", "src/resources/OGpacman/ogpup1.png", "src/resources/pochita/pocup1.png", "src/resources/tangerine/tanup1.png", "src/resources/bocchi/bocup1.png"};
    private String[] pacmanUpArray2 ={"src/resources/apple/apup2.png", "src/resources/Creepypacman/cpup2.png", "src/resources/MsPacMan/mspup2.png", "src/resources/OGpacman/ogpup2.png", "src/resources/pochita/pocup2.png", "src/resources/tangerine/tanup2.png", "src/resources/bocchi/bocup2.png"};
    private String[] pacmanUpArray3 ={"src/resources/apple/apup3.png", "src/resources/Creepypacman/cpup3.png", "src/resources/MsPacMan/mspup3.png", "src/resources/OGpacman/ogpup3.png", "src/resources/pochita/pocup3.png", "src/resources/tangerine/tanup3.png" , "src/resources/bocchi/bocup3.png"};
    private String[] pacmanDownArray1 ={"src/resources/apple/apdown1.png", "src/resources/Creepypacman/cpdown1.png", "src/resources/MsPacMan/mspdown1.png", "src/resources/OGpacman/ogpdown1.png", "src/resources/pochita/pocdown1.png", "src/resources/tangerine/tandown1.png", "src/resources/bocchi/bocdown1.png"};
    private String[] pacmanDownArray2 ={"src/resources/apple/apdown2.png", "src/resources/Creepypacman/cpdown2.png", "src/resources/MsPacMan/mspdown2.png", "src/resources/OGpacman/ogpdown2.png", "src/resources/pochita/pocdown2.png", "src/resources/tangerine/tandown2.png", "src/resources/bocchi/bocdown2.png"};
    private String[] pacmanDownArray3 ={"src/resources/apple/apdown3.png", "src/resources/Creepypacman/cpdown3.png", "src/resources/MsPacMan/mspdown3.png", "src/resources/OGpacman/ogpdown3.png", "src/resources/pochita/pocdown3.png", "src/resources/tangerine/tandown3.png", "src/resources/bocchi/bocdown3.png"};
    private String[] pacmanLeftArray1 ={"src/resources/apple/apleft1.png", "src/resources/Creepypacman/cpleft1.png", "src/resources/MsPacMan/mspleft1.png", "src/resources/OGpacman/ogpleft1.png", "src/resources/pochita/pocleft1.png", "src/resources/tangerine/tanleft1.png", "src/resources/bocchi/bocleft1.png"};
    private String[] pacmanLeftArray2 ={"src/resources/apple/apleft2.png", "src/resources/Creepypacman/cpleft2.png", "src/resources/MsPacMan/mspleft2.png", "src/resources/OGpacman/ogpleft2.png", "src/resources/pochita/pocleft2.png", "src/resources/tangerine/tanleft2.png", "src/resources/bocchi/bocleft2.png"};
    private String[] pacmanLeftArray3 ={"src/resources/apple/apleft3.png", "src/resources/Creepypacman/cpleft3.png", "src/resources/MsPacMan/mspleft3.png", "src/resources/OGpacman/ogpleft3.png", "src/resources/pochita/pocleft3.png", "src/resources/tangerine/tanleft3.png", "src/resources/bocchi/bocleft3.png"};
    private String[] pacmanRightArray1 ={"src/resources/apple/aprigh1.png", "src/resources/Creepypacman/cpright1.png", "src/resources/MsPacMan/mspright1.png", "src/resources/OGpacman/ogpright1.png", "src/resources/pochita/pocright1.png", "src/resources/tangerine/tanright1.png", "src/resources/bocchi/bocright1.png"};
    private String[] pacmanRightArray2 ={"src/resources/apple/apright2.png", "src/resources/Creepypacman/cpright2.png", "src/resources/MsPacMan/mspright2.png", "src/resources/OGpacman/ogpright2.png", "src/resources/pochita/pocright2.png", "src/resources/tangerine/tanright2.png", "src/resources/bocchi/bocright2.png"};
    private String[] pacmanRightArray3 ={"src/resources/apple/apright3.png", "src/resources/Creepypacman/cpright3.png", "src/resources/MsPacMan/mspright3.png", "src/resources/OGpacman/ogpright3.png", "src/resources/pochita/pocright3.png", "src/resources/tangerine/tanright3.png", "src/resources/bocchi/bocright3.png"};


    public void paintComponent(Graphics g) {
            
        }
    
    OptionMenu(){

            //GHOST//

            GhostSelectionList.add("SUS");
            GhostSelectionList.add("AMOGUS??");
            GhostSelectionList.add("GHOST");
            GhostSelectionList.add("ZOMGHOST");
            GhostSelectionList.add("BOCCHI");
             GhostSelectionList.add("KIRBY");
              GhostSelectionList.add("LUFFY");
               GhostSelectionList.add("MINION");
                GhostSelectionList.add("RAINBOW");

            GhostFilePathList.add("src/resources/images/amogus.gif");
            GhostFilePathList.add("src/resources/images/amogusyel.gif");
            GhostFilePathList.add("src/resources/images/gost.gif");
            GhostFilePathList.add("src/resources/images/zomghost.gif");
            GhostFilePathList.add("src/resources/images/bocchii.gif");
            GhostFilePathList.add("src/resources/images/kirby.gif");
            GhostFilePathList.add("src/resources/images/luffyy.gif");
            GhostFilePathList.add("src/resources/images/minion.gif");
            GhostFilePathList.add("src/resources/images/rainbow.gif");

            //

            // MAP ///

            BGCSelectionList.add("CLASSIC");
            BGCList.add(Color.BLACK);
            MazeColorList.add(new Color(57,81,226,255));

             BGCSelectionList.add("PINK CANDY");
            BGCList.add(new Color(68,19,40,255));
            MazeColorList.add(new Color(204,83,154,255));

             BGCSelectionList.add("LAVA");
            BGCList.add(new Color(155,11,4));
            MazeColorList.add(new Color(251,226,106));
            

             BGCSelectionList.add("FOREST");
            BGCList.add(new Color(56,87,55,255));
            MazeColorList.add(new Color(139,224,152,255));

             BGCSelectionList.add("AQUATIC");
            BGCList.add(new Color(48,94,85,255));
            MazeColorList.add(new Color(36,102,201,255));

            BGCSelectionList.add("HONEY");
            BGCList.add(new Color( 216,134,0,255));
            MazeColorList.add(new Color(251,233,68));
           
            //

            // PAC-MAN //

                PacManSkinSelectionList.add("APPLE");
                PacManSkinSelectionList.add("CREEPY");
                PacManSkinSelectionList.add("MS-PAC");
                PacManSkinSelectionList.add("PAC-MAN");
                PacManSkinSelectionList.add("POCHITA");
                PacManSkinSelectionList.add("TANGERINE");
                PacManSkinSelectionList.add("BOCHI");
                PacManSkinSelectionList.add("PIZZA");

                pacmanList.add("src/resources/apple/apleft1.png");
                pacmanList.add("src/resources/Creepypacman/cpleft1.png");
                pacmanList.add("src/resources/MsPacMan/mspleft1.png");
                pacmanList.add("src/resources/OGpacman/ogp.png");
                pacmanList.add("src/resources/pochita/pocleft1.png");
                pacmanList.add("src/resources/tangerine/tanleft1.png");
                pacmanList.add("src/resources/bocchi/bocleft1.png");
                 pacmanList.add("src/resources/pizza/pizzaleft1.jpeg");


                pacmanuplist1.add("src/resources/apple/apup1.png");
                pacmanuplist1.add("src/resources/Creepypacman/cpup1.png");
                pacmanuplist1.add("src/resources/MsPacMan/mspup1.png");
                pacmanuplist1.add("src/resources/OGpacman/ogpup1.png");
                pacmanuplist1.add("src/resources/pochita/pocup1.png");
                pacmanuplist1.add("src/resources/tangerine/tanup1.png");
                pacmanuplist1.add("src/resources/bocchi/bocup1.png");
                pacmanuplist1.add("src/resources/pizza/pizzaleft1.jpeg");

                pacmanuplist2.add("src/resources/apple/apup2.png");
                pacmanuplist2.add("src/resources/Creepypacman/cpup2.png");
                pacmanuplist2.add("src/resources/MsPacMan/mspup2.png");
                pacmanuplist2.add("src/resources/OGpacman/ogpup2.png");
                pacmanuplist2.add("src/resources/pochita/pocup2.png");
                pacmanuplist2.add("src/resources/tangerine/tanup2.png");
                pacmanuplist2.add("src/resources/bocchi/bocup2.png");
                pacmanuplist2.add("src/resources/pizza/pizzaleft2.jpeg");

                pacmanuplist3.add("src/resources/apple/apup3.png");
                pacmanuplist3.add("src/resources/Creepypacman/cpup3.png");
                pacmanuplist3.add("src/resources/MsPacMan/mspup3.png");
                pacmanuplist3.add("src/resources/OGpacman/ogpup3.png");
                pacmanuplist3.add("src/resources/pochita/pocup3.png");
                pacmanuplist3.add("src/resources/tangerine/tanup3.png");
                pacmanuplist3.add("src/resources/bocchi/bocup3.png");
                pacmanuplist3.add("src/resources/pizza/pizzaleft3.jpeg");

                pacmandownlist1.add("src/resources/apple/apdown1.png");
                pacmandownlist1.add("src/resources/Creepypacman/cpdown1.png");
                pacmandownlist1.add("src/resources/MsPacMan/mspdown1.png");
                pacmandownlist1.add("src/resources/OGpacman/ogpdown1.png");
                pacmandownlist1.add("src/resources/pochita/pocdown1.png");
                pacmandownlist1.add("src/resources/tangerine/tandown1.png");
                pacmandownlist1.add("src/resources/bocchi/bocdown1.png");
                pacmandownlist1.add("src/resources/pizza/pizzadown1.jpeg");

                pacmandownlist2.add("src/resources/apple/apdown2.png");
                pacmandownlist2.add("src/resources/Creepypacman/cpdown2.png");
                pacmandownlist2.add("src/resources/MsPacMan/mspdown2.png");
                pacmandownlist2.add("src/resources/OGpacman/ogpdown2.png");
                pacmandownlist2.add("src/resources/pochita/pocdown2.png");
                pacmandownlist2.add("src/resources/tangerine/tandown2.png");
                pacmandownlist2.add("src/resources/bocchi/bocdown2.png");
                pacmandownlist2.add("src/resources/pizza/pizzadown2.jpeg");

                pacmandownlist3.add("src/resources/apple/apdown3.png");
                pacmandownlist3.add("src/resources/Creepypacman/cpdown3.png");
                pacmandownlist3.add("src/resources/MsPacMan/mspdown3.png");
                pacmandownlist3.add("src/resources/OGpacman/ogpdown3.png");
                pacmandownlist3.add("src/resources/pochita/pocdown3.png");
                pacmandownlist3.add("src/resources/tangerine/tandown3.png");
                pacmandownlist3.add("src/resources/bocchi/bocdown3.png");
                pacmandownlist3.add("src/resources/pizza/pizzadown3.jpeg");

                pacmanleftlist1.add("src/resources/apple/apleft1.png");
                pacmanleftlist1.add("src/resources/Creepypacman/cpleft1.png");
                pacmanleftlist1.add("src/resources/MsPacMan/mspleft1.png");
                pacmanleftlist1.add("src/resources/OGpacman/ogpleft1.png");
                pacmanleftlist1.add("src/resources/pochita/pocleft1.png");
                pacmanleftlist1.add("src/resources/tangerine/tanleft1.png");
                pacmanleftlist1.add("src/resources/bocchi/bocleft1.png");
                pacmanleftlist1.add("src/resources/pizza/pizzaleft1.jpeg");

                pacmanleftlist2.add("src/resources/apple/apleft2.png");
                pacmanleftlist2.add("src/resources/Creepypacman/cpleft2.png");
                pacmanleftlist2.add("src/resources/MsPacMan/mspleft2.png");
                pacmanleftlist2.add("src/resources/OGpacman/ogpleft2.png");
                pacmanleftlist2.add("src/resources/pochita/pocleft2.png");
                pacmanleftlist2.add("src/resources/tangerine/tanleft2.png");
                pacmanleftlist2.add("src/resources/bocchi/bocleft2.png");
                pacmanleftlist2.add("src/resources/pizza/pizzaleft2.jpeg");

                pacmanleftlist3.add("src/resources/apple/apleft3.png");
                pacmanleftlist3.add("src/resources/Creepypacman/cpleft3.png");
                pacmanleftlist3.add("src/resources/MsPacMan/mspleft3.png");
                pacmanleftlist3.add("src/resources/OGpacman/ogpleft3.png");
                pacmanleftlist3.add("src/resources/pochita/pocleft3.png");
                pacmanleftlist3.add("src/resources/tangerine/tanleft3.png");
                pacmanleftlist3.add("src/resources/bocchi/bocleft3.png");
                pacmanleftlist3.add("src/resources/pizza/pizzaleft3.jpeg");

                pacmanrightlist1.add("src/resources/apple/apright1.png");
                pacmanrightlist1.add("src/resources/Creepypacman/cpright1.png");
                pacmanrightlist1.add("src/resources/MsPacMan/mspright1.png");
                pacmanrightlist1.add("src/resources/OGpacman/ogpright1.png");
                pacmanrightlist1.add("src/resources/pochita/pocright1.png");
                pacmanrightlist1.add("src/resources/tangerine/tanright1.png");
                pacmanrightlist1.add("src/resources/bocchi/bocright1.png");
                pacmanrightlist1.add("src/resources/pizza/pizzaright1.jpeg");

                pacmanrightlist2.add("src/resources/apple/apright2.png");
                pacmanrightlist2.add("src/resources/Creepypacman/cpright2.png");
                pacmanrightlist2.add("src/resources/MsPacMan/mspright2.png");
                pacmanrightlist2.add("src/resources/OGpacman/ogpright2.png");
                pacmanrightlist2.add("src/resources/pochita/pocright2.png");
                pacmanrightlist2.add("src/resources/tangerine/tanright2.png");
                pacmanrightlist2.add("src/resources/bocchi/bocright2.png");
                pacmanrightlist2.add("src/resources/pizza/pizzaright2.jpeg");

                pacmanrightlist3.add("src/resources/apple/apright3.png");
                pacmanrightlist3.add("src/resources/Creepypacman/cpright3.png");
                pacmanrightlist3.add("src/resources/MsPacMan/mspright3.png");
                pacmanrightlist3.add("src/resources/OGpacman/ogpright3.png");
                pacmanrightlist3.add("src/resources/pochita/pocright3.png");
                pacmanrightlist3.add("src/resources/tangerine/tanright3.png");
                pacmanrightlist3.add("src/resources/bocchi/bocright3.png");
                pacmanrightlist3.add("src/resources/pizza/pizzaright3.jpeg");
                

            //

       

        // BUTTONS/LABELS/TEXTS/LISTS---------------------


        JLabel namelabel = new JLabel();
        namelabel.setText("Enter Player Name here:");
        namelabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        namelabel.setForeground(new Color(255, 234, 0));

        JLabel pcmncolor = new JLabel();
        pcmncolor.setText("Select Ghost Skin");
        pcmncolor.setFont(new Font("Monospaced", Font.BOLD, 20));
        pcmncolor.setForeground(new Color(255, 234, 0));

        JLabel bgcololrlabel = new JLabel();
        bgcololrlabel.setText("Select Level Theme");
        bgcololrlabel.setFont(new Font("Monospaced", Font.BOLD,20));
        bgcololrlabel.setForeground(new Color(255, 234, 0));

        JLabel difflabel = new JLabel();
        difflabel.setText("Select Difficulty:");
        difflabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        difflabel.setForeground(new Color(255, 234, 0));

        JLabel PacManSkinLabel = new JLabel();
        PacManSkinLabel.setText("Select Pac-Man Skin:");
        PacManSkinLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        PacManSkinLabel.setForeground(new Color(255, 234, 0));

    

        JLabel op = new JLabel();
        op.setText("|OPTIONS|");
        op.setFont(new Font("Monospaced", Font.BOLD, 28));
        op.setForeground(new Color(255, 234, 0 ));

        JButton pmcolor = new JButton();
        pmcolor.setText("PacMan Color");
        pmcolor.setFont(new Font("Monospaced", Font.BOLD, 25));
        back2menu b = new back2menu();
        pmcolor.addActionListener(b);

        playername = new JTextField(12);
        EnterName NM = new EnterName();
        playername.setFont(new Font("Monospaced", Font.BOLD, 18));
        playername.setBackground(new Color(255, 234, 0  ));
        playername.addKeyListener(NM);

        backGroundColorList = new JList(BGCSelectionList.toArray());
        backGroundColorList.setFont(new Font("Monospaced", Font.BOLD, 25));
        backGroundColorList.setVisibleRowCount(1);
        backGroundColorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane bgColorPane = new JScrollPane(backGroundColorList);
        BGColorEventHandler bgcolorHandler = new BGColorEventHandler();
        backGroundColorList.addListSelectionListener(bgcolorHandler);

        backGroundColorList.setForeground(Color.BLACK); 
        backGroundColorList.setBackground(new Color(253,3,2,255)); 
        backGroundColorList.setForeground(new Color(213,255,255,255));

        // GhostSkin ======================================================

        ghostSkinList = new JList(GhostSelectionList.toArray());
        ghostSkinList.setFont(new Font("Monospaced", Font.BOLD, 25));
        ghostSkinList.setVisibleRowCount(1);
        ghostSkinList.setBackground(new Color(237,87,255,255)); 
        ghostSkinList.setForeground(new Color(213,255,255,255));  
        ghostSkinList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane GhostskinPane = new JScrollPane(ghostSkinList);
       
        GhostSkinHandler skinPane = new GhostSkinHandler();
        ghostSkinList.addListSelectionListener(skinPane);
        

        // PacManSkin =============================================

        PacManSkinList = new JList(PacManSkinSelectionList.toArray());
        PacManSkinList.setFont(new Font("Monospaced", Font.BOLD, 25));
        PacManSkinList.setVisibleRowCount(1);
        PacManSkinList.setBackground(new Color(58,244,241,255)); 
        PacManSkinList.setForeground(new Color(213,255,255,255));  
        PacManSkinList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane PacmanskinPane = new JScrollPane(PacManSkinList);
        PacmanSkinHandler PacManSkinPane = new PacmanSkinHandler();
        PacManSkinList.addListSelectionListener(PacManSkinPane);

    
        // DIFFICULTY BUTTONS =========================================

        JButton easyB = new JButton();
        easyB.setText("EASY");
        easyB.setFont(new Font("Monospaced", Font.BOLD, 25));
        Easy nmbg = new Easy(5);
        Medium sg = new Medium(2);
        hard pacshealth1 = new hard(3);
        easyB.addActionListener(nmbg);
        easyB.addActionListener(sg);
        easyB.addActionListener(pacshealth1); 
        startt startg = new startt();
        easyB.addActionListener(startg);  
        easyB.setBackground(new Color(58,244,241,255 ));  
        easyB.setForeground(new Color(213,255,255,255));  

        JButton mediumB = new JButton();
        mediumB.setText("MEDIUM");
        mediumB.setFont(new Font("Monospaced", Font.BOLD, 25));
        Easy nmbg1 = new Easy(7);
        Medium sg1 = new Medium(3);
        hard pacshealth2 = new hard(2);
        startt startg1 = new startt();
        mediumB.addActionListener(startg1);
        mediumB.addActionListener(nmbg1);
        mediumB.addActionListener(sg1);
        mediumB.addActionListener(pacshealth2);
        mediumB.setBackground(new Color(237,87,255,255));  
        mediumB.setForeground(new Color(249,252,248,255));  

        JButton hardB = new JButton();
        hardB.setText("HARD");
        hardB.setFont(new Font("Monospaced", Font.BOLD, 25));
        Easy nmbg2 = new Easy(10);
        Medium sg2 = new Medium(5);
        hard pacshealth3 = new hard(1);
        startt startg2 = new startt();
        hardB.addActionListener(startg2);
        hardB.addActionListener(nmbg2);
        hardB.addActionListener(sg2);
        hardB.addActionListener(pacshealth3);
        hardB.setBackground(new Color(253,3,2,255));  
        hardB.setForeground(new Color(249,252,248,255));  


        // GHOST DISPLAY //

                JLabel imageLabelimpostor = new JLabel();
                JLabel imageLabelamogus = new JLabel();
                JLabel imageLabelbochi = new JLabel();
                JLabel imageLabelgost = new JLabel();
                JLabel imageLabelkirby = new JLabel();
                JLabel imageLabelluffy = new JLabel();
                JLabel imageLabelminion = new JLabel();
                JLabel imageLabelorange = new JLabel();
                JLabel imageLabelrainbow = new JLabel();

                ImageIcon impostor = new ImageIcon(GhostFilePathList.get(0));
                ImageIcon amogus = new ImageIcon(GhostFilePathList.get(1));
                ImageIcon bocchi = new ImageIcon(GhostFilePathList.get(2));
                ImageIcon gost = new ImageIcon(GhostFilePathList.get(3));
                ImageIcon kirby = new ImageIcon(GhostFilePathList.get(4));
                ImageIcon luffy = new ImageIcon(GhostFilePathList.get(5));
                ImageIcon minion = new ImageIcon(GhostFilePathList.get(6));
                ImageIcon orange = new ImageIcon(GhostFilePathList.get(7));
                ImageIcon rainbow = new ImageIcon(GhostFilePathList.get(8));
                
                imageLabelimpostor.setIcon(impostor);
                imageLabelamogus.setIcon(amogus);
                imageLabelbochi.setIcon(bocchi);
                imageLabelgost.setIcon(gost);
                imageLabelkirby.setIcon(kirby);
                imageLabelluffy.setIcon(luffy);
                imageLabelminion.setIcon(minion);
                imageLabelorange.setIcon(orange);
                imageLabelrainbow.setIcon(rainbow);

         // PAC MAN DISPLAY ///

                JLabel APPLE = new JLabel();
                JLabel CREEP = new JLabel();
                JLabel MSPCM = new JLabel();
                JLabel OGPCM = new JLabel();
                JLabel POCH = new JLabel();
                JLabel TANG = new JLabel();
                JLabel BOCCHI = new JLabel();
           
             ImageIcon pacapple = new ImageIcon(pacmanrightlist1.get(0));
             ImageIcon paccreep = new ImageIcon(pacmanrightlist1.get(1));
             ImageIcon pacms = new ImageIcon(pacmanrightlist1.get(2));
             ImageIcon pacm = new ImageIcon(pacmanrightlist1.get(3));
             ImageIcon pacpochita = new ImageIcon(pacmanrightlist1.get(4));
             ImageIcon pactang = new ImageIcon(pacmanrightlist1.get(5));
             ImageIcon pacbochi = new ImageIcon(pacmanrightlist1.get(6));


                APPLE.setIcon(pacapple);
                CREEP.setIcon(paccreep);
                MSPCM.setIcon(pacms);
                OGPCM.setIcon(pacm);
                POCH.setIcon(pacpochita);
                TANG.setIcon(pactang);
                BOCCHI.setIcon(pacbochi);

        //-----------------------------------------

        this.setLayout(new FlowLayout());

        // THIS DOT ADD -------------------

        this.add(op);
        this.add(namelabel);
        this.add(playername);

        this.add(pcmncolor);
        this.add(GhostskinPane);

        this.add(PacManSkinLabel);
        this.add(PacmanskinPane);
       
        this.add(bgcololrlabel);
        this.add(bgColorPane);
       
        
        this.add(difflabel);    
        this.add(easyB);
        this.add(mediumB);
        this.add(hardB);

         this.add(imageLabelimpostor);
          this.add(imageLabelamogus);
          this.add(imageLabelbochi);
          this.add(imageLabelgost);
          this.add(imageLabelkirby);
          this.add(imageLabelluffy);
          this.add(imageLabelminion);
          this.add(imageLabelorange);
          this.add(imageLabelrainbow);

        //   this.add(APPLE);
        //   this.add(CREEP);
        //   this.add(MSPCM);
        //   this.add(OGPCM);
        //   this.add(POCH);
        //   this.add(TANG);
        //   this.add(BOCCHI);
        
      
        
        
       
        
        
        this.setLayout(new FlowLayout());

        // Frame -------------------------
        setTitle("TIME-PAC");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(365, 550);
        this.setLocationRelativeTo(rootPane);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(10,10,97));

    }

    // EVENTS/LISTENERS/ACTIONS---------------------------

     private void showghostskinimage() {

        JLabel imageLabel = new JLabel();
         ImageIcon ghostshow = new ImageIcon(GhostFilePathList.toArray().toString());
         imageLabel.setIcon(ghostshow);
        
    }


    private class Easy implements ActionListener{

        int Ghostnumber;
       
        Easy(int numbghost){
            this.Ghostnumber = numbghost;
        }

        public void actionPerformed(ActionEvent event){

           

            Board numbG = new Board();
            level2 numbG2 = new level2();
            numbG.N_GHOSTS = Ghostnumber;
            numbG2.N_GHOSTS = Ghostnumber;
            
            
            
        }

    }

    private class Medium implements ActionListener{

        int speedofGh;

        Medium(int speedg){
            this.speedofGh = speedg;
        }

        public void actionPerformed(ActionEvent event){

            Board G_speed = new Board();
            level2 G_speed2 = new level2();
            G_speed.currentSpeed = speedofGh;
            G_speed2.currentSpeed = speedofGh;


           
            
        }

    }

    private class hard implements ActionListener{

        int pachp;

        hard(int pacshp){
            this.pachp = pacshp;
        }
        public void actionPerformed(ActionEvent event){
            
            Board pHP = new Board();
            level2 pHP2 = new level2();
            pHP.pacsLeft = pachp; 
            pHP2.pacsLeft = pachp;    
            dispose();
           
           
            

        }

    }

    private class startt implements ActionListener{

        public void actionPerformed(ActionEvent event){
            
           if(namecheck && ghostskincheck && pacmanskincheck && bgccolorcheck == true){

           
            
            Pacman ssstart = new Pacman();
            ssstart.setVisible(true);
           }
           else {
            new OptionMenu();

           }
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
            level2 shht2 = new level2();
            namecheck = true;

            if(event.getKeyCode() == KeyEvent.VK_ENTER){



                shht.PlayerName =  playername.getText(); 
                shht2.PlayerName =  playername.getText();    
            // EnteredPlayerName.add(playername);
            // shht.FirstPlayername.addAll(EnteredPlayerName);
           
           
          

            }   
           
        }

        public void keyTyped(KeyEvent event){

           
        }

        public void keyReleased(KeyEvent event){

           
        }
    }

    private class BGColorEventHandler implements ListSelectionListener{

       

        public void valueChanged(ListSelectionEvent event) {
             bgccolorcheck = true;
            Board board = new Board();
            level2 board2 = new level2();
             board.backGroundColor = BGCList.get(backGroundColorList.getSelectedIndex());
            board2.backGroundColor = BGCList.get(backGroundColorList.getSelectedIndex());
            board.mazeColor = MazeColorList.get(backGroundColorList.getSelectedIndex());
            board2.mazeColor = MazeColorList.get(backGroundColorList.getSelectedIndex());
        }
    }

    private class GhostSkinHandler implements ListSelectionListener{
      
        
        public void valueChanged(ListSelectionEvent event){
             
            // Graphics2D g2d = (Graphics2D) g;
            showghostskinimage();
            ghostskincheck = true;
            Board skin = new Board();
            level2 skin2 = new level2();
            skin.ghostfilename = (String) GhostFilePathList.toArray()[ghostSkinList.getSelectedIndex()];
            

            skin2.ghostfilename = (String) GhostFilePathList.toArray()[ghostSkinList.getSelectedIndex()];
            // super.paintComponent(g);
            // doDrawing(g);
          
            
        }
    }

  

    private class PacmanSkinHandler implements ListSelectionListener{

        public void valueChanged(ListSelectionEvent event){

            pacmanskincheck = true;
        
        Board Pacmanskinn = new Board();
        level2 Pacmanskinn2 = new level2();
        Pacmanskinn.PACMANN = (String) pacmanList.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanupp1 =(String) pacmanuplist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanupp2 =(String) pacmanuplist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanupp3 =(String) pacmanuplist3.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmandownn1 =(String)pacmandownlist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmandownn2 =(String)pacmandownlist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmandownn3 =(String)pacmandownlist3.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanleftt1 =(String) pacmanleftlist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanleftt2 =(String)pacmanleftlist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanleftt3 =(String)pacmanleftlist3.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanrightt1 =(String)pacmanrightlist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanrightt2 =(String)pacmanrightlist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn.pacmanrightt3 =(String)pacmanrightlist3.toArray()[PacManSkinList.getSelectedIndex()];

        Pacmanskinn2.PACMANN =(String)pacmanList.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanupp1 =(String)pacmanuplist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanupp2 =(String)pacmanuplist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanupp3 =(String)pacmanuplist3.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmandownn1 =(String)pacmandownlist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmandownn2 =(String)pacmandownlist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmandownn3 =(String)pacmandownlist3.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanleftt1 =(String)pacmanleftlist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanleftt2 =(String)pacmanleftlist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanleftt3 =(String)pacmanleftlist3.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanrightt1 =(String)pacmanrightlist1.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanrightt2 =(String)pacmanrightlist2.toArray()[PacManSkinList.getSelectedIndex()];
        Pacmanskinn2.pacmanrightt3 =(String)pacmanrightlist3.toArray()[PacManSkinList.getSelectedIndex()];

        }

       

        
    }

    
}
