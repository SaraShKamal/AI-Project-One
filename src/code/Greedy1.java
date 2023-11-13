package code;
import java.util.*;

// h(n) =  prioritizing states with higher prosperity values.
// The assumption is that states with higher prosperity are more likely to lead to the goal state.
public class Greedy1 {
        private Actions actions;

        public Greedy1(Actions actions) {
            this.actions = actions;
        }

        public SearchResult greedySearch(State initialState) {
            PriorityQueue<State> openSet = new PriorityQueue<>(Comparator.comparingInt(State::getProsperity).reversed());
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

                List<State> successors = null;
                if (currentState.getProsperity() < 100) {
                    successors = currentState.generateSuccessors(actions);
                }
                if (successors != null) {
                    for (State successor : successors) {
                        if (!visited.contains(successor) && !openSet.contains(successor)) {
                            openSet.add(successor);
                            parentMap.put(successor, currentState);
                            actionMap.put(successor, successor.getAction());
                        }
                    }
            }
        }

            return null;
        }
    }


