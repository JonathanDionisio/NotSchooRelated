

import java.util.LinkedList;
import java.util.ListIterator;

public class Song{

    LinkedList<String> Playlist = new LinkedList<>();

    String title;
    String artist;

    public String getFirstSong() {

        return Playlist.getFirst();
    }

    public String getSong(int index){

        return Playlist.get(index);
    }

    public int getSongIndex(String title){
        
        return Playlist.indexOf(title);
    }

    public boolean songExists(String title){
        
        return Playlist.contains(title);
    }

    public void addSong(String title){

        Playlist.add(title);
    }

    public ListIterator<String> iterateSong(int index) {

        return Playlist.listIterator(index);
    }
}


