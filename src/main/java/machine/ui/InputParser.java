package machine.ui;

public class InputParser {
    public int toPositiveInt(String input) {
        try{
            int result = Integer.parseInt(input);
            return Math.max(0, result);
        }catch(NumberFormatException e){
            return 0;
        }
    }
}
