package code;

import java.util.Comparator;

public class UCSComparator implements Comparator<State> {

    @Override
    public int compare(State o1, State o2) {
        double ratio1 = (double) o1.getProsperity() / o1.getMoney_spent();
        double ratio2 = (double) o2.getProsperity() / o2.getMoney_spent();

        // Compare based on the ratio of prosperity increase to money spent
        if (ratio1 > ratio2) {
            return -1; // State 1 has a higher ratio, so it comes first
        } else if (ratio1 < ratio2) {
            return 1; // State 2 has a higher ratio, so it comes first
        } else {
            return 0;
        }
    }
}
