import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String LINE = "____________________________________________________________\n";
        Task[] list = new Task[100];
        String[] commands = new String[]{"bye","mark","unmark","todo","list","deadline","event"};
        int count = 0;
        System.out.println(LINE +" Hello! I'm Duke\n" + " What can I do for you?\n" +LINE);
            while(true){
                Scanner newScanner = new Scanner(System.in);
                String userInput = newScanner.nextLine();
                String[] userInputSplit = userInput.split(" ");
                try {
                    if (userInputSplit[0].equalsIgnoreCase("bye")) {
                        System.out.println(" Bye. Hope to see you again soon!\n" + LINE);
                        break;
                    } else if (userInputSplit[0].contains("mark")) {
                        try{
                            String index = userInput.trim().substring(userInput.length()-1);
                            int indexInt = Integer.parseInt(index) - 1;
                            if (userInputSplit[0].contains("unmark")) {
                                list[indexInt].unmarkTask();
                                System.out.println(LINE + "     OK, I've marked this task as not done yet:\n [ ] "
                                        + list[indexInt].description + "\n " + LINE);
                            } else {
                                list[indexInt].markAsDone();
                                System.out.println(LINE + "     Nice! I've marked this task as done:\n [X] " + list[indexInt].description + "\n "
                                        + LINE);
                            }
                        }catch (NullPointerException nullError){
                            System.out.println(LINE + "☹ OOPS!!! The task you tried to " + userInputSplit[0] + " does not exist!\n" + LINE);
                        }catch (NumberFormatException numError){
                            System.out.println(LINE + "☹ OOPS!!! There wasn't a valid number inputted!\n" + LINE);
                        }
                    } else if (userInputSplit[0].equals("list")) {
                        System.out.println(LINE);
                        for (int i = 0; i < count; i++) {
                            System.out.println(i + 1 + "." + list[i].toString());
                        }
                        System.out.println(LINE);
                    } else if (userInputSplit[0].equals("todo")) {
                        list[count] = new Todo(userInput.substring(5));
                        count++;
                        System.out.println(LINE +
                                "     Got it. I've added this task:\n" +
                                "       [T][ ] " + userInput.substring(5) +
                                "\n     Now you have " + count + " tasks in the list.\n" +
                                LINE);
                    } else if (userInputSplit[0].equals("deadline")) {
                        String[] userInputSplitBy = userInput.split("by");
                        try {
                            list[count] = new Deadline(userInputSplitBy[0].substring(8), userInputSplitBy[1].substring(1));
                            count++;
                            System.out.println(LINE +
                                    "     Got it. I've added this task:\n" +
                                    "        " + list[count - 1].toString() +
                                    "\n     Now you have " + count + " tasks in the list.\n" +
                                    LINE);
                        }catch (ArrayIndexOutOfBoundsException arrayError){
                            System.out.println(LINE + "Please follow the format:[deadline <Task Name> by <Deadline Date>]\n" + LINE);
                        }
                    } else if (userInputSplit[0].equals("event")) {
                        try {
                            String[] userInputSplitFrom = userInput.split(" from ");
                            String[] userInputSplitTo = userInputSplitFrom[1].split(" to ");

                            list[count] = new Event(userInputSplitFrom[0].substring(5), userInputSplitTo[0], userInputSplitTo[1]);
                            count++;
                            System.out.println(LINE +
                                    "     Got it. I've added this task:\n" +
                                    "        " + list[count - 1].toString() +
                                    "\n     Now you have " + count + " tasks in the list.\n" +
                                    LINE);
                        }catch (ArrayIndexOutOfBoundsException arrayError){
                            System.out.println(LINE + "Please follow the format:[event <Task Name> from <Start Time> to <End Time>]\n" + LINE);
                        }
                    } else {
                        System.out.println(LINE + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + LINE);

                    }
                }catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException error) {
                    System.out.println(LINE + "☹ OOPS!!! The description of a " + userInputSplit[0] + " cannot be empty.\n" + LINE);
                }
            }
    }
}
