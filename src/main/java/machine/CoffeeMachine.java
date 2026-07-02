package machine;

import machine.logic.CoffeeMachineController;
import machine.ui.ConsoleUI;

public class CoffeeMachine {
    private final CoffeeMachineController controller;
    private final ConsoleUI console;

    public CoffeeMachine() {
        this.console = new ConsoleUI();
        this.controller = new CoffeeMachineController(console);
    }

    public void start(){
        while(true){
            controller.processMainMenuResponse(console.displayMainMenu());
        }
    }

}
