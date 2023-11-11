package code;
import java.util.*;

//h(n) guides the search towards states that provide a higher prosperity relative to the cost incurred.
// It aims to strike a balance between reaching a high level of prosperity and minimizing the cost spent to get there.

public class Greedy2 {
    private Actions actions;

    public Greedy2(Actions actions) {
        this.actions = actions;
    }

    public SearchResult greedySearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(new Greedy2Comparator());
        openSet.add(initialState);

        Set<State> visited = new HashSet<>();
        Map<State, State> parentMap = new HashMap<>();
        Map<State, ActionsEnum> actionMap = new HashMap<>();
        List<ActionsEnum> plan = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;

        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();
            nodesExpanded++;

            if (currentState.getProsperity() >= 100) {
                // Goal state found.
                monetaryCost = currentState.getMoney_spent();
                while (currentState != null) {
                    plan.add(0, actionMap.get(currentState));
                    currentState = parentMap.get(currentState);
                }

                return new SearchResult(plan, monetaryCost, nodesExpanded);
            }
            visited.add(currentState);

            List<State> successors = currentState.generateSuccessors(actions);

            for (State successor : successors) {
                if (!visited.contains(successor) && !openSet.contains(successor)) {
                    openSet.add(successor);
                    parentMap.put(successor, currentState);
                    actionMap.put(successor, successor.getAction());
                }
            }
        }

        return new SearchResult(Collections.emptyList(), -1, nodesExpanded);
    }
}
