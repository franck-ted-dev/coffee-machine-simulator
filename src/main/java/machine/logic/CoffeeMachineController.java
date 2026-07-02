package machine.logic;

import machine.domain.*;
import machine.ui.ConsoleUI;

public class CoffeeMachineController {
    private final CashUnit cashUnit;
    private final Stock stock;
    private final DrinkMaker drinkMaker;
    private final DrinkCatalog drinkCatalog;
    private final ConsoleUI console;

    public CoffeeMachineController(ConsoleUI console) {
        this.cashUnit = new CashUnit();
        this.stock = new Stock();
        this.drinkMaker = new DrinkMaker(stock);
        this.drinkCatalog = new DrinkCatalog();
        this.console = console;
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
        int drinkChoice = Integer.parseInt(desiredDrink);
        buyDrink(drinkChoice);
    }

    public void buyDrink(int choiceDrink){
        if(choiceDrink == 4){  // case back to main menu
            return;
        }

        choiceDrink = choiceDrink - 1;   // handle the indexGap

        if(drinkCatalog.isAvailable(choiceDrink)){
            Drink drink = drinkCatalog.getDrink(choiceDrink);
            String drinkStatus = drinkMaker.makeDrink(drink);
            if(drinkStatus.equalsIgnoreCase("okay")){
                cashUnit.collectMoney(drink.getPrice());
                String message = "Making you a " + drink + "!\n";
                console.displayMessage(message);
            }else{
                console.displayMessage(drinkStatus);
            }
            return;
        }

        String message = "\nInvalid choice\n";
        console.displayMessage(message);
    }

    public void fill(){
        String message = """
                
                Write how many ml of water you want to add:
                """;
        String response = console.displayMessageAndReplyResponse(message);
        int addedWater = Integer.parseInt(response);
        stock.updateWaterQuantity(addedWater);

        message = """
                
                Write how many ml of milk you want to add:
                """;
        response = console.displayMessageAndReplyResponse(message);
        int addedMilk = Integer.parseInt(response);
        stock.updateMilkQuantity(addedMilk);

        message = """
                
                Write how many g of coffee you want to add:
                """;
        response = console.displayMessageAndReplyResponse(message);
        int addedCoffee = Integer.parseInt(response);
        stock.updateCoffeeQuantity(addedCoffee);

        message = """
                
                Write how many disposable cups you want to add:
                """;
        response = console.displayMessageAndReplyResponse(message);
        int addedCups = Integer.parseInt(response);
        stock.updateDisposableCups(addedCups);
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
