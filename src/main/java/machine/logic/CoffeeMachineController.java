package machine.logic;

import machine.domain.*;
import machine.ui.ConsoleUI;

public class CoffeeMachineController {
    private final ConsoleUI console;
    private final BuyService buyService;
    private final FillService fillService;
    private final TakeService takeService;
    private final ResourceInventoryService resourceInventoryService;

    public CoffeeMachineController(ConsoleUI console, DrinkMaker drinkMaker,
                                   DrinkCatalog drinkCatalog, CashUnit cashUnit, Stock stock) {
        this.console = console;
        this.buyService = new BuyService(drinkCatalog, drinkMaker, cashUnit, console);
        this.fillService = new FillService(console, stock);
        this.takeService = new TakeService(cashUnit, console);
        this.resourceInventoryService = new ResourceInventoryService(stock, cashUnit, console);
    }

    public void processMainMenuResponse(String mainMenuResponse) {
        mainMenuResponse = mainMenuResponse.toLowerCase();

        switch (mainMenuResponse){
            case "buy":
                String desiredDrink = console.displayDrinkMenu();
                buyService.execute(desiredDrink);
                break;
            case "fill":
                fillService.execute();
                break;
            case "take":
                takeService.execute();
                break;
            case "remaining":
                resourceInventoryService.execute();
                break;
            case "exit":
                exit();
            default:
                String message = "\nInvalid menu response\n";
                console.displayMessage(message);
        }
    }

    public void exit(){
        System.exit(0);
    }
}
