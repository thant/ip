public class TaskArray {

    static Task[] storedTasks = new Task[100];

    static int count;


    public TaskArray(){
    }

    public static void createToDo(String userInput){
        storedTasks[count] = new Todo(userInput);
    }
    public static void createDeadline(String userInput){
        String[] parameters = userInput.split("by",2);
        storedTasks[count] = new Deadline(parameters[0],parameters[1]);
    }

    public static void createEvent(String userInput){
        String[] temp = userInput.split(" from ", 2);
        String[] parameters = temp[1].split(" to ", 2);
        storedTasks[count] = new Event(temp[0],parameters[0],parameters[1]);
    }

    public static void print(){
        System.out.println(UI.LINE);
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + "." + storedTasks[i].toString());
        }
        System.out.println(UI.LINE);
    }

    public static void mark(String userInput){
        String index = userInput.trim();
        int indexInt = Integer.parseInt(index) - 1;
        storedTasks[indexInt].markAsDone();
        System.out.println(UI.LINE + "     Nice! I've marked this task as done:\n [X] " + storedTasks[indexInt].description + "\n "+ UI.LINE);
    }

    public static void unmark(String userInput){
        String index = userInput.trim();
        int indexInt = Integer.parseInt(index) - 1;
        storedTasks[indexInt].unmarkTask();
        System.out.println(UI.LINE + "     OK, I've marked this task as not done yet:\n [ ] " + storedTasks[indexInt].description + "\n " + UI.LINE);
    }
}
