package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // First compare by cost (decreasing order)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        
        // If costs are the same, compare by title (alphabetical order)
        if (costCompare == 0) {
            // Check for null titles to avoid NullPointerException
            String title1 = m1.getTitle() != null ? m1.getTitle() : "";
            String title2 = m2.getTitle() != null ? m2.getTitle() : "";
            return title1.compareToIgnoreCase(title2);
        }
        
        return costCompare;
    }
}
