import java.io.BufferedReader;
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
        try {
            StatisticCollector scanner = new StatisticCollector(filename);
            scanner.collectStatistic();
            scanner.printStatistic(null); // либо указать нужный файл или путь до файла
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}
