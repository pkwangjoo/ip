import exception.InvalidCommandException;
import exception.TaskFactoryException;
import exception.TreeBotException;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeBot {
    private static final String EXIT_TOKEN = "bye";
    private ArrayList<Task> tasks = new ArrayList<>();
    private TaskFactory taskFactory = new TaskFactory();
    public void start() {
        greet();
        listen();
    }
    private void listen() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String commandString = sc.nextLine();

            if (commandString.equals(EXIT_TOKEN)) {
                exit();
                break;
            }

            try {
                execute(commandString);
            } catch (TreeBotException e) {
                System.out.println(e.getMessage());
            }

        }

    }
    private void execute(String commandString) throws TreeBotException {
        String[] splitStr = commandString.split("\\s+", 2);
        String command = splitStr[0];

        switch (command) {
            case "list":
                listTasks();
                break;
            case "todo":
            case "deadline":
            case "event":
                try {
                    Task newTask = this.taskFactory.make(commandString);
                } catch (TaskFactoryException e) {
                    throw e;
                }

                addTask(this.taskFactory.make(commandString));
                break;
            case "mark":
                markTask(Integer.parseInt(splitStr[1]));
                break;
            case "unmark":
                unmarkTask(Integer.parseInt(splitStr[1]));
                break;
            default:
                throw new InvalidCommandException("This command is invalid");
        }
    }
    private void addTask(Task task) {
        this.tasks.add(task);
    }
    private void listTasks() {
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println(i + 1 + "." + this.tasks.get(i));
        }
    }
    private void markTask(int idx) {
        this.tasks.get(idx - 1).markAsDone();
    }
    private void unmarkTask(int idx) {
        this.tasks.get(idx - 1).markAsUndone();
    }
    private void greet() {
        System.out.println("Hello, I'm a tree. How may I be of service?");
    }

    private void echo(String command) {
        System.out.println(command);
    }

    private void exit() {
        System.out.println("Thank you, i'll be rooting for you.");
    }
}
