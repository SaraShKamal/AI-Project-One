package code;

public class State {
    private int prosperity;
    private int food;
    private int materials;
    private int energy;
    private int money;

    public State(int prosperity, int food, int materials, int energy, int money) {
        this.prosperity = prosperity;
        this.food = food;
        this.materials = materials;
        this.energy = energy;
        this.money = money;
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

}
