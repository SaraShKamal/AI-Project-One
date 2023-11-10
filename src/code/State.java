package code;

public class State {
    private int prosperity, food, materials, energy, money_spent, TotalMoneyOwned;
    private int delayFood, delayMaterials, delayEnergy;
    private int depth;


    //Constructor 2 that contains prosperity, food, materials, energy, money_spent
    public State(int prosperity, int food, int materials, int energy,
                 int money_spent, int TotalMoneyOwned,
                 int delayFood, int delayMaterials, int delayEnergy, int depth) {

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

    @Override
    public String toString() {
        return "State{" +
                "prosperity=" + prosperity +
                ", food=" + food +
                ", materials=" + materials +
                ", energy=" + energy +
                ", money_spent=" + money_spent +
                '}';
    }

}
