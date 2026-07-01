package machine;

import java.util.ArrayList;
import java.util.List;

public class DrinkMaker {
    private final StockManager stockManager;
    private final List<Drink> drinks;

    public DrinkMaker(StockManager stockManager) {
        this.stockManager = stockManager;
        this.drinks = new ArrayList<>();
        Drink espresso = new Drink("Espresso", 250, 0, 16, 4);
        Drink latte = new Drink("Latte", 250, 75, 20, 7);
        Drink cappuccino = new Drink("Cappuccino", 200, 100, 12, 6);
        drinks.add(espresso);
        drinks.add(latte);
        drinks.add(cappuccino);
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public String makeDrink(Drink drink) {
        final int WATER_QUANTITY_FOR_DRINK = drink.getWaterQuantity();
        final int MILK_QUANTITY_FOR_DRINK = drink.getMilkQuantity();
        final int COFFEE_QUANTITY_FOR_DRINK = drink.getCoffeeQuantity();
        StringBuilder drinkStatus = new StringBuilder();

        if(stockManager.getWater() < WATER_QUANTITY_FOR_DRINK){  // done
            drinkStatus.append("Sorry, not enough water\n");
        }

        if(stockManager.getMilk() < MILK_QUANTITY_FOR_DRINK){   // done
            drinkStatus.append("Sorry, not enough milk\n");
        }

        if(stockManager.getCoffee() < COFFEE_QUANTITY_FOR_DRINK){   // done
            drinkStatus.append("Sorry, not enough coffee\n");
        }

        if(stockManager.getDisposableCups() == 0){   // done
            drinkStatus.append("Sorry, not enough disposable cups\n");
        }

        if(drinkStatus.isEmpty()){
            stockManager.updateWater(-WATER_QUANTITY_FOR_DRINK);  // done
            stockManager.updateMilk(-MILK_QUANTITY_FOR_DRINK);   // done
            stockManager.updateCoffee(-COFFEE_QUANTITY_FOR_DRINK);   // done
            stockManager.updateCups(-1);  // done
            drinkStatus.append("OKAY");
        }

        return drinkStatus.toString();
    }

}
