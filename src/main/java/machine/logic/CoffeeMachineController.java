package machine.logic;

import machine.domain.*;
import machine.ui.ConsoleUI;

public class CoffeeMachineController {
    private final ConsoleUI console;
    private final BuyService buyService;
    private final FillService fillService;
    private final TakeService takeService;
    private final ResourceInventoryService resourceInventoryService;

    public CoffeeMachineController(ConsoleUI console, BuyService buyService,
                                   FillService fillService, TakeService takeService,
                                   ResourceInventoryService resourceInventoryService) {
        this.console = console;
        this.buyService = buyService;
        this.fillService = fillService;
        this.takeService = takeService;
        this.resourceInventoryService = resourceInventoryService;
    }

    public boolean processMainMenuResponse(String mainMenuResponse) {
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
                return false;
            default:
                String message = "\nInvalid menu response\n";
                console.displayMessage(message);
        }
        return true;
    }
}
