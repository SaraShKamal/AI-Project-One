package code;
import java.util.*;

public class State {
    private int prosperity, food, materials, energy, money_spent, TotalMoneyOwned;
    private int delayFood, delayMaterials, delayEnergy;
    private int depth;

    //enum for actions (WAIT, BUILD1, BUILD2, REQUESTFOOD, REQUESTMATERIALS, REQUESTENERGY)
    private ActionsEnum action;


    //Constructor 2 that contains prosperity, food, materials, energy, money_spent
    public State(int prosperity, int food, int materials, int energy,
                 int money_spent, int TotalMoneyOwned,
                 int delayFood, int delayMaterials, int delayEnergy, int depth, ActionsEnum action) {

        this.prosperity = prosperity;
        this.food = food;
        this.materials = materials;
        this.energy = energy;
        this.money_spent = money_spent;
        this.TotalMoneyOwned = TotalMoneyOwned;
        this.delayFood = delayFood;
        this.delayMaterials = delayMaterials;
        this.delayEnergy = delayEnergy;
        this.depth = depth;
        this.action = action;
    }

    public ActionsEnum getAction() {
        return action;
    }

    public int getProsperity() {
        return prosperity;
    }

    public int getFood() {
        return food;
    }

    public int getMaterials() {
        return materials;
    }

    public int getEnergy() {
        return energy;
    }
    public int getMoney_spent() {
        return money_spent;
    }

    public int getTotalMoneyOwned() {
        return TotalMoneyOwned;
    }

    public int getDelayFood() {
        return delayFood;
    }

    public int getDelayMaterials() {
        return delayMaterials;
    }

    public int getDelayEnergy() {
        return delayEnergy;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setProsperity(int prosperity) {
        if (prosperity < 0) {
            prosperity = 0;
        }
        else if (prosperity > 100) {
            prosperity = 100;
        }
        this.prosperity = prosperity;
    }

    public void setFood(int food) {
        if (food < 0) {
            food = 0;
        }
        else if (food > 50) {
            food = 50;
        }
        this.food = food;
    }

    public void setMaterials(int materials) {
        if (materials < 0) {
            materials = 0;
        }
        else if (materials > 50) {
            materials = 50;
        }
        this.materials = materials;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            energy = 0;
        }
        else if (energy > 50) {
            energy = 50;
        }
        this.energy = energy;
    }

    public void setMoney_spent(int money_spent) {
        // max money is 100000
        if (money_spent < 0) {
            money_spent = 0;
        }
        else if (money_spent > 100000) {
            throw new IllegalArgumentException("Maximum money is 100000.");
        }
        this.money_spent = money_spent;
    }

    public void setTotalMoneyOwned(int TotalMoneyOwned) {
        // max money is 100000
        if (TotalMoneyOwned < 0) {
            TotalMoneyOwned = 0;
        }
        else if (TotalMoneyOwned > 100000) {
            throw new IllegalArgumentException("Maximum money is 100000.");
        }
        this.TotalMoneyOwned = TotalMoneyOwned;
    }

    public void setDelayFood(int delayFood) {
        this.delayFood = delayFood;
    }

    public void setDelayMaterials(int delayMaterials) {
        this.delayMaterials = delayMaterials;
    }

    public void setDelayEnergy(int delayEnergy) {
        this.delayEnergy = delayEnergy;
    }

    //Generate successors according to the 6 actions
    public List<State> generateSuccessors(Actions actions) {
        List<State> successors = new ArrayList<>();

        // Generate successors for each action using the LLAP class.

        // 1. RequestFood
        State nextState1 = actions.RequestFood(this);
        if (nextState1 != null) {
            System.out.println(nextState1.toString());  // for debugging
            successors.add(nextState1);
        }

        // 2. RequestEnergy
        State nextState2 = actions.RequestEnergy(this);
        if (nextState2 != null) {
            System.out.println(nextState2.toString());  // for debugging
            successors.add(nextState2);
        }

        // 3. RequestMaterials
        State nextState3 = actions.RequestMaterials(this);
        if (nextState3 != null) {
            System.out.println(nextState3.toString());  // for debugging
            successors.add(nextState3);
        }

        // 4. WAIT
        State nextState4 = actions.WAIT(this);
        if (nextState4 != null) {
            System.out.println(nextState4.toString());  // for debugging
            successors.add(nextState4);
        }

        // 5. BUILD1
        State nextState5 = actions.BUILD1(this);
        if (nextState5 != null) {
            System.out.println(nextState5.toString());  // for debugging
            successors.add(nextState5);
        }

        // 6. BUILD2
        State nextState6 = actions.BUILD2(this);
        if (nextState6 != null) {
            System.out.println(nextState6.toString());  // for debugging
            successors.add(nextState6);
        }

        return successors;
    }



    @Override
    public String toString() {
//        return "State{" +
//                "prosperity=" + prosperity +
//                ", food=" + food +
//                ", materials=" + materials +
//                ", energy=" + energy +
//                ", money_spent=" + money_spent +
//                '}';
        return "State{" +
                "prosperity=" + prosperity +
                ", food=" + food +
                ", materials=" + materials +
                ", energy=" + energy +
                ", money_spent=" + money_spent +
                ", TotalMoneyOwned=" + TotalMoneyOwned +
                ", delayFood=" + delayFood +
                ", delayMaterials=" + delayMaterials +
                ", delayEnergy=" + delayEnergy +
                ", depth=" + depth +
                ", action=" + action +
                '}';
    }

}
