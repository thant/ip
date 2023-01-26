import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Task[] list = new Task[100];
        int count = 0;

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
                }

                else if (user_input.contains("mark")) {
                    if (user_input.contains("unmark")) {
                        char index = user_input.charAt(user_input.length()-1);
                        int indexint = Character.getNumericValue(index) - 1;
                        list[indexint].unmarkTask();
                        System.out.println("____________________________________________________________\n" +
                                "     OK, I've marked this task as not done yet:\n [ ] " + list[indexint].description + "\n ____________________________________________________________\n");
                    }
                    else{
                        char index = user_input.charAt(user_input.length()-1);
                        int indexint = Character.getNumericValue(index) - 1;
                        list[indexint].markAsDone();
                        System.out.println("____________________________________________________________\n" +
                                "     Nice! I've marked this task as done:\n [X] " + list[indexint].description + "\n ____________________________________________________________\n");
                    }
                }

                else if (user_input.equals("list")) {
                    System.out.println("____________________________________________________________\n");
                    for (int i = 0; i < count; i++) {
                        if (i != count - 1) {
                            System.out.println(i + 1 + ". [" + list[i].getStatusIcon() + "] " + list[i].description + "\n");
                        } else {
                            System.out.println(i + 1 + ". [" + list[i].getStatusIcon() + "] " + list[i].description);
                        }
                        System.out.println("____________________________________________________________\n");
                    }
                }

                else {
                    Task newtask = new Task(user_input);
                    System.out.println("____________________________________________________________\n  " + "added: " + user_input +
                            "\n____________________________________________________________\n");
                    list[count] = newtask;
                    count++;
                }
            }
    }
}
