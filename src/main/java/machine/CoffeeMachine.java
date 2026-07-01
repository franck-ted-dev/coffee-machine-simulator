package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int waterQuantity;
    private int milkQuantity;
    private int coffeeQuantity;
    private int disposableCups;
    private int balance;
    private final Scanner input;
    private String choice;

    public CoffeeMachine() {
        this.waterQuantity = 400;
        this.milkQuantity = 540;
        this.coffeeQuantity = 120;
        this.disposableCups = 9;
        this.balance = 550;
        this.input = new Scanner(System.in);
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
        final int WATER_QUANTITY_FOR_ESPRESSO = 250;
        final int COFFEE_QUANTITY_FOR_ESPRESSO = 16;
        final int PRICE_FOR_ESPRESSO = 4;
        StringBuilder missingResources = new StringBuilder();

        if(this.waterQuantity >= WATER_QUANTITY_FOR_ESPRESSO){
            this.waterQuantity -= WATER_QUANTITY_FOR_ESPRESSO;
        }else{
            missingResources.append("Sorry, not enough water\n");
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
            this.balance += PRICE_FOR_ESPRESSO;
            System.out.println("Making you a espresso!");
        }else{
            System.out.print(missingResources);
        }
    }

    public void buyLatte(){
        final int WATER_QUANTITY_FOR_LATTE = 250;
        final int MILK_QUANTITY_FOR_LATTE = 75;
        final int COFFEE_QUANTITY_FOR_LATTE = 20;
        final int PRICE_FOR_LATTE = 7;
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
            this.balance += PRICE_FOR_LATTE;
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
            this.balance += PRICE_FOR_CAPPUCCINO;
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
        System.out.println("I gave you " + this.balance);
        this.balance = 0;
    }

    public void remaining(){
        String machineState = String.format("""
                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee
                %d disposable cups
                $%d of money
                """, waterQuantity, milkQuantity, coffeeQuantity, disposableCups, balance);
        System.out.print(machineState);
    }

    public void exit(){
        System.exit(0);
    }
}
