package code;
import java.util.*;

public class AStar2 {
    private Actions actions;

    public AStar2(Actions actions) {
        this.actions = actions;
    }

    public SearchResult aStarSearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(new AstarComparator2());
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