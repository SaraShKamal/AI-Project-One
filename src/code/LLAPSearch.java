package code;

import java.util.ArrayList;

//LLAPSearch is a subclass of the generic search problem.
public class LLAPSearch extends GenericSearch {
    //ArrayList of nodes
    private int unitPriceFood,unitPriceMaterials,unitPriceEnergy,amountRequestFood,
            delayRequestFood,amountRequestMaterials,delayRequestMaterials,amountRequestEnergy,
            delayRequestEnergy,priceBUILD1,foodUseBUILD1,materialsUseBUILD1,energyUseBUILD1,
            prosperityBUILD1,priceBUILD2,foodUseBUILD2,materialsUseBUILD2,energyUseBUILD2,prosperityBUILD2;

    private int prosperity,food,materials,energy;

    //Constructor
    public LLAPSearch(String initialState) {
            String[] parts = initialState.split("[;,]");

            if (parts.length == 23) {
                this.prosperity = Integer.parseInt(parts[0]);
                this.food = Integer.parseInt(parts[1]);
                this.materials = Integer.parseInt(parts[2]);
                this.energy = Integer.parseInt(parts[3]);

                this.unitPriceFood = Integer.parseInt(parts[4]);
                this. unitPriceMaterials = Integer.parseInt(parts[5]);
                this.unitPriceEnergy = Integer.parseInt(parts[6]);

                this.amountRequestFood = Integer.parseInt(parts[7]);
                this.delayRequestFood = Integer.parseInt(parts[8]);
                this.amountRequestMaterials = Integer.parseInt(parts[9]);
                this.delayRequestMaterials = Integer.parseInt(parts[10]);
                this.amountRequestEnergy = Integer.parseInt(parts[11]);
                this.delayRequestEnergy = Integer.parseInt(parts[12]);

                this.priceBUILD1 = Integer.parseInt(parts[13]);
                this.foodUseBUILD1 = Integer.parseInt(parts[14]);
                this.materialsUseBUILD1 = Integer.parseInt(parts[15]);
                this.energyUseBUILD1 = Integer.parseInt(parts[16]);
                this.prosperityBUILD1 = Integer.parseInt(parts[17]);

                this.priceBUILD2 = Integer.parseInt(parts[18]);
                this.foodUseBUILD2 = Integer.parseInt(parts[19]);
                this.materialsUseBUILD2 = Integer.parseInt(parts[20]);
                this.energyUseBUILD2 = Integer.parseInt(parts[21]);
                this.prosperityBUILD2 = Integer.parseInt(parts[22]);
            }
    }
    //--------------------------------------------------------------------------------------------------------------
    //Actions (RequestFood,RequestMaterials,RequestEnergy,WAIT,BUILD1,BUILD2)

    //RequestFood
    public State RequestFood(State s, int delay) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = unitPriceFood + unitPriceMaterials + unitPriceEnergy;
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;


        if (s.getDelayFood() != 0 || s.getDelayMaterials() != 0 || s.getDelayEnergy() != 0 ||
                s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }
        return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, delay, s.getDelayMaterials(), s.getDelayEnergy(),s.getDepth()+1);
    }

    //RequestMaterials
    public State RequestMaterials(State s, int delay) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = unitPriceFood + unitPriceMaterials + unitPriceEnergy;
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;


        if (s.getDelayFood() != 0 || s.getDelayMaterials() != 0 || s.getDelayEnergy() != 0 ||
                s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }
         return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), delay, s.getDelayEnergy(),s.getDepth()+1);
    }

    //RequestEnergy
    public State RequestEnergy(State s, int delay) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = unitPriceFood + unitPriceMaterials + unitPriceEnergy;
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;


        if (s.getDelayFood() != 0 || s.getDelayMaterials() != 0 || s.getDelayEnergy() != 0 ||
                s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }
        return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), delay, s.getDepth()+1);
    }

    //WAIT
    public State WAIT(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = unitPriceFood + unitPriceMaterials + unitPriceEnergy;
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;

        if (s.getDelayFood()>0){
            s.setDelayFood(s.getDelayFood()-1);
            if (s.getDelayFood() == 0) {
                if (currentFood > 50)
                    currentFood = 50;
                else
                    currentFood += amountRequestFood;
            }
        }

        if (s.getDelayMaterials()>0){
            s.setDelayMaterials(s.getDelayMaterials()-1);
            if (s.getDelayMaterials() == 0) {
                if (currentMaterials > 50)
                    currentMaterials = 50;
                else
                    currentMaterials += amountRequestMaterials;
            }
        }

        if (s.getDelayEnergy()>0){
            s.setDelayEnergy(s.getDelayEnergy()-1);
            if (s.getDelayEnergy() == 0) {
                if (currentEnergy > 50)
                    currentEnergy = 50;
                else
                    currentEnergy += amountRequestEnergy;
            }
        }

        if (s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }

        return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), s.getDelayEnergy(),s.getDepth()+1);

    }

    //BUILD1
    public State BUILD1(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood-=foodUseBUILD1;
        currentMaterials-=materialsUseBUILD1;
        currentEnergy-=energyUseBUILD1;
        int totalDecrease = (unitPriceFood*foodUseBUILD1) + (unitPriceMaterials*materialsUseBUILD1) + (unitPriceEnergy*energyUseBUILD1);
        currentMoneySpent += (totalDecrease+priceBUILD1);
        int budget = s.getTotalMoneyOwned() - (totalDecrease+priceBUILD1);

        if (s.getDelayFood()>0){
            s.setDelayFood(s.getDelayFood()-1);
            if (s.getDelayFood() == 0) {
                if (currentFood > 50)
                    currentFood = 50;
                else
                    currentFood += amountRequestFood;
            }
        }

        if (s.getDelayMaterials()>0){
            s.setDelayMaterials(s.getDelayMaterials()-1);
            if (s.getDelayMaterials() == 0) {
                if (currentMaterials > 50)
                    currentMaterials = 50;
                else
                    currentMaterials += amountRequestMaterials;
            }
        }

        if (s.getDelayEnergy()>0){
            s.setDelayEnergy(s.getDelayEnergy()-1);
            if (s.getDelayEnergy() == 0) {
                if (currentEnergy > 50)
                    currentEnergy = 50;
                else
                    currentEnergy += amountRequestEnergy;
            }
        }

        if (s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }

        return new State(s.getProsperity()+prosperityBUILD1, currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), s.getDelayEnergy(),s.getDepth()+1);

    }

    //BUILD2
    public State BUILD2(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood-=foodUseBUILD2;
        currentMaterials-=materialsUseBUILD2;
        currentEnergy-=energyUseBUILD2;
        int totalDecrease = (unitPriceFood*foodUseBUILD2) + (unitPriceMaterials*materialsUseBUILD2) + (unitPriceEnergy*energyUseBUILD2);
        currentMoneySpent += (totalDecrease+priceBUILD2);
        int budget = s.getTotalMoneyOwned() - (totalDecrease+priceBUILD2);

        if (s.getDelayFood()>0){
            s.setDelayFood(s.getDelayFood()-1);
            if (s.getDelayFood() == 0) {
                if (currentFood > 50)
                    currentFood = 50;
                else
                    currentFood += amountRequestFood;
            }
        }

        if (s.getDelayMaterials()>0){
            s.setDelayMaterials(s.getDelayMaterials()-1);
            if (s.getDelayMaterials() == 0) {
                if (currentMaterials > 50)
                    currentMaterials = 50;
                else
                    currentMaterials += amountRequestMaterials;
            }
        }

        if (s.getDelayEnergy()>0){
            s.setDelayEnergy(s.getDelayEnergy()-1);
            if (s.getDelayEnergy() == 0) {
                if (currentEnergy > 50)
                    currentEnergy = 50;
                else
                    currentEnergy += amountRequestEnergy;
            }
        }

        if (s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }

        return new State(s.getProsperity()+prosperityBUILD2, currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), s.getDelayEnergy(),s.getDepth()+1);


    }

    public static String solve(String init, String strategy, boolean visualize) {
        LLAPSearch problem = new LLAPSearch(init);
        State initialState = new State(problem.prosperity, problem.food, problem.materials, problem.energy,
                0,100000,0,0,0,0);


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
