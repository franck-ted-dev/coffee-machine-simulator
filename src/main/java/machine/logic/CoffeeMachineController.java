package machine.logic;

import machine.domain.*;
import machine.ui.ConsoleUI;

public class CoffeeMachineController {
    private final CashUnit cashUnit;
    private final Stock stock;
    private final ConsoleUI console;
    private final BuyService buyService;
    private final FillService fillService;

    public CoffeeMachineController(ConsoleUI console, DrinkMaker drinkMaker,
                                   DrinkCatalog drinkCatalog, CashUnit cashUnit, Stock stock) {
        this.cashUnit = cashUnit;
        this.stock = stock;
        this.console = console;
        this.buyService = new BuyService(drinkCatalog, drinkMaker, cashUnit, console);
        this.fillService = new FillService(console, stock);

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
        String message = """
                
                I gave you $%d
                """.formatted(cashUnit.takeMoney());
        console.displayMessage(message);
    }

    public void remaining(){
        String resourceInventory = String.format("""
                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee
                %d disposable cups
                $%d of money
                """, stock.getWaterQuantity(), stock.getMilkQuantity(), stock.getCoffeeQuantity(), stock.getDisposableCups(), cashUnit.getBalance());
        console.displayMessage(resourceInventory);
    }

    public void exit(){
        System.exit(0);
    }
}
