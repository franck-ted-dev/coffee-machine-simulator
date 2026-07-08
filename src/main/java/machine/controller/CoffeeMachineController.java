package machine.controller;

import machine.domain.*;
import machine.service.BuyService;
import machine.service.FillService;
import machine.service.ResourceInventoryService;
import machine.service.TakeService;
import machine.ui.ConsoleUI;
import machine.ui.DrinkStatusMessageMapper;

public class CoffeeMachineController {
    private final ConsoleUI console;
    private final BuyService buyService;
    private final FillService fillService;
    private final TakeService takeService;
    private final ResourceInventoryService resourceInventoryService;
    private final DrinkStatusMessageMapper drinkStatusMessageMapper;

    public CoffeeMachineController(
            ConsoleUI console,
            BuyService buyService,
            FillService fillService,
            TakeService takeService,
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
                handleBuy();
                break;
            case "fill":
                handleFill();
                break;
            case "take":
                handleTake();
                break;
            case "remaining":
                handleRemaining();
                break;
            case "exit":
                return false;
            default:
                handleInvalidMenuResponse();
        }
        return true;
    }

    private void handleBuy(){
        String desiredDrink = console.displayDrinkMenu();

        if(desiredDrink.equals("4")){
            return;
        }

        try {
            int drinkChoice = Integer.parseInt(desiredDrink);
            DrinkStatus drinkStatus = buyService.buyDrink(drinkChoice);
            console.displayMessage(drinkStatusMessageMapper.toMessage(drinkStatus));
        } catch (NumberFormatException e) {
            console.displayMessage("\nInvalid drink choice!\n");
        }

    }

    private void handleFill(){
        fillService.fill(console.askRefill());
    }

    private void handleRemaining(){
        console.displayInventory(resourceInventoryService.getInventory());
    }

    private void handleTake(){
        console.displayCashTaken(takeService.take());
    }

    private void handleInvalidMenuResponse(){
        String message = "\nInvalid menu response\n";
        console.displayMessage(message);
    }
}
