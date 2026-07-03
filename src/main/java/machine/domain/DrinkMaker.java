package machine.domain;

public class DrinkMaker {
    private final Stock stock;

    public DrinkMaker(Stock stock) {
        this.stock = stock;
    }

    public DrinkStatus makeDrink(Drink drink) {
        final int WATER_QUANTITY_FOR_DRINK = drink.getWaterQuantity();
        final int MILK_QUANTITY_FOR_DRINK = drink.getMilkQuantity();
        final int COFFEE_QUANTITY_FOR_DRINK = drink.getCoffeeQuantity();

        if(stock.getWaterQuantity() < WATER_QUANTITY_FOR_DRINK){  // done
            return DrinkStatus.NOT_ENOUGH_WATER;
        }

        if(stock.getMilkQuantity() < MILK_QUANTITY_FOR_DRINK){   // done
            return DrinkStatus.NOT_ENOUGH_MILK;
        }

        if(stock.getCoffeeQuantity() < COFFEE_QUANTITY_FOR_DRINK){   // done
            return DrinkStatus.NOT_ENOUGH_COFFEE;
        }

        if(stock.getDisposableCups() == 0){   // done
            return DrinkStatus.NO_CUPS;
        }

        stock.updateWaterQuantity(-WATER_QUANTITY_FOR_DRINK);  // done
        stock.updateMilkQuantity(-MILK_QUANTITY_FOR_DRINK);   // done
        stock.updateCoffeeQuantity(-COFFEE_QUANTITY_FOR_DRINK);   // done
        stock.updateDisposableCups(-1);  // done

        return DrinkStatus.OKAY;
    }

}
