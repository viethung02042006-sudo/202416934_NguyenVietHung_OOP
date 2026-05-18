package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Check for null titles to avoid NullPointerException
        String title1 = m1.getTitle() != null ? m1.getTitle() : "";
        String title2 = m2.getTitle() != null ? m2.getTitle() : "";
        
        // First compare by title (alphabetical order)
        int titleCompare = title1.compareToIgnoreCase(title2);
        
        // If titles are the same, compare by cost (decreasing order)
        if (titleCompare == 0) {
            return Float.compare(m2.getCost(), m1.getCost());
        }
        
        return titleCompare;
    }
}
