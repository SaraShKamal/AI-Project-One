package code;

import java.util.List;

public class SearchResult {
    List<ActionsEnum> plan;
    int monetaryCost;
    int nodesExpanded;

    public SearchResult(List<ActionsEnum> plan, int monetaryCost, int nodesExpanded) {
        this.plan = plan;
        this.monetaryCost = monetaryCost;
        this.nodesExpanded = nodesExpanded;
    }

    //to string method
    public String toString() {
    	return plan+";"+monetaryCost+";"+nodesExpanded;
    }
}