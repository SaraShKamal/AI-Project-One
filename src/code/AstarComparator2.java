package code;

import java.util.Comparator;

    public class AstarComparator2 implements Comparator<State> {
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

    // heuristic that considers how close the town is to reaching the goal state.
    // For example, you could calculate the percentage of prosperity achieved so far.
        public int calculateHeuristic(State state) {
            int goalProsperity = 100;
            int currentProsperity = state.getProsperity();
            double percentageAchieved = (double) currentProsperity / goalProsperity;
            return (int) Math.ceil((1 - percentageAchieved) * goalProsperity);
        }
    }





