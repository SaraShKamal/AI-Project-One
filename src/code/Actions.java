package code;

public class Actions {

    private Initials init;

    public Actions(Initials init) {
        this.init = init;
    }
    public State RequestFood(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = init.getUnitPriceFood() + init.getUnitPriceMaterials() + init.getUnitPriceEnergy();
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;


        if (s.getDelayFood() != 0 || s.getDelayMaterials() != 0 || s.getDelayEnergy() != 0 ||
                s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }
        return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, init.getDelayRequestFood(), s.getDelayMaterials(), s.getDelayEnergy(),
                s.getDepth()+1,ActionsEnum.REQUESTFOOD);
    }

    //RequestMaterials
    public State RequestMaterials(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = init.getUnitPriceFood() + init.getUnitPriceMaterials() + init.getUnitPriceEnergy();
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;


        if (s.getDelayFood() != 0 || s.getDelayMaterials() != 0 || s.getDelayEnergy() != 0 ||
                s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }
        else {
            return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                    budget, s.getDelayFood(), init.getDelayRequestMaterials(), s.getDelayEnergy(),
                    s.getDepth() + 1, ActionsEnum.REQUESTMATERIALS);
        }
    }

    //RequestEnergy
    public State RequestEnergy(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood--;
        currentMaterials--;
        currentEnergy--;
        int totalDecrease = init.getUnitPriceFood() + init.getUnitPriceMaterials() + init.getUnitPriceEnergy();
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;


        if (s.getDelayFood() != 0 || s.getDelayMaterials() != 0 || s.getDelayEnergy() != 0 ||
                s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }
        else {
            return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                    budget, s.getDelayFood(), s.getDelayMaterials(), init.getDelayRequestEnergy(),
                    s.getDepth() + 1, ActionsEnum.REQUESTENERGY);
        }
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
        int totalDecrease = init.getUnitPriceFood() + init.getUnitPriceMaterials() + init.getUnitPriceEnergy();
        currentMoneySpent += totalDecrease;
        int budget = s.getTotalMoneyOwned() - totalDecrease;

        if (s.getDelayFood()>0){
            s.setDelayFood(s.getDelayFood()-1);
            if (s.getDelayFood() == 0) {
                if (currentFood > 50)
                    currentFood = 50;
                else
                    currentFood += init.getAmountRequestFood();
            }
        }

        if (s.getDelayMaterials()>0){
            s.setDelayMaterials(s.getDelayMaterials()-1);
            if (s.getDelayMaterials() == 0) {
                if (currentMaterials > 50)
                    currentMaterials = 50;
                else
                    currentMaterials += init.getAmountRequestMaterials();
            }
        }

        if (s.getDelayEnergy()>0){
            s.setDelayEnergy(s.getDelayEnergy()-1);
            if (s.getDelayEnergy() == 0) {
                if (currentEnergy > 50)
                    currentEnergy = 50;
                else
                    currentEnergy += init.getAmountRequestEnergy();
            }
        }

        if (s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }

        return new State(s.getProsperity(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), s.getDelayEnergy(),
                s.getDepth()+1,ActionsEnum.WAIT);

    }

    //BUILD1
    public State BUILD1(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood-=init.getFoodUseBUILD1();
        currentMaterials-=init.getMaterialsUseBUILD1();
        currentEnergy-=init.getEnergyUseBUILD1();
        int totalDecrease = (init.getUnitPriceFood()*init.getFoodUseBUILD1()) +
                (init.getUnitPriceMaterials()*init.getMaterialsUseBUILD1()) +
                (init.getUnitPriceEnergy()*init.getEnergyUseBUILD1());
        currentMoneySpent += (totalDecrease+init.getPriceBUILD1());
        int budget = s.getTotalMoneyOwned() - (totalDecrease+init.getPriceBUILD1());

        if (s.getDelayFood()>0){
            s.setDelayFood(s.getDelayFood()-1);
            if (s.getDelayFood() == 0) {
                if (currentFood > 50)
                    currentFood = 50;
                else
                    currentFood += init.getAmountRequestFood();
            }
        }

        if (s.getDelayMaterials()>0){
            s.setDelayMaterials(s.getDelayMaterials()-1);
            if (s.getDelayMaterials() == 0) {
                if (currentMaterials > 50)
                    currentMaterials = 50;
                else
                    currentMaterials += init.getAmountRequestMaterials();
            }
        }

        if (s.getDelayEnergy()>0){
            s.setDelayEnergy(s.getDelayEnergy()-1);
            if (s.getDelayEnergy() == 0) {
                if (currentEnergy > 50)
                    currentEnergy = 50;
                else
                    currentEnergy += init.getAmountRequestEnergy();
            }
        }

        if (s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }

        return new State(s.getProsperity()+init.getProsperityBUILD1(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), s.getDelayEnergy(),
                s.getDepth()+1,ActionsEnum.BUILD1);

    }

    //BUILD2
    public State BUILD2(State s) {
        int currentFood = s.getFood();
        int currentMaterials = s.getMaterials();
        int currentEnergy = s.getEnergy();
        int currentMoneySpent = s.getMoney_spent();

        currentFood-=init.getFoodUseBUILD2();
        currentMaterials-=init.getMaterialsUseBUILD2();
        currentEnergy-=init.getEnergyUseBUILD2();
        int totalDecrease = (init.getUnitPriceFood()*init.getFoodUseBUILD2()) +
                (init.getUnitPriceMaterials()*init.getMaterialsUseBUILD2()) +
                (init.getUnitPriceEnergy()*init.getEnergyUseBUILD2());
        currentMoneySpent += (totalDecrease+init.getPriceBUILD2());
        int budget = s.getTotalMoneyOwned() - (totalDecrease+init.getPriceBUILD2());

        if (s.getDelayFood()>0){
            s.setDelayFood(s.getDelayFood()-1);
            if (s.getDelayFood() == 0) {
                if (currentFood > 50)
                    currentFood = 50;
                else
                    currentFood += init.getAmountRequestFood();
            }
        }

        if (s.getDelayMaterials()>0){
            s.setDelayMaterials(s.getDelayMaterials()-1);
            if (s.getDelayMaterials() == 0) {
                if (currentMaterials > 50)
                    currentMaterials = 50;
                else
                    currentMaterials += init.getAmountRequestMaterials();
            }
        }

        if (s.getDelayEnergy()>0){
            s.setDelayEnergy(s.getDelayEnergy()-1);
            if (s.getDelayEnergy() == 0) {
                if (currentEnergy > 50)
                    currentEnergy = 50;
                else
                    currentEnergy += init.getAmountRequestEnergy();
            }
        }

        if (s.getTotalMoneyOwned() == 0 || s.getFood() == 0 || s.getMaterials() == 0 || s.getEnergy() == 0) {
            return null;
        }

        return new State(s.getProsperity()+init.getProsperityBUILD2(), currentFood, currentMaterials, currentEnergy, currentMoneySpent,
                budget, s.getDelayFood(), s.getDelayMaterials(), s.getDelayEnergy(),
                s.getDepth()+1,ActionsEnum.BUILD2);


    }
}
