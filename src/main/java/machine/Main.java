package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();
    }

    public static void secondStage() {
        Scanner input = new Scanner(System.in);
        final int SINGLE_WATER_QUANTITY = 200;
        final int SINGLE_MILK_QUANTITY = 50;
        final int SINGLE_COFFEE_QUANTITY = 15;

        System.out.println("How many cups of coffee do you want ?");
        System.out.print("> ");
        int numberCups = Integer.parseInt(input.nextLine());
        int waterQuantity = numberCups * SINGLE_WATER_QUANTITY;
        int milkQuantity = numberCups * SINGLE_MILK_QUANTITY;
        int coffeeQuantity = numberCups * SINGLE_COFFEE_QUANTITY;

        System.out.printf("For %d cups of coffee you will need:\n", numberCups);
        System.out.printf("%d ml of water\n", waterQuantity);
        System.out.printf("%d ml of milk\n", milkQuantity);
        System.out.printf("%d g of coffee\n", coffeeQuantity);
    }

    public static void thirdStage() {
        Scanner input = new Scanner(System.in);

        final int SINGLE_WATER_QUANTITY = 200;
        final int SINGLE_MILK_QUANTITY = 50;
        final int SINGLE_COFFEE_QUANTITY = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        System.out.print("> ");
        int availableWater = Integer.parseInt(input.nextLine());

        System.out.println("Write how many ml of milk the coffee machine has:");
        System.out.print("> ");
        int availableMilk = Integer.parseInt(input.nextLine());

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        System.out.print("> ");
        int availableCoffee = Integer.parseInt(input.nextLine());

        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int wantedNumberCups = Integer.parseInt(input.nextLine());

        int numberCupsDependingOnWaterQuantity = availableWater/SINGLE_WATER_QUANTITY;
        int numberCupsDependingOnMilkQuantity = availableMilk/SINGLE_MILK_QUANTITY;
        int numberCupsDependingOnCoffeeQuantity = availableCoffee/SINGLE_COFFEE_QUANTITY;

        int makableNumberCups = min(numberCupsDependingOnCoffeeQuantity,
                                    numberCupsDependingOnMilkQuantity,
                                    numberCupsDependingOnWaterQuantity);

        if(makableNumberCups == wantedNumberCups) {
            System.out.println("Yes I can make that amount of coffee");
            return;
        }

        if(makableNumberCups > wantedNumberCups) {
            System.out.printf("Yes I can make that amount of coffee (and even %d more than that)\n", makableNumberCups-wantedNumberCups);
            return;
        }

        System.out.printf("No I can only make %d cups of coffee\n", makableNumberCups);
    }

    public static int min(int a, int b, int c){
        int temp = Math.min(a,b);
        return Math.min(temp,c);
    }
}
