import java.util.ArrayList;
import java.util.Scanner;

public class TreeBot {
    private static final String EXIT_TOKEN = "bye";
    private ArrayList<String> items = new ArrayList<>();
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

            execute(commandString);

        }

    }
    private void execute(String commandString) {
        String[] splitStr = commandString.split("\\s+");
        String command = splitStr[0];

        switch (command) {
            case "list":
                listItems();
                break;
            default:
                addItem(commandString);
        }
    }
    private void addItem(String item) {
        this.items.add(item);
    }
    private void listItems() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println(i + 1 + ". " + this.items.get(i));
        }
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