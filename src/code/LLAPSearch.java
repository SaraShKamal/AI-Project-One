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
        String resultString = "";

        if (Objects.equals(strategy, "BF")){
            BFS bfs = new BFS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = bfs.bfsSearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;
        }
        if (Objects.equals(strategy, "DF")){
            DFS dfs = new DFS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = dfs.dfsSearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;

        }
        if (Objects.equals(strategy, "ID")){
            IDS ids = new IDS(actions) ;
            // plan, monetaryCost, nodesExpanded
            SearchResult result = ids.idsSearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;

        }
        //ucs
        if (Objects.equals(strategy, "UC")){
            UCS ucs = new UCS(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = ucs.ucsSearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;

        }
        //greedy1
        if (Objects.equals(strategy, "GR1")){
            Greedy1 greedy1 = new Greedy1(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = greedy1.greedySearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;
        }
        //greedy2
        if (Objects.equals(strategy, "GR2")){
            Greedy2 greedy2 = new Greedy2(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = greedy2.greedySearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;
        }
        //astar1
        if (Objects.equals(strategy, "AS1")){
            AStar1 aStar1 = new AStar1(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = aStar1.aStarSearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;
        }
        //astar2
        if (Objects.equals(strategy, "AS2")){
            AStar2 aStar2 = new AStar2(actions);
            // plan, monetaryCost, nodesExpanded
            SearchResult result = aStar2.aStarSearch(initialState);
            //loop through the plan and put it in a string separated by ,
            for (int i = 0; i < result.getPlan().size(); i++) {
                if (i == result.getPlan().size()-1){
                    resultString += result.getPlan().get(i);
                }
                else {
                    resultString += result.getPlan().get(i) + ",";
                }
            }
            //monetary cost
            resultString += ";" + result.getMonetaryCost();
            //nodes expanded
            resultString += ";" + result.getNodesExpanded();
            if (visualize){
                //loop on statesString reverse and add to string
                for (int i = result.getStatesString().size()-1; i >= 0; i--) {
                    resultString += "\n" + result.getStatesString().get(i);
                }
            }
            return resultString;
        }
        if (resultString.equals("") || resultString.equals(null)){
            return "NOSOLUTION";
        }
        return "NOSOLUTION";
    }

    public static void main(String[] args) {
        String init ="50;"+
                "22,22,22;" +
                "50,60,70;" +
                "30,2;19,1;15,1;" +
                "300,5,7,3,20;" +
                "500,8,6,3,40;";  // Replace with your initial state string
        String strategy = "GR1"; // Choose your strategy
        boolean visualize = true; // Set to true to visualize

        String result = solve(init, strategy, visualize);
        System.out.println(result);
    }
}
