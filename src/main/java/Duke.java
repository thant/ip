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
                String[] user_input_split = user_input.split(" ");

                if (user_input_split[0].equals("bye") | user_input_split[0].equals("Bye")) {
                    System.out.println(" Bye. Hope to see you again soon!\n" +
                            "____________________________________________________________\n");
                    break;
                }

                else if (user_input_split[0].contains("mark")) {
                    if (user_input_split[0].contains("unmark")) {
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

                else if (user_input_split[0].equals("list")) {
                    System.out.println("____________________________________________________________\n");
                    for (int i = 0; i < count; i++) {
                            System.out.println(i + 1 + "." + list[i].toString());
                        }
                    System.out.println("____________________________________________________________\n");
                }

                else if (user_input_split[0].equals("todo")) {
                    list[count] = new Todo(user_input.substring(5));
                    count++;
                    System.out.println("____________________________________________________________\n" +
                            "     Got it. I've added this task:\n" +
                            "       [T][ ] " + user_input.substring(5) +
                            "\n     Now you have " + count + " tasks in the list.\n" +
                            "____________________________________________________________");
                }

                else if (user_input_split[0].equals("deadline")) {
                    String[] user_input_splitby = user_input.split("/by");

                    list[count] = new Deadline(user_input_splitby[0].substring(8),user_input_splitby[1].substring(1));
                    count++;
                    System.out.println("____________________________________________________________\n" +
                            "     Got it. I've added this task:\n" +
                            "        " + list[count-1].toString() +
                            "\n     Now you have " + count + " tasks in the list.\n" +
                            "____________________________________________________________");
                }

                else if (user_input_split[0].equals("event")) {
                    String[] user_input_splitfrom = user_input.split("/from");
                    String[] user_input_splitto = user_input_splitfrom[1].split("/to");

                    list[count] = new Event(user_input_splitfrom[0].substring(5),user_input_splitto[0].substring(1), user_input_splitto[1].substring(1));
                    count++;
                    System.out.println("____________________________________________________________\n" +
                            "     Got it. I've added this task:\n" +
                            "        " + list[count-1].toString() +
                            "\n     Now you have " + count + " tasks in the list.\n" +
                            "____________________________________________________________");

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
