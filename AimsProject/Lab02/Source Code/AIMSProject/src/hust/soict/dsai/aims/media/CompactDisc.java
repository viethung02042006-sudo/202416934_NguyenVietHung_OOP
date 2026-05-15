package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
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
}
