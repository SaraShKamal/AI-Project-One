package code;
import java.util.Comparator;

    public class AstarComparator1 implements Comparator<State> {
        @Override
        public int compare(State state1, State state2) {
            int fScore1 = calculateFScore(state1);
            int fScore2 = calculateFScore(state2);

            return Integer.compare(fScore1, fScore2);
        }

        private int calculateFScore(State state) {
            int hScore = calculateHeuristic(state);
            int gScore = state.getMoney_spent();

            return gScore + hScore;
        }

        private int calculateHeuristic(State state) {
            int goalProsperity = 100;
            return goalProsperity - state.getProsperity();
        }
    }


