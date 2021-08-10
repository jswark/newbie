import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class StatisticCollector {

    private final String filename;
    private final Map<Character, Integer> statistic = new TreeMap<>();
    // new HashMap<>() если не нужен алфавитный порядок

    public StatisticCollector(String filename) {
        this.filename = filename;
    }

    public void collectStatistic() throws IOException {
        for (char key = 'A'; key <= 'Z'; key++) {
            statistic.put(key, 0);
        }
        final BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        int code;
        while ((code = fileReader.read()) != -1) {
            if (Character.isLetter(code)) { // считаем, что в файле есть только латинские символы и специальные значки
                statistic.computeIfPresent(Character.toUpperCase((char) code),
                        (key, value) -> value += 1);
            }
        }
    }

    public void printStatistic(String outputFile) throws IOException {
        if (outputFile == null || outputFile.isEmpty()) {
            outputFile = "result.txt";
        }
        try (final PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            statistic.forEach((key, value) -> writer.println(key + ": " + value));
        }
    }

}