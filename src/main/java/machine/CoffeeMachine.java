package machine;

import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner input;
    private String choice;
    private final CashUnit cashUnit;
    private final StockManager stockManager;
    private final DrinkMaker drinkMaker;
    private final DrinkCatalog drinkCatalog;    // recently added

    public CoffeeMachine() {
        this.input = new Scanner(System.in);
        this.cashUnit = new CashUnit();
        this.stockManager = new StockManager();
        this.drinkMaker = new DrinkMaker(stockManager);
        this.drinkCatalog = new DrinkCatalog();   // recently added
    }

    public void start(){
        while(true){
            this.processMainMenu();
            this.processMainMenuResponse();
        }
    }

    public void processMainMenu(){
        String mainMenu = """
                
                Write action (buy, fill, take, remaining, exit):
                """;
        System.out.print(mainMenu);
        System.out.print("> ");
        this.choice = input.nextLine();
    }

    public void processMainMenuResponse(){
        choice = choice.toLowerCase();

        switch (choice){
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
                System.out.println("Invalid choice");
        }
    }

    public int processDrinkMenu(){
        List<Drink> drinks = drinkCatalog.getDrinks();     // recently modified
        int index = 1;

        StringBuilder drinkList = new StringBuilder("\n");
        drinkList.append("What do you want to buy ?\n");
        for(Drink ignored : drinks) {
            drinkList.append("\t")
                    .append(index).append(" - ")
                    .append(drinks.get(index-1)).append("\n");
            index++;
        }
        drinkList.append("\t")
                .append(index)
                .append(" - back to main menu\n");
        System.out.print(drinkList);
        System.out.print("> ");
        int choiceDrink = Integer.parseInt(input.nextLine());
        if(choiceDrink == index){
            choiceDrink = 0;
        }
        return choiceDrink;
    }

    public void buy(){
        int drinkChoice = processDrinkMenu();
        buyDrink(drinkChoice);
    }

    public void buyDrink(int choiceDrink){
        if(choiceDrink == 0){  // case back to main menu
            return;
        }

        choiceDrink = choiceDrink - 1;   // handle the indexGap

        if(drinkCatalog.isAvailable(choiceDrink)){
            Drink drink = drinkCatalog.getDrink(choiceDrink);
            String drinkStatus = drinkMaker.makeDrink(drink);
            if(drinkStatus.equalsIgnoreCase("okay")){
                cashUnit.collectMoney(drink.getPrice());
                System.out.println("Making you a " + drink + "!");
            }else{
                System.out.print(drinkStatus);
            }
            return;
        }

        System.out.println("Invalid choice");
    }

    public void fill(){                                        // done
        System.out.println();
        System.out.println("Write how many ml of water you want to add:");
        System.out.print("> ");
        int addedWater = Integer.parseInt(input.nextLine());
        stockManager.updateWater(addedWater);

        System.out.println("Write how many ml of milk you want to add:");
        System.out.print("> ");
        int addedMilk = Integer.parseInt(input.nextLine());
        stockManager.updateMilk(addedMilk);

        System.out.println("Write how many g of coffee you want to add:");
        System.out.print("> ");
        int addedCoffee = Integer.parseInt(input.nextLine());
        stockManager.updateCoffee(addedCoffee);

        System.out.println("Write how many disposable cups you want to add:");
        System.out.print("> ");
        int addedCups = Integer.parseInt(input.nextLine());
        stockManager.updateCups(addedCups);
    }

    public void take(){
        System.out.println();
        System.out.println("I gave you $" + cashUnit.takeMoney());  // already done
    }

    public void remaining(){                            // already done
        String resourceInventory = String.format("""
                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee
                %d disposable cups
                $%d of money
                """, stockManager.getWater(), stockManager.getMilk(), stockManager.getCoffee(), stockManager.getDisposableCups(), cashUnit.getBalance()); // a. done
        System.out.print(resourceInventory);
    }

    public void exit(){
        System.exit(0);
    }
}
