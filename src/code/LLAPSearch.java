package code;
//LLAPSearch is a subclass of the generic search problem.
public class LLAPSearch extends GenericSearch {
    public LLAPSearch(State initialState, State goalState) {
        super(initialState, goalState);
    }

    public static String solve(String initalState, String strategy, boolean visualize) {

        String plan= "";
        String monetaryCost = "";
        String nodesExpanded = "";
        return plan+";"+monetaryCost+";"+nodesExpanded;
    }

    public static void main(String[] args) {
        String initialState = "Initial state string";  // Replace with your initial state string
        String strategy = "BFS"; // Choose your strategy
        boolean visualize = true; // Set to true to visualize

        String result = solve(initialState, strategy, visualize);
        System.out.println(result);
    }
}
