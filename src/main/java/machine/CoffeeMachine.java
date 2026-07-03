package machine;

import machine.domain.CashUnit;
import machine.domain.DrinkCatalog;
import machine.domain.DrinkMaker;
import machine.domain.Stock;
import machine.logic.*;
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
        BuyService buyService = new BuyService(drinkCatalog, drinkMaker, cashUnit, console);
        FillService fillService = new FillService(console, stock);
        TakeService takeService = new TakeService(cashUnit, console);
        ResourceInventoryService resourceInventoryService = new ResourceInventoryService(stock, cashUnit, console);
        this.controller = new CoffeeMachineController(console, buyService, fillService, takeService, resourceInventoryService);
    }

    public void start(){
        boolean running = true;
        while(running){
            running = controller.processMainMenuResponse(console.displayMainMenu());
        }
    }
}
