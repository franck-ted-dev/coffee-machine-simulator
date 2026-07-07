package machine.logic;

import machine.domain.Drink;
import machine.domain.DrinkStatus;
import machine.domain.Stock;

public class DrinkMaker {
    private final Stock stock;

    public DrinkMaker(Stock stock) {
        this.stock = stock;
    }

    public DrinkStatus prepareDrink(Drink drink) {
        final int WATER_QUANTITY_FOR_DRINK = drink.getWaterQuantity();
        final int MILK_QUANTITY_FOR_DRINK = drink.getMilkQuantity();
        final int COFFEE_QUANTITY_FOR_DRINK = drink.getCoffeeQuantity();

        if(!stock.hasEnoughWater(WATER_QUANTITY_FOR_DRINK)){  // done
            return DrinkStatus.NOT_ENOUGH_WATER;
        }

        if(stock.hasEnoughMilk(MILK_QUANTITY_FOR_DRINK)){   // done
            return DrinkStatus.NOT_ENOUGH_MILK;
        }

        if(stock.hasEnoughCoffee(COFFEE_QUANTITY_FOR_DRINK)){   // done
            return DrinkStatus.NOT_ENOUGH_COFFEE;
        }

        if(!stock.hasDisposableCups()){   // done
            return DrinkStatus.NO_CUPS;
        }

        stock.consume(WATER_QUANTITY_FOR_DRINK,
                MILK_QUANTITY_FOR_DRINK,
                COFFEE_QUANTITY_FOR_DRINK,
                1);

        return DrinkStatus.OKAY;
    }

}
