package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc() {
        super();
    }

    public Disc(String title) {
        super();
        this.setTitle(title);
    }

    public Disc(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Disc(String title, String category, String director, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setCost(cost);
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setDirector(director);
        this.setLength(length);
        this.setCost(cost);
    }
}
