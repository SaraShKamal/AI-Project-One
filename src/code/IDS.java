package code;
import java.util.*;

public class IDS extends DFSComparator {
    private Actions actions;

    public IDS(Actions actions) {
        super();
        this.actions = actions;
    }

    public SearchResult idsSearch(State initialState) {
        int depthLimit = 0;

        while (true) {
            SearchResult result = performDepthLimitedSearch(initialState, depthLimit);

            if (result != null) {
                return result; // Goal state found, return the result.
            }

            depthLimit++; // Increment the depth limit for the next iteration.
        }
    }

    private SearchResult performDepthLimitedSearch(State initialState, int depthLimit) {
        PriorityQueue<State> openSet = new PriorityQueue<>(new DFSComparator());
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
                monetaryCost = currentState.getMoney_spent();
                while (currentState != null) {
                    statesString.add(currentState.toString());
                    plan.add(0, actionMap.get(currentState));
                    currentState = parentMap.get(currentState);
                }
                return new SearchResult(plan, monetaryCost, nodesExpanded, statesString);
            }

            if (currentState.getDepth() >= depthLimit) {
                continue;
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

        return null; // Goal not found within the depth limit.
    }
}
