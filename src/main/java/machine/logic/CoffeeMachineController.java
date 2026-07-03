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
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                exit();
            default:
                String message = "\nInvalid menu response\n";
                console.displayMessage(message);
        }
    }

    public void buy(){
        String desiredDrink = console.displayDrinkMenu();
        buyService.buy(desiredDrink);
    }

    public void fill(){
        fillService.fill();
    }

    public void take(){
        takeService.execute();
    }

    public void remaining(){
        resourceInventoryService.execute();
    }

    public void exit(){
        System.exit(0);
    }
}
