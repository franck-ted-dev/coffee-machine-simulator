package machine.domain;

public class Drink {
    private final String name;
    private final int waterQuantity;
    private final int milkQuantity;
    private final int coffeeQuantity;
    private final int price;

    public Drink(String name, int waterQuantity, int milkQuantity, int coffeeQuantity, int price) {
        this.name = name;
        this.waterQuantity = waterQuantity;
        this.milkQuantity = milkQuantity;
        this.coffeeQuantity = coffeeQuantity;
        this.price = price;
    }

    public String toString() {
        return name;
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

    public int getPrice() {
        return price;
    }
}
