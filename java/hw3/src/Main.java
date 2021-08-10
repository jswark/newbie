import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String filename;

        try (final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            filename = consoleReader.readLine();
            StatisticCollector scanner = new StatisticCollector(filename);
            scanner.collectStatistic();
            scanner.printStatistic(null); // либо указать нужный файл или путь до файла
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }
}
