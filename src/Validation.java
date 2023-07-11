import java.util.Scanner;

public class Validation {
    static Scanner scanner = new Scanner(System.in);

    // function to check int
    public static int checkInt(String massage, int min, int max) {
        while (true) {
            System.out.println(massage);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input could not be empty. Please enter a positive integer number");
                continue;
            }
            try {
                int inputValue = Integer.parseInt(input);
                if (inputValue <= min || inputValue >= max) {
                    throw new NumberFormatException();
                }
                return inputValue;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a positive integer number from " + min +" to " + max);
            }
        }
    }
    // function to check double
    public static double checkDouble(String massage, double min, double max) {
        while (true) {
            System.out.println(massage);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input could not be empty. Please enter a positive double number");
                continue;
            }
            try {
                double inputValue = Double.parseDouble(input);
                if (inputValue <= min || inputValue >= max) {
                    throw new NumberFormatException();
                }
                return inputValue;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a positive double number from " + min +" to " + max);
            }
        }
    }
    // function to check string
    public static String checkString(String message){
        while (true){
            System.out.println(message);
            String input = scanner.nextLine();
            if(input.isEmpty()){
                System.err.println("Input could not be empty");
                continue;
            }
            return input;
        }
    }
}
