package machine;

public class StockManager {
    private final Stock stock;

    public StockManager() {
        stock = new Stock();
    }

    public void updateWater(int quantity) {
        this.stock.updateWaterQuantity(quantity);
    }

    public void updateCoffee(int quantity) {
        this.stock.updateCoffeeQuantity(quantity);
    }

    public void updateCups(int quantity) {
        this.stock.updateDisposableCups(quantity);
    }

    public void updateMilk(int quantity) {
        this.stock.updateMilkQuantity(quantity);
    }

    public int getWater(){
        return this.stock.getWaterQuantity();
    }

    public int getCoffee(){
        return this.stock.getCoffeeQuantity();
    }

    public int getMilk(){
        return this.stock.getMilkQuantity();
    }

    public int getDisposableCups(){
        return this.stock.getDisposableCups();
    }

}
