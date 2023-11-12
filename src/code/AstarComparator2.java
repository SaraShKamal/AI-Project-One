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


        public int calculateHeuristic(State state) {
            int scarcityHeuristic = 0;
            int criticalResourceThreshold = 10;  // Adjust as needed
            if (state.getFood() < criticalResourceThreshold) {
                scarcityHeuristic += criticalResourceThreshold - state.getFood();
            }
            if (state.getMaterials() < criticalResourceThreshold) {
                scarcityHeuristic += criticalResourceThreshold - state.getMaterials();
            }
            if (state.getEnergy() < criticalResourceThreshold) {
                scarcityHeuristic += criticalResourceThreshold - state.getEnergy();
            }
            return scarcityHeuristic;
        }
    }




