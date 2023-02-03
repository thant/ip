import java.util.Scanner;

public class Duke {
    public static boolean continueRunning = true;

    public static void main(String[] args) {
        UI.greet();
        while (continueRunning) {
            Scanner newScanner = new Scanner(System.in);
            String userInput = newScanner.nextLine();
            String[] userInputSplit = userInput.split(" ", 2);
            Parser controller = new Parser(userInputSplit);
            controller.processInput();
        }
    }
}


