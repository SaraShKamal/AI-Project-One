package code;
import java.util.*;

public class DFS extends DFSComparator {
    private Actions actions;

    public DFS(Actions actions) {
        super();
        this.actions = actions;
    }


    public SearchResult dfsSearch(State initialState) {
        // Create a priority queue with the BFSComparator.
        PriorityQueue<State> openSet = new PriorityQueue<>(new DFSComparator());
        openSet.add(initialState);

        Set<State> visited = new HashSet<>(); // To keep track of visited states.

        Map<State, State> parentMap = new HashMap<>();
        Map<State, ActionsEnum> actionMap = new HashMap<>();
        List<ActionsEnum> plan = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;


        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();
            nodesExpanded++;
            System.out.println("Current State:");
            System.out.println(currentState.toString());

            // Check if the current state is the goal state.
            if (currentState.getProsperity()>=100) {
                //Goal state found.
                while (currentState != null) {
                    plan.add(0, actionMap.get(currentState)); // Add action at the beginning of the list
                    monetaryCost += currentState.getMoney_spent();
                    currentState = parentMap.get(currentState);
                }
                return new SearchResult(plan,monetaryCost,nodesExpanded); // Goal state found.
            }
            visited.add(currentState);

            // Expand and add unvisited successors to the openSet.
            List<State> successors = currentState.generateSuccessors(actions);
            //Debugging
            //Loop through successors

            System.out.println("Successors:");
            for (State successor : successors) {
                System.out.println(successor.toString());
            }


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

