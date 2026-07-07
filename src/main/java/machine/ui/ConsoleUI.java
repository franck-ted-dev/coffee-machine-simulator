package machine.ui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner input;

    public ConsoleUI() {
        this.input = new Scanner(System.in);
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

    public int askWater(){
        String message = "\nHow many ml of water do you want to add?\n";
        String answer = displayMessageAndReplyResponse(message);
        return Integer.parseInt(answer);
    }

    public int askMilch(){
        String message = "\nHow many ml of milch do you want to add?\n";
        String answer = displayMessageAndReplyResponse(message);
        return Integer.parseInt(answer);
    }

    public int askCoffee(){
        String message = "\nHow many mg of coffee do you want to add?\n";
        String answer = displayMessageAndReplyResponse(message);
        return Integer.parseInt(answer);
    }

    public int askCup(){
        String message = "\nHow many disposable cups do you want to add?\n";
        String answer = displayMessageAndReplyResponse(message);
        return Integer.parseInt(answer);
    }
}
