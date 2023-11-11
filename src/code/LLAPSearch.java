package code;

import java.util.ArrayList;
import java.util.Objects;

//LLAPSearch is a subclass of the generic search problem.
public class LLAPSearch extends GenericSearch {


    public static String solve(String init, String strategy, boolean visualize) {
        Initials problem = new Initials(init);
        Actions actions = new Actions(problem);
        State initialState = new State(problem.getProsperity(), problem.getFood(), problem.getMaterials(), problem.getEnergy(),
                0,100000,0,0,0,0,ActionsEnum.ROOT);

        if (Objects.equals(strategy, "BF")){
            BFS bfs = new BFS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = bfs.bfsSearch(initialState);

            return result.toString();
        }
        if (Objects.equals(strategy, "DF")){
            DFS dfs = new DFS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = dfs.dfsSearch(initialState);

            return result.toString();
        }
        if (Objects.equals(strategy, "ID")){
            IDS ids = new IDS(actions) ;
            // plan, monetaryCost, nodesExpanded
            SearchResult result = ids.idsSearch(initialState);

            return result.toString();
        }
        //ucs
        if (Objects.equals(strategy, "UC")){
            UCS ucs = new UCS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = ucs.ucsSearch(initialState);

            return result.toString();
        }
        //greedy1
        if (Objects.equals(strategy, "GR1")){
            Greedy1 greedy1 = new Greedy1(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = greedy1.greedySearch(initialState);

            return result.toString();
        }
        //greedy2
        if (Objects.equals(strategy, "GR2")){
            Greedy2 greedy2 = new Greedy2(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = greedy2.greedySearch(initialState);

            return result.toString();
        }
        //astar1
        if (Objects.equals(strategy, "AS1")){
            AStar1 aStar1 = new AStar1(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = aStar1.aStarSearch(initialState);

            return result.toString();
        }
        //astar2
        if (Objects.equals(strategy, "AS2")){
            AStar2 aStar2 = new AStar2(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = aStar2.aStarSearch(initialState);

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
        String strategy = "GR2"; // Choose your strategy
        boolean visualize = true; // Set to true to visualize

        String result = solve(init, strategy, visualize);
        System.out.println(result);
    }
}
