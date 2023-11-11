package code;

import java.util.ArrayList;
import java.util.Objects;

//LLAPSearch is a subclass of the generic search problem.
public class LLAPSearch extends GenericSearch {


    public static String solve(String init, String strategy, boolean visualize) {
        Initials problem = new Initials(init);
        Actions actions = new Actions(problem);
        State initialState = new State(problem.getProsperity(), problem.getFood(), problem.getMaterials(), problem.getEnergy(),
                0,100000,0,0,0,0,ActionsEnum.NOSOLUTION);
        if (Objects.equals(strategy, "BFS")){
            BFS bfs = new BFS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = bfs.bfsSearch(initialState);

            return result.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        String init ="50;"+
                "22,22,22;" +
                "50,60,70;" +
                "30,2;19,1;15,1;" +
                "300,5,7,3,20;" +
                "500,8,6,3,40;";  // Replace with your initial state string
        String strategy = "DFS"; // Choose your strategy
        boolean visualize = true; // Set to true to visualize

        String result = solve(init, strategy, visualize);
        System.out.println(result);
    }
}
