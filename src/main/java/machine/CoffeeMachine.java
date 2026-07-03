package machine;

import machine.domain.CashUnit;
import machine.domain.DrinkCatalog;
import machine.domain.DrinkMaker;
import machine.domain.Stock;
import machine.logic.CoffeeMachineController;
import machine.ui.ConsoleUI;

public class CoffeeMachine {
    private final CoffeeMachineController controller;
    private final ConsoleUI console;

    public CoffeeMachine() {
        this.console = new ConsoleUI();
        CashUnit cashUnit = new CashUnit();
        DrinkCatalog drinkCatalog = new DrinkCatalog();
        Stock stock = new Stock();
        DrinkMaker drinkMaker = new DrinkMaker(stock);
        this.controller = new CoffeeMachineController(console, drinkMaker, drinkCatalog, cashUnit, stock);
    }

    public void start(){
        while(true){
            controller.processMainMenuResponse(console.displayMainMenu());
        }
    }

}
