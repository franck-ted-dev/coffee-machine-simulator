package machine.logic;

import machine.domain.*;
import machine.ui.ConsoleUI;

public class BuyService {
    private final DrinkCatalog drinkCatalog;
    private final DrinkMaker drinkMaker;
    private final CashUnit cashUnit;
    private final ConsoleUI console;

    public BuyService(DrinkCatalog drinkCatalog,  DrinkMaker drinkMaker, CashUnit cashUnit, ConsoleUI console) {
        this.drinkCatalog = drinkCatalog;
        this.drinkMaker = drinkMaker;
        this.cashUnit = cashUnit;
        this.console = console;
    }

    public void buy(String desiredDrink){
        int drinkChoice = Integer.parseInt(desiredDrink);
        processDrinkStatus(buyDrink(drinkChoice));
    }

    public DrinkStatus buyDrink(int choiceDrink){
        choiceDrink = choiceDrink - 1;   // handle the indexGap

        if(drinkCatalog.isAvailable(choiceDrink)){
            Drink drink = drinkCatalog.getDrink(choiceDrink);
            DrinkStatus drinkStatus = drinkMaker.makeDrink(drink);
            if(drinkStatus == DrinkStatus.OKAY){
                cashUnit.collectMoney(drink.getPrice());
            }
            return drinkStatus;
        }else{
            return DrinkStatus.INVALID_DRINK;
        }
    }

    public void processDrinkStatus(DrinkStatus drinkStatus){
        String message;
        switch (drinkStatus){
            case OKAY:
                message = "\nMaking your drink!\n";
                console.displayMessage(message);
                break;
            case NOT_ENOUGH_MILK:
                message = "\nNot enough milk!\n";
                console.displayMessage(message);
                break;
            case NOT_ENOUGH_WATER:
                message = "\nNot enough water!\n";
                console.displayMessage(message);
                break;
            case NOT_ENOUGH_COFFEE:
                message = "\nNot enough coffee!\n";
                console.displayMessage(message);
                break;
            case NO_CUPS:
                message = "\nNot enough disposable cups!\n";
                console.displayMessage(message);
                break;
            case INVALID_DRINK:
                message = "\nInvalid choice!\n";
                console.displayMessage(message);
                break;
        }
    }
}
