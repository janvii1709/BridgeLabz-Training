import java.util.Scanner;

class TextEditor {

    // Text class representing a state
    private class Text {
        String content;
        Text prev, next;

        Text(String content) {
            this.content = content;
        }
    }

    private Text head;       // Oldest state
    private Text current;    // Current state
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Constructor → initial empty state
    public TextEditor() {
        Text empty = new Text("");
        head = current = empty;
        size = 1;
    }

    // Add new text state (APPEND text)
    public void addState(String newText) {
        String updatedText = current.content + newText;
        Text newState = new Text(updatedText);

        // Remove redo history
        current.next = null;

        newState.prev = current;
        current.next = newState;
        current = newState;
        size++;

        // Maintain max history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo
    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Show current text
    public void showCurrentState() {
        System.out.println("Current text: " + current.content);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        System.out.println("Welcome to Simple Text Editor!");
        System.out.println("type      -> Type new text");
        System.out.println("undo      -> Undo last change");
        System.out.println("redo      -> Redo last undone change");
        System.out.println("show      -> Show current text");
        System.out.println("exit      -> Exit editor");

        while (true) {
            System.out.print("\nEnter command: ");
            String command = sc.nextLine();

            switch (command.toLowerCase()) {
                case "type" -> {
                    System.out.print("Enter your text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    System.out.println("Text added.");
                }
                case "undo" -> editor.undo();
                case "redo" -> editor.redo();
                case "show" -> editor.showCurrentState();
                case "exit" -> {
                    System.out.println("Exiting editor.");
                    return;
                }
                default -> System.out.println("Invalid command! Try again.");
            }
        }
    }
}
