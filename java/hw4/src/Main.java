import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println(new Person(scanner.nextLine().split(" ")));
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }
}
