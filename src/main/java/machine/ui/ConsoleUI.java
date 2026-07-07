package machine.ui;

import machine.request.RefillRequest;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner input;
    private final InputParser parser;

    public ConsoleUI() {
        this.input = new Scanner(System.in);
        this.parser = new InputParser();
    }

    public String displayMainMenu(){
        String mainMenu = """
                
                Write action (buy, fill, take, remaining, exit):
                """;
        return displayMessageAndReplyResponse(mainMenu);
    }

    public String displayDrinkMenu(){
        String drinkMenu = """
                
                What do you want to buy ?
                    1 - Espresso
                    2 - Latte
                    3 - Cappuccino
                    4 - back to main menu
                """;
        return displayMessageAndReplyResponse(drinkMenu);
    }

    public String displayMessageAndReplyResponse(String message){
        displayMessage(message);
        System.out.print("> ");
        return input.nextLine();
    }

    public void displayMessage(String message){
        System.out.print(message);
    }

    public RefillRequest askRefill(){
        int water = parser.toPositiveInt(askWater());
        int milch = parser.toPositiveInt(askMilk());
        int coffee = parser.toPositiveInt(askCoffee());
        int cups = parser.toPositiveInt(askCup());

        return new RefillRequest(water, milch, coffee, cups);
    }

    public String askWater(){
        String message = "\nHow many ml of water do you want to add?\n";
        return displayMessageAndReplyResponse(message);
    }

    public String askMilk(){
        String message = "\nHow many ml of milk do you want to add?\n";
        return displayMessageAndReplyResponse(message);
    }

    public String askCoffee(){
        String message = "\nHow many g of coffee do you want to add?\n";
        return displayMessageAndReplyResponse(message);
    }

    public String askCup(){
        String message = "\nHow many disposable cups do you want to add?\n";
        return displayMessageAndReplyResponse(message);
    }

    public void displayBalance(int balance){
        String message = "\nI gave you $"  + balance + "\n";
        displayMessage(message);
    }
}
