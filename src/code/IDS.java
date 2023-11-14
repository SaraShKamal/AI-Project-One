package code;
import java.util.*;

public class IDS extends DFSComparator {
    private Actions actions;
    private Set<State> visited= new HashSet<>();

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
                    plan.add(currentState.getAction());
                    currentState = currentState.getParent();
                }
                Collections.reverse(plan);
                return new SearchResult(plan, monetaryCost, nodesExpanded, statesString);
            }

            if (currentState.getDepth() >= depthLimit) {
                continue;
            }

            visited.add(currentState);

            List<State> successors = null;
            if (currentState.getProsperity() < 100) {
                successors = currentState.generateSuccessors(actions);
            }
            if (successors != null) {
                for (State successor : successors) {
                    if (!visited.contains(successor) && !openSet.contains(successor)) {
                        openSet.add(successor);
                        successor.setParent(currentState);
                        successor.setAction(successor.getAction());
                    }
                }
            }
        }

        return null; // Goal not found within the depth limit.
    }
}
