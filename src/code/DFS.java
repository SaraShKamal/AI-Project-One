package code;
import java.util.*;

public class DFS extends DFSComparator {
    private Actions actions;

    public DFS(Actions actions) {
        super();
        this.actions = actions;
    }
    public State dfsSearch(State initialState) {
        PriorityQueue<State> stack = new PriorityQueue<>(new DFSComparator());

        stack.add(initialState);

        Set<State> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            State currentState = stack.poll();

            if (currentState.getProsperity()>=100) {
                return currentState; // Goal state found.
            }

            visited.add(currentState);

            List<State> successors = currentState.generateSuccessors(actions);

            for (State successor : successors) {
                if (!visited.contains(successor)) {
                    stack.add(successor);
                }
            }
        }

        return null; // No solution found.
    }
}
