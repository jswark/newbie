import java.io.*;
import java.util.*;

public class StatisticCollector {
    private final String outputFile = "result.txt";
    private final String filename;
    private final Map<Character, Integer> statistic; // new HashMap<>() если не нужен алфавитный порядок

    public StatisticCollector(String filename) {
        statistic = new TreeMap<>();
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
                char symbol = Character.toUpperCase((char) code);
                statistic.computeIfPresent(symbol, (key, value) -> value += 1);
            }
        }

    }

    public void printStatistic(String outputFile) throws IOException {
        if (outputFile == null) {
            outputFile = this.outputFile;
        }
        try (final PrintWriter writer = new PrintWriter(new FileWriter(new File(outputFile)))) {
            for (Map.Entry<Character, Integer> entry : statistic.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
