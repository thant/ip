import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String[] list = new String[100];
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
                if (user_input.equals("list")){
                    System.out.println("____________________________________________________________\n  ");
                    for (int i=0; i < count; i++){
                        System.out.println(i+1 + ". " + list[i]+ "\n");
                    }
                    System.out.println("____________________________________________________________\n  ");
                }


                else {
                    System.out.println("____________________________________________________________\n  " + "added: " + user_input +
                            "\n____________________________________________________________\n");
                    list[count] = user_input;
                    count++;
                }
            }
    }
}
