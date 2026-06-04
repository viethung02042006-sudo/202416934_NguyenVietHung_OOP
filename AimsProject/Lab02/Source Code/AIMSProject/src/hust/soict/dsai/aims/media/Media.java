package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        if (cost < 0) {
            throw new IllegalArgumentException("ERROR: Cost cannot be negative!");
        }
        this.cost = cost;
    }

    public int getId() { return id; }
    // Xóa setId vì id thường không đổi sau khi tạo

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        try {
            if (o == null) {
                throw new NullPointerException("The object to compare is null.");
            }
            if (!(o instanceof Media)) {
                throw new ClassCastException("The object to compare is not an instance of Media.");
            }
            Media media = (Media) o;
            if (this.title == null || media.getTitle() == null) {
                return false;
            }
            return this.title.equalsIgnoreCase(media.getTitle());
        } catch (NullPointerException | ClassCastException e) {
            System.err.println("Error comparing Media objects: " + e.getMessage());
            return false;
        }
    }
}