package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int waterQuantity;
    private int milkQuantity;
    private int coffeeQuantity;
    private int disposableCups;
    private final Scanner input;
    private String choice;
    private CashUnit cashUnit;

    public CoffeeMachine() {
        this.waterQuantity = 400;
        this.milkQuantity = 540;
        this.coffeeQuantity = 120;
        this.disposableCups = 9;
        this.input = new Scanner(System.in);
        this.cashUnit = new CashUnit();
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
        if(choice.equalsIgnoreCase("buy")){
            this.buy();
        }

        if(choice.equalsIgnoreCase("fill")){
            this.fill();
        }

        if(choice.equalsIgnoreCase("take")){
            this.take();
        }

        if(choice.equalsIgnoreCase("remaining")){
            this.remaining();
        }

        if(choice.equalsIgnoreCase("exit")){
            this.exit();
        }
    }

    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - to main menu:");
        System.out.print("> ");
        int drink = Integer.parseInt(input.nextLine());
        switch (drink) {
            case 1:
                this.buyEspresso();
                break;
            case 2:
                this.buyLatte();
                break;
            case 3:
                this.buyCappuccino();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid drink");
        }
    }

    public void buyEspresso(){
        Drink espresso = new Drink("Espresso", 250, 0, 16, 4);
        final int WATER_QUANTITY_FOR_ESPRESSO = espresso.getWaterQuantity();
        final int MILK_QUANTITY_FOR_ESPRESSO = espresso.getMilkQuantity();
        final int COFFEE_QUANTITY_FOR_ESPRESSO = espresso.getCoffeeQuantity();
        final int PRICE_FOR_ESPRESSO = espresso.getPrice();
        StringBuilder missingResources = new StringBuilder();

        if(this.waterQuantity >= WATER_QUANTITY_FOR_ESPRESSO){
            this.waterQuantity -= WATER_QUANTITY_FOR_ESPRESSO;
        }else{
            missingResources.append("Sorry, not enough water\n");
        }

        if(this.milkQuantity >= MILK_QUANTITY_FOR_ESPRESSO){
            this.milkQuantity -= MILK_QUANTITY_FOR_ESPRESSO;
        }else{
            missingResources.append("Sorry, not enough milk\n");
        }

        if(this.coffeeQuantity >= COFFEE_QUANTITY_FOR_ESPRESSO){
            this.coffeeQuantity -= COFFEE_QUANTITY_FOR_ESPRESSO;
        }else{
            missingResources.append("Sorry, not enough coffee\n");
        }

        if(this.disposableCups > 0){
            this.disposableCups--;
        }else{
            missingResources.append("Sorry, not enough disposable cups\n");
        }

        if(missingResources.isEmpty()){
            cashUnit.collectMoney(PRICE_FOR_ESPRESSO);  // CashUnit collects the money for the drink
            System.out.println("Making you a espresso!");
        }else{
            System.out.print(missingResources);
        }
    }

    public void buyLatte(){
        Drink latte = new Drink("Latte", 250, 75, 20, 7);
        final int WATER_QUANTITY_FOR_LATTE = latte.getWaterQuantity();
        final int MILK_QUANTITY_FOR_LATTE = latte.getMilkQuantity();
        final int COFFEE_QUANTITY_FOR_LATTE = latte.getCoffeeQuantity();
        final int PRICE_FOR_LATTE = latte.getPrice();
        StringBuilder missingResources = new StringBuilder();

        if(this.waterQuantity >= WATER_QUANTITY_FOR_LATTE){
            this.waterQuantity -= WATER_QUANTITY_FOR_LATTE;
        }else{
            missingResources.append("Sorry, not enough water\n");
        }

        if(this.milkQuantity >= MILK_QUANTITY_FOR_LATTE){
            this.milkQuantity -= MILK_QUANTITY_FOR_LATTE;
        }else{
            missingResources.append("Sorry, not enough milk\n");
        }

        if(this.coffeeQuantity >= COFFEE_QUANTITY_FOR_LATTE){
            this.coffeeQuantity -= COFFEE_QUANTITY_FOR_LATTE;
        }else{
            missingResources.append("Sorry, not enough coffee\n");
        }

        if(this.disposableCups > 0){
            this.disposableCups--;
        }else{
            missingResources.append("Sorry, not enough disposable cups\n");
        }

        if(missingResources.isEmpty()){
            cashUnit.collectMoney(PRICE_FOR_LATTE);    // CashUnit collects the money for the drink
            System.out.println("Making you a latte!");
        }else{
            System.out.print(missingResources);
        }
    }

    public void buyCappuccino(){
        final int WATER_QUANTITY_FOR_CAPPUCCINO = 200;
        final int MILK_QUANTITY_FOR_CAPPUCCINO = 100;
        final int COFFEE_QUANTITY_FOR_CAPPUCCINO = 12;
        final int PRICE_FOR_CAPPUCCINO = 6;
        StringBuilder missingResources = new StringBuilder();

        if(this.waterQuantity >= WATER_QUANTITY_FOR_CAPPUCCINO){
            this.waterQuantity -= WATER_QUANTITY_FOR_CAPPUCCINO;
        }else{
            missingResources.append("Sorry, not enough water\n");
        }

        if(this.milkQuantity >= MILK_QUANTITY_FOR_CAPPUCCINO){
            this.milkQuantity -= MILK_QUANTITY_FOR_CAPPUCCINO;
        }else{
            missingResources.append("Sorry, not enough milk\n");
        }

        if(this.coffeeQuantity >= COFFEE_QUANTITY_FOR_CAPPUCCINO){
            this.coffeeQuantity -= COFFEE_QUANTITY_FOR_CAPPUCCINO;
        }else{
            missingResources.append("Sorry, not enough coffee\n");
        }

        if(this.disposableCups > 0){
            this.disposableCups--;
        }else{
            missingResources.append("Sorry, not enough disposable cups\n");
        }

        if(missingResources.isEmpty()){
            cashUnit.collectMoney(PRICE_FOR_CAPPUCCINO);    // CashUnit collects the money for the drink
            System.out.println("Making you a cappuccino!");
        }else{
            System.out.print(missingResources);
        }
    }

    public void fill(){
        System.out.println("Write how many ml of water you want to add:");
        System.out.print("> ");
        this.waterQuantity += Integer.parseInt(input.nextLine());

        System.out.println("Write how many ml of milk you want to add:");
        System.out.print("> ");
        this.milkQuantity += Integer.parseInt(input.nextLine());

        System.out.println("Write how many g of coffee you want to add:");
        System.out.print("> ");
        this.coffeeQuantity += Integer.parseInt(input.nextLine());

        System.out.println("Write how many disposable cups you want to add:");
        System.out.print("> ");
        this.disposableCups += Integer.parseInt(input.nextLine());
    }

    public void take(){
        System.out.println("I gave you " + cashUnit.takeMoney());  // already done
    }

    public void remaining(){                            // already done
        String machineState = String.format("""
                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee
                %d disposable cups
                $%d of money
                """, waterQuantity, milkQuantity, coffeeQuantity, disposableCups, cashUnit.getBalance()); // a. done
        System.out.print(machineState);
    }

    public void exit(){
        System.exit(0);
    }
}
