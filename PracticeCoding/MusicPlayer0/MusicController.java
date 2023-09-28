
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;



public class MusicController implements Initializable{

    @FXML
    private Pane pane;

    @FXML
    private Label songLabel;

    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;

    @FXML
    private ComboBox <String> speedSetter;

    @FXML
    private Slider volumeSlider;

    @FXML
    private ProgressBar songProgressBar;

    private Media media;

    private MediaPlayer mediaPlayer;
        
    public File directory;

    public File[] files;

    private LinkedList <File> songs;

    private int[] speeds = {20, 50, 75, 100, 125 ,150, 175, 200};

    private Timer timer;

    private TimerTask task;
    
    private boolean running;

    private int songNumber;

    Song song = new Song();

    @Override
    public void initialize(URL args0, ResourceBundle arg1) {
      
        directory = new File("MusicListmp3");

        files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {

                song.addSong(file.getName());
            }
        }

        if(song != null){
            songLabel.setText(song.getFirstSong());
        }
        
            //    media = new Media(songs.get(songNumber).toURI().toString());
		    //   mediaPlayer = new MediaPlayer(media);
		
		    //   songLabel.setText(songs.get(songNumber).getName());
    }

    

    public void playMedia() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

       
    }

    public void pauseMedia() {

    }

    public void resetMedia() {

    }

    public void nextMedia() {

        String currentSong = songLabel.getText();

        int currentSongIndex = song.getSongIndex(currentSong);

        ListIterator<String> list_Iter = song.iterateSong(currentSongIndex);

        list_Iter.next();

        if(list_Iter.hasNext()){
            songLabel.setText(list_Iter.next());       
        }
    }

    public void previousMedia() {

        String currentSong = songLabel.getText();
       
        int currentSongIndex = song.getSongIndex(currentSong);

        ListIterator<String> list_Iter = song.iterateSong(currentSongIndex);
        
        if(list_Iter.hasPrevious()){
            songLabel.setText(list_Iter.previous());       
        }
    }

    public void changeSpeed (ActionEvent event){

    }

    public void beginTimer() {

    }

    public void cancelTimer() {

    } 
}
