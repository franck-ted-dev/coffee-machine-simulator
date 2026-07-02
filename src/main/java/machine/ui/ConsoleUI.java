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

}
