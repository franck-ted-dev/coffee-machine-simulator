package machine.ui;

import machine.domain.DrinkStatus;

public class DrinkStatusMessageMapper {
    public String toMessage(DrinkStatus drinkStatus){
        return switch (drinkStatus){
            case OKAY ->  "\nMaking your drink!\n";
            case NOT_ENOUGH_WATER -> "\nNot enough water!\n";
            case NOT_ENOUGH_MILK -> "\nNot enough milk!\n";
            case NOT_ENOUGH_COFFEE ->  "\nNot enough coffee!\n";
            case NO_CUPS ->  "\nNot enough disposable cups!\n";
            case INVALID_DRINK -> "\nInvalid choice!\n";
            case BACK_TO_MENU -> "";
        };
    }
}
