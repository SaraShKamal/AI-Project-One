package code;
import java.util.Comparator;
public class Greedy1Comparator  implements Comparator<State> {
        @Override
        public int compare(State o1, State o2) {
            int distance1 = estimateDistanceToGoal(o1);
            int distance2 = estimateDistanceToGoal(o2);

            // Compare in ascending order based on the estimated distance to the goal
            return Integer.compare(distance1, distance2);
        }

        private int estimateDistanceToGoal(State state) {
            // Implement your heuristic to estimate the remaining distance to the goal
            // Combine both prosperity and total money spent in a way that suits your problem
            int prosperityDistance = Math.max(0, 100 - state.getProsperity());
            int moneySpentDistance = state.getMoney_spent(); // Adjust this based on your State class

            // You might use a weighted sum or other combination logic
            // For now, let's use a simple sum for demonstration purposes
            return prosperityDistance + moneySpentDistance;

        }
    }

