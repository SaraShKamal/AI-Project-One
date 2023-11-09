package code;

public class State {
    private int prosperity;
    private int food;
    private int materials;
    private int energy;
    private int money=100000;
    private int money_spent;
    private int unitPriceFood,unitPriceMaterials,unitPriceEnergy,amountRequestFood,
            delayRequestFood,amountRequestMaterials,delayRequestMaterials,amountRequestEnergy,
            delayRequestEnergy,priceBUILD1,foodUseBUILD1,materialsUseBUILD1,energyUseBUILD1,
            prosperityBUILD1,priceBUILD2,foodUseBUILD2,materialsUseBUILD2,energyUseBUILD2,prosperityBUILD2;

    // Constructor to initialize the state from the initialState string.
    public State(String initialState) {
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
        } else {
            // Throw an exception if the initial state string is not valid.
            throw new IllegalArgumentException("Invalid initial state string.");
        }
    }

    //Constructor 2 that contains prosperity, food, materials, energy, money_spent
    public State(int prosperity, int food, int materials, int energy, int money_spent) {
        this.prosperity = prosperity;
        this.food = food;
        this.materials = materials;
        this.energy = energy;
        this.money_spent = money_spent;
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

    public int getMoney() {
        return money;
    }

    public int getMoney_spent() {
        return money_spent;
    }

    public int getUnitPriceFood() {
        return unitPriceFood;
    }

    public int getUnitPriceMaterials() {
        return unitPriceMaterials;
    }

    public int getUnitPriceEnergy() {
        return unitPriceEnergy;
    }

    public int getAmountRequestFood() {
        return amountRequestFood;
    }

    public int getDelayRequestFood() {
        return delayRequestFood;
    }

    public int getAmountRequestMaterials() {
        return amountRequestMaterials;
    }

    public int getDelayRequestMaterials() {
        return delayRequestMaterials;
    }

    public int getAmountRequestEnergy() {
        return amountRequestEnergy;
    }

    public int getDelayRequestEnergy() {
        return delayRequestEnergy;
    }

    public int getPriceBUILD1() {
        return priceBUILD1;
    }

    public int getFoodUseBUILD1() {
        return foodUseBUILD1;
    }

    public int getMaterialsUseBUILD1() {
        return materialsUseBUILD1;
    }

    public int getEnergyUseBUILD1() {
        return energyUseBUILD1;
    }

    public int getProsperityBUILD1() {
        return prosperityBUILD1;
    }

    public int getPriceBUILD2() {
        return priceBUILD2;
    }

    public int getFoodUseBUILD2() {
        return foodUseBUILD2;
    }

    public int getMaterialsUseBUILD2() {
        return materialsUseBUILD2;
    }

    public int getEnergyUseBUILD2() {
        return energyUseBUILD2;
    }

    public int getProsperityBUILD2() {
        return prosperityBUILD2;
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

    public void setMoney(int money) {
        // max money is 100000
        if (money < 0) {
            throw new IllegalArgumentException("Money not sufficient.");
        }
        else if (money > 100000) {
            money = 100000;
        }
        this.money = money;
    }

    public void setAmountRequestFood(int amountRequestFood) {
        this.amountRequestFood = amountRequestFood;
    }

    public void setDelayRequestFood(int delayRequestFood) {
        this.delayRequestFood = delayRequestFood;
    }

    public void setAmountRequestMaterials(int amountRequestMaterials) {
        this.amountRequestMaterials = amountRequestMaterials;
    }

    public void setDelayRequestMaterials(int delayRequestMaterials) {
        this.delayRequestMaterials = delayRequestMaterials;
    }

    public void setAmountRequestEnergy(int amountRequestEnergy) {
        this.amountRequestEnergy = amountRequestEnergy;
    }

    public void setDelayRequestEnergy(int delayRequestEnergy) {
        this.delayRequestEnergy = delayRequestEnergy;
    }


    public void setMoney_spent(int money_spent) {
        // max money is 100000
        if (money_spent < 0) {
            money_spent = 0;
        }
        else if (money_spent > 100000) {
            money_spent = 100000;
        }
        this.money_spent = money_spent;
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
