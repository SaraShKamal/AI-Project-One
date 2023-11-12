package code;

import java.util.List;

public class SearchResult {
    List<ActionsEnum> plan;
    int monetaryCost;
    int nodesExpanded;

    List<String> statesString;

    public SearchResult(List<ActionsEnum> plan, int monetaryCost, int nodesExpanded, List<String> statesString) {
        this.plan = plan;
        this.monetaryCost = monetaryCost;
        this.nodesExpanded = nodesExpanded;
        this.statesString = statesString;
    }

    //get plan
    public List<ActionsEnum> getPlan() {
        //if plan first element is null, replace it with ROOT enum
        if (plan.get(0) == null) {
            plan.set(0, ActionsEnum.ROOT);
        }

        return plan;
    }

    //get monetary cost
    public int getMonetaryCost() {
    	return monetaryCost;
    }

    //get nodes expanded
    public int getNodesExpanded() {
    	return nodesExpanded;
    }

    //get states string
    public List<String> getStatesString() {
    	return statesString;
    }

    //to string method
    public String toString() {
    	return plan+";"+monetaryCost+";"+nodesExpanded;
    }
}