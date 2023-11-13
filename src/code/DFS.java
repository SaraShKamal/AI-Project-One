package code;
import java.util.*;
public class DFS extends DFSComparator {
    private Actions actions;

    public DFS(Actions actions) {
        super();
        this.actions = actions;
    }

    public SearchResult dfsSearch(State initialState) {
        // Change PriorityQueue to Stack
        Stack<State> openSet = new Stack<>();
        openSet.push(initialState);

        Set<State> visited = new HashSet<>(); // To keep track of visited states.

        Map<State, State> parentMap = new HashMap<>();
        Map<State, ActionsEnum> actionMap = new HashMap<>();
        List<ActionsEnum> plan = new ArrayList<>();
        // State String
        List<String> statesString = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;

        while (!openSet.isEmpty()) {
            State currentState = openSet.pop(); // Change poll to pop for Stack
            nodesExpanded++;

            // Check if the current state is the goal state.
            if (currentState.getProsperity() >= 100) {
                // Goal state found.
                monetaryCost = currentState.getMoney_spent();
                while (currentState != null) {
                    statesString.add(currentState.toString());
                    plan.add(0, actionMap.get(currentState)); // Add action at the beginning of the list.
                    currentState = parentMap.get(currentState);
                }

                return new SearchResult(plan, monetaryCost, nodesExpanded, statesString); // Goal state found.
            }
            visited.add(currentState);

            // Expand and add unvisited successors to the openSet.
            List<State> successors = null;
            if (currentState.getProsperity() < 100) {
                successors = currentState.generateSuccessors(actions);
            }
            if (successors != null) {
                for (State successor : successors) {
                    if (!visited.contains(successor) && !openSet.contains(successor)) {
                        openSet.push(successor); // Change add to push for Stack
                        parentMap.put(successor, currentState);
                        actionMap.put(successor, successor.getAction());
                    }
                }
            }
        }

        return null;
    }
}
