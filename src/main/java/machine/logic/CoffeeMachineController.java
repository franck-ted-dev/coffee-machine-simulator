package machine.logic;

import machine.domain.*;
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

                if(desiredDrink.equals("4")){
                    break;
                }
                try {
                    int drinkChoice = Integer.parseInt(desiredDrink);
                    DrinkStatus drinkStatus = buyService.buyDrink(drinkChoice);
                    console.displayMessage(drinkStatusMessageMapper.toMessage(drinkStatus));
                }catch (NumberFormatException e){
                    console.displayMessage("\nInvalid drink choice!\n");
                }
                break;
            case "fill":
                fillService.fill(console.askRefill());
                break;
            case "take":
                console.displayCashTaken(takeService.take());
                break;
            case "remaining":
                console.displayInventory(resourceInventoryService.getInventory());
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
