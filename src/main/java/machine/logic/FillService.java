package machine.logic;

import machine.domain.Stock;
import machine.ui.ConsoleUI;

public class FillService {
    private final ConsoleUI console;
    private final Stock stock;

    public FillService(ConsoleUI console, Stock stock) {
        this.console = console;
        this.stock = stock;
    }

    public void execute(){
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
}
