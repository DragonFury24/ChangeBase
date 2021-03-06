import java.io.File;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ChangeBaseMain {
    public static void main(String[] args) {

        String path = new File("src/").exists() ? "src/" : "";
        path += new File(path + "Input.txt").exists() ? "Input.txt" : "";

        if (path.contains("Input.txt"))
            runFromFile(new File(path));
        else
            runFromKeyboard();
    }


    /**
     * Calls changeBase0
     * @param input Number in base10 to convert
     * @param base Target base to convert to
     * @return String of the converted number
     */
    public static String changeBase(int input, int base) {
        return changeBase0(input, base);
        //return Integer.parseInt(changeBase0(input, base));
    }

    /**
     * Converts a number in base10 to a target base
     * @param input Number in base10 to convert
     * @param base Target base to convert to
     * @return String with the converted number
     */
    private static String changeBase0(int input, int base) {
        if (input < base) {
            if (input > 9)
                return Character.toString((char)(input + 55));

            return Integer.toString(input);
        }

        if (input % base > 9)
            return changeBase0(input / base, base) + (char)((input % base) + 55);

        return changeBase0(input / base, base) + Integer.toString(input % base);
    }

    /**
     * Converts numbers between bases by using numbers from a file
     * @param input Text file containing numbers to convert to different bases
     */
    private static void runFromFile(File input) {
        ArrayDeque<Integer> inputs = FileUtils.readFile(input);

        while (!inputs.isEmpty()) {
            int base = inputs.pop();

            for (int i = 0; i < 3; i++)
                System.out.println(changeBase(inputs.pop(), base));
        }
    }

    /**
     * Converts numbers between bases using input from keyboard and console
     */
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
