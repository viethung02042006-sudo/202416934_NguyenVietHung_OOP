package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the list.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch(PlayerException e) {
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + artist + " - " + getLength() + ": " + getCost() + " $";
    }
}
