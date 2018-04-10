import java.io.File;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ChangeBaseMain {
    public static void main(String[] args) {

        File file;

        if ((file = new File("src")).exists()) {
            if ((file = new File("src/Input.txt")).exists())
                runFromFile(file);
            else
                runFromKeyboard();
        } else {
            if ((file = new File("Input.txt")).exists())
                runFromFile(file);
            else
                runFromKeyboard();
        }
    }


    public static int changeBase(int input, int base) {
        return Integer.parseInt(changeBase0(input, base));
    }

    private static String changeBase0(int input, int base) {
        if (input < base)
            return Integer.toString(input);

        return changeBase0(input / base, base) + Integer.toString(input % base);
    }

    private static void runFromFile(File input) {
        ArrayDeque<Integer> inputs = FileUtils.readFile(input);

        while (!inputs.isEmpty()) {
            int base = inputs.pop();

            for (int i = 0; i < 3; i++)
                System.out.println(changeBase(inputs.pop(), base));

        }
    }

    private static void runFromKeyboard() {
        Scanner keyType = new Scanner(System.in);
        boolean running = true;

        while (running) {
            //print menu
            System.out.println("1) Convert number to different base");
            System.out.println("2) Exit");

            switch (NumberInput.noNegIntInput(keyType)) {
                case 1:
                    System.out.println("Type in base:");
                    int base = NumberInput.noNegIntInput(keyType);
                    keyType.nextLine();
                    System.out.println("Type in number to convert:");
                    int convert = NumberInput.noNegIntInput(keyType);
                    keyType.nextLine();
                    System.out.println(changeBase(convert, base));
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Not an option. Choose again.");
            }
            System.out.println();
        }
    }
}
