package foods;

import java.util.Comparator;

public class sortByNameLength implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        if (o1 == null || o2 == null) return 0;
        return o1.getName().length() - o2.getName().length();
    }
}
