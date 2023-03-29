package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerData {

    public static Faker faker = new Faker(new Locale("en"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male"),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = faker.options().option("September"),
            year = String.valueOf(faker.number().numberBetween(1990, 2023)),
            subject = faker.options().option("English"),
            hobbies = faker.options().option("Reading"),
            file = "1.png",
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = city();

    public static String city() {
        if (state.equals("NCR")) {
            String city = faker.options().option("Delhi", "Gurgaon", "Noida");
            return city;
        }
        else if (state.equals("Uttar Pradesh")) {
            String city = faker.options().option("Agra", "Lucknow", "Merrut");
            return city;
        }
        else if (state.equals("Haryana")) {
            String city = faker.options().option("Karnal", "Panipat");
            return city;
        }
        else if (state.equals("Rajasthan")) {
            String city = faker.options().option("Jaipur", "Jaiselmer");
            return city;
        }

        return null;
    }
}