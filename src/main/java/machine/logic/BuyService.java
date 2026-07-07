package machine.logic;

import machine.domain.*;

public class BuyService {
    private final DrinkCatalog drinkCatalog;
    private final DrinkMaker drinkMaker;
    private final CashUnit cashUnit;

    public BuyService(DrinkCatalog drinkCatalog,  DrinkMaker drinkMaker, CashUnit cashUnit) {
        this.drinkCatalog = drinkCatalog;
        this.drinkMaker = drinkMaker;
        this.cashUnit = cashUnit;
    }

    public DrinkStatus buyDrink(int choiceDrink){
        choiceDrink = choiceDrink - 1;   // handle the indexGap

        if(!drinkCatalog.isAvailable(choiceDrink)) {
            return DrinkStatus.INVALID_DRINK;
        }

        Drink drink = drinkCatalog.getDrink(choiceDrink);
        DrinkStatus drinkStatus = drinkMaker.prepareDrink(drink);
        if (drinkStatus == DrinkStatus.OKAY) {
            cashUnit.collectMoney(drink.getPrice());
        }

        return drinkStatus;
    }

}
