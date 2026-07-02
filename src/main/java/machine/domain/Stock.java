package machine.domain;

public class Stock {
    private int waterQuantity;
    private int milkQuantity;
    private int coffeeQuantity;
    private int disposableCups;

    public Stock(){
        this.waterQuantity = 400;
        this.milkQuantity = 540;
        this.coffeeQuantity = 120;
        this.disposableCups = 9;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public int getMilkQuantity() {
        return milkQuantity;
    }

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void updateWaterQuantity(int waterQuantity) {
        this.waterQuantity += waterQuantity;
    }

    public void updateMilkQuantity(int milkQuantity) {
        this.milkQuantity += milkQuantity;
    }

    public void updateCoffeeQuantity(int coffeeQuantity) {
        this.coffeeQuantity += coffeeQuantity;
    }

    public void updateDisposableCups(int disposableCups) {
        this.disposableCups += disposableCups;
    }
}
