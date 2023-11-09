package code;

import java.util.ArrayList;

//LLAPSearch is a subclass of the generic search problem.
public class LLAPSearch extends GenericSearch {
    //ArrayList of nodes
    private ArrayList<Node> nodes = new ArrayList<Node>();

    //Constructor
    public LLAPSearch() {
        super();

    }

    //Methods

    //Decode the initial state string




    //--------------------------------------------------------------------------------------------------------------
    //Actions (RequestFood,RequestMaterials,RequestEnergy,WAIT,BUILD1,BUILD2)

    //RequestFood
    public static State RequestFood(State state, int amount, int delay) {
        if (amount < 0 || delay < 0) {
            throw new IllegalArgumentException("Invalid amount or delay.");
        }
        else if (delay>2){
            throw new IllegalArgumentException("Maximum delay is 2.");
        }
        //Handle the delay and delievery of food
        else if (state.getFood() + amount < 50){
            int moneySpent = state.getMoney_spent() + (amount * state.getUnitPriceFood());
            state.setMoney(state.getMoney()-state.getUnitPriceFood());
            return new State(state.getProsperity(), state.getFood() + amount, state.getMaterials(), state.getEnergy(), moneySpent);
        }
        else if (state.getFood() + amount >= 50){
            return new State(state.getProsperity(), 50, state.getMaterials(), state.getEnergy(), state.getMoney_spent());

        }
        else {
            throw new IllegalArgumentException("Invalid initial state string.");
        }
    }

    //RequestMaterials
    public static State RequestMaterials(int amount, int delay) {
        return null;
    }

    //RequestEnergy
    public static State RequestEnergy(int amount, int delay) {
        return null;
    }

    //WAIT
    public static State WAIT() {
        return null;
    }

    //BUILD1
    public static State BUILD1() {
        return null;
    }

    //BUILD2
    public static State BUILD2() {
        return null;
    }

    public static String solve(String init, String strategy, boolean visualize) {
        State initialState = new State(init);
        Node initialNode = new Node(initialState, null, null, 0, 0);


        String plan= "";
        String monetaryCost = "";
        String nodesExpanded = "";
        return plan+";"+monetaryCost+";"+nodesExpanded;
    }

    public static void main(String[] args) {
        String init ="50;"+
                "22,22,22;" +
                "50,60,70;" +
                "30,2;19,1;15,1;" +
                "300,5,7,3,20;" +
                "500,8,6,3,40;";  // Replace with your initial state string
        String strategy = "BFS"; // Choose your strategy
        boolean visualize = true; // Set to true to visualize

        String result = solve(init, strategy, visualize);
        System.out.println(result);
    }
}
