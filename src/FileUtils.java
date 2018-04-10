import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class FileUtils {
    /**
     * Parses text file
     *
     * @param file Text file
     * @return Queue of elements in file
     */
    public static ArrayDeque<Integer> readFile(File file) {
        String             tempInput;
        ArrayDeque<Integer> countryInfo = new ArrayDeque<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((tempInput = br.readLine()) != null) {
                countryInfo.add(Integer.parseInt(tempInput));
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        return countryInfo;
    }
}