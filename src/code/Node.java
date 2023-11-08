package code;
import java.util.ArrayList;
import java.util.Objects;

public class Node {

    private State state ;
    private String action;
    private Node parent;
    private int cost;
    private int depth;

    public Node(State initialState, String action, Object parentNode, int cost, int depth) {
        this.state = initialState;
        this.action = action;
        this.parent = (Node) parentNode;
        this.cost = cost;
        this.depth = depth;
    }
}

