import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private final String name;
    private final String surname;
    private final String patronymic;
    private final boolean isMan; // true = male
    private final int age;

    public Person(String[] string) throws InvalidArgumentException {
        if (string == null || string.length != 4) {
            throw new InvalidArgumentException("Invalid data supplied for initialization");
        }

        LocalDate today = LocalDate.now();
        Calendar birthday = new GregorianCalendar();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            formatter.setLenient(false);
            birthday.setTime(formatter.parse(string[3]));
        } catch (Exception e) {
            throw new InvalidArgumentException("Wrong format dd.MM.yyyy");
        }

        age = Period.between(LocalDate.ofInstant(birthday.toInstant(), birthday.getTimeZone().toZoneId()), today).getYears();
        if (age < 0) {
            throw new InvalidArgumentException("Invalid data supplied for initialization");
        }

        name = string[0];
        surname = string[1];
        patronymic = string[2];
        isMan = !(patronymic.endsWith("а"));
    }

    @Override
    public String toString() {
        return name + " "
                + surname.charAt(0) + "."
                + patronymic.charAt(0) + ". "
                + (isMan ? "М" : "Ж") + " "
                + (age) + " "
                + getAgePostfix();
    }

    private String getAgePostfix() {
        boolean exclusion = (age % 100 >= 11) && (age % 100 <= 14);
        if (exclusion) {
            return "лет";
        }
        int ageLastNumber = age % 10;
        if (ageLastNumber == 1) {
            return "год";
        } else if (ageLastNumber == 0 || ageLastNumber >= 5) {
            return "лет";
        } else {
            return "года";
        }
    }
}
