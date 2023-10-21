
import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return date;
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты

    }

    public static String generateCity(String locale) {
        var cities = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск," +
                "Петрозаводск", "Сыктывкар", "Йошкар-Ола", "Саранск", " Якутск", " Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", " Грозный",
                "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь",
                " Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "Белгород", " Брянск", " Владимир", "Волгоград", "Вологда", "Воронеж",
                "Иваново", " Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Санкт-Петербург", "Липецк",
                "Магадан", "Москва", " Мурманск", "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", " Оренбург", "Орел", "Пенза",
                "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь",
                "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Ярославль", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард"};

        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя масс валидных городов и класс Random
        return cities[new Random().nextInt(cities.length)];

    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();

        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().cellPhone();

        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user;
            user = new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)
            );
            return user;



        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

}
