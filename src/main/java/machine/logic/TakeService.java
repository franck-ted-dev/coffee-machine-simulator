package machine.logic;

import machine.domain.CashUnit;
import machine.ui.ConsoleUI;

public class TakeService {
    private final CashUnit cashUnit;
    private final ConsoleUI console;

    public TakeService(CashUnit cashUnit, ConsoleUI console) {
        this.cashUnit = cashUnit;
        this.console = console;
    }

    public void execute(){
        take();
    }

    private void take(){
        String message = """
                
                I gave you $%d
                """.formatted(cashUnit.takeMoney());
        console.displayMessage(message);
    }
}
