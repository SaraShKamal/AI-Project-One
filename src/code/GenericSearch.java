package code;

import java.util.ArrayList;

public class GenericSearch {
    private State initialState;
    private State goalState;
    private ArrayList<Node> nodes;

    public GenericSearch(State initialState, State goalState) {
        this.initialState = initialState;
        this.goalState = goalState;
        this.nodes = new ArrayList<>();
        Node initialNode = new Node(initialState, null, null, 0, 0);
        nodes.add(initialNode);
    }




}
