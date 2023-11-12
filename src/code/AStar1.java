package code;
import java.util.*;

public class AStar1 {
    private Actions actions;

    public AStar1(Actions actions) {
        this.actions = actions;
    }

    public SearchResult aStarSearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(new AstarComparator1());
        openSet.add(initialState);

        Set<State> visited = new HashSet<>();
        Map<State, State> parentMap = new HashMap<>();
        Map<State, ActionsEnum> actionMap = new HashMap<>();
        List<ActionsEnum> plan = new ArrayList<>();
        //State String
        List<String> statesString = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;

        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();
            nodesExpanded++;

            if (currentState.getProsperity() >= 100) {
                // Goal state found.
                monetaryCost = currentState.getMoney_spent();
                while (currentState != null) {
                    statesString.add(currentState.toString());
                    plan.add(0, actionMap.get(currentState));
                    currentState = parentMap.get(currentState);
                }

                return new SearchResult(plan, monetaryCost, nodesExpanded, statesString);
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

        return null;
    }
}