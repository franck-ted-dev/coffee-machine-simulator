package machine.logic;

import machine.domain.*;
import machine.request.RefillRequest;
import machine.ui.ConsoleUI;
import machine.ui.DrinkStatusMessageMapper;

public class CoffeeMachineController {
    private final ConsoleUI console;
    private final BuyService buyService;
    private final FillService fillService;
    private final TakeService takeService;
    private final ResourceInventoryService resourceInventoryService;
    private final DrinkStatusMessageMapper drinkStatusMessageMapper;

    public CoffeeMachineController(ConsoleUI console, BuyService buyService,
                                   FillService fillService, TakeService takeService,
                                   ResourceInventoryService resourceInventoryService,
                                   DrinkStatusMessageMapper drinkStatusMessageMapper) {
        this.console = console;
        this.buyService = buyService;
        this.fillService = fillService;
        this.takeService = takeService;
        this.resourceInventoryService = resourceInventoryService;
        this.drinkStatusMessageMapper = drinkStatusMessageMapper;
    }

    public boolean processMainMenuResponse(String mainMenuResponse) {
        mainMenuResponse = mainMenuResponse.toLowerCase();

        switch (mainMenuResponse){
            case "buy":
                String desiredDrink = console.displayDrinkMenu();
                int drinkChoice = Integer.parseInt(desiredDrink);
                DrinkStatus drinkStatus = buyService.buyDrink(drinkChoice);
                console.displayMessage(drinkStatusMessageMapper.toMessage(drinkStatus));
                break;
            case "fill":
                int water = console.askWater();
                int milch  = console.askMilch();
                int coffee = console.askCoffee();
                int cups = console.askCup();

                RefillRequest refillRequest = new RefillRequest(water, milch, coffee, cups);
                fillService.fill(refillRequest);
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
