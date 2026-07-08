package machine;

import machine.controller.CoffeeMachineController;
import machine.domain.CashUnit;
import machine.domain.DrinkCatalog;
import machine.service.DrinkMaker;
import machine.domain.Stock;
import machine.service.*;
import machine.ui.ConsoleUI;
import machine.ui.DrinkStatusMessageMapper;

public class CoffeeMachine {
    private final CoffeeMachineController controller;
    private final ConsoleUI console;

    public CoffeeMachine() {
        this.console = new ConsoleUI();

        CashUnit cashUnit = new CashUnit();
        DrinkCatalog drinkCatalog = new DrinkCatalog();
        Stock stock = new Stock();
        DrinkMaker drinkMaker = new DrinkMaker(stock);

        BuyService buyService = new BuyService(drinkCatalog, drinkMaker, cashUnit);
        FillService fillService = new FillService(stock);
        TakeService takeService = new TakeService(cashUnit);
        ResourceInventoryService resourceInventoryService = new ResourceInventoryService(stock, cashUnit);

        DrinkStatusMessageMapper drinkStatusMessageMapper = new DrinkStatusMessageMapper();

        this.controller = new CoffeeMachineController(
                console,
                buyService,
                fillService,
                takeService,
                resourceInventoryService,
                drinkStatusMessageMapper);
    }

    public void start(){
        boolean running = true;

        while(running){
            String command = console.displayMainMenu();
            running = controller.processMainMenuResponse(command);
        }
    }
}
