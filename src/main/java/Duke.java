import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {

            System.out.println("____________________________________________________________\n  " +
                    " Hello! I'm Duke\n" +
                    " What can I do for you?\n" +
                    "____________________________________________________________\n");
            while(true) {
                Scanner newScanner = new Scanner(System.in);
                String user_input = newScanner.nextLine();

                if (user_input.equals("bye") | user_input.equals("Bye")) {
                    System.out.println(" Bye. Hope to see you again soon!\n" +
                            "____________________________________________________________\n");
                    break;
                } else {
                    System.out.println("____________________________________________________________\n  " + user_input +
                            "\n____________________________________________________________\n");
                }
            }
    }
}
