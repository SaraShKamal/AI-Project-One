package code;
import java.util.Comparator;

    public class AstarComparator1 implements Comparator<State> {
        @Override
        public int compare(State state1, State state2) {
            double fScore1 = calculateFScore(state1);
            double fScore2 = calculateFScore(state2);

            return Double.compare(fScore1, fScore2);
        }

        private double calculateFScore(State state) {
            double hScore = calculateHeuristic(state);
            int gScore = state.getMoney_spent();

            return gScore + hScore;
        }

        private double calculateHeuristic(State state) {
            return (double) state.getProsperity() / state.getMoney_spent();
        }
    }


