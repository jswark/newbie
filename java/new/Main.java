import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String filename;

        try (final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = consoleReader.readLine();
        } catch (final IOException e) {
            System.err.print("Error while reading from console: " + e.getMessage());
            return;
        }

        StatisticCollector scanner = new StatisticCollector(filename);

        try {
            scanner.collectStatistic();
        } catch (FileNotFoundException e) {
            System.err.print("File doesn't exist " + e.getMessage());
        } catch (IOException e) {
            System.err.print("Error while reading " + filename + ". " + e.getMessage());
        }

        try {
            scanner.printStatistic(null); // либо указать нужный файл или путь до файла
        } catch (FileNotFoundException e) {
            System.err.print("Can not create new file " + e.getMessage());
        } catch (IOException e) {
            System.err.print("Error while writing data: " + e.getMessage());
        }
    }
}
