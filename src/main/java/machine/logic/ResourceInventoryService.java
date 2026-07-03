package machine.logic;

import machine.domain.CashUnit;
import machine.domain.Stock;
import machine.ui.ConsoleUI;

public class ResourceInventoryService {
    private final Stock stock;
    private final CashUnit cashUnit;
    private final ConsoleUI console;

    public ResourceInventoryService(Stock stock, CashUnit cashUnit, ConsoleUI console) {
        this.stock = stock;
        this.cashUnit = cashUnit;
        this.console = console;
    }

    public void execute(){
        remaining();
    }

    private void remaining(){
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
}
