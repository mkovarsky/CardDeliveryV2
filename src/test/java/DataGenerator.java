import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private Faker faker;
    private LocalDate today = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String futureDate(int plusDays) {
        LocalDate newDate = today.plusDays(plusDays);
        return formatter.format(newDate);
    }

    public String generateCity() {
        String[] CityList = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск"};
        int n = (int) Math.floor(Math.random() * CityList.length);
        return CityList[n];
    }

    public String generateName() {
        faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public String generatePhone() {
        faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }
}
