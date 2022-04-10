package guru.qa.utils;

import java.util.Random;
import java.util.List;
import java.util.Random;

    public class RandomUtils {

        public static String getRandomStringOfDigits(int length) {
            String SALTCHARS = "1234567890";
            StringBuilder result = new StringBuilder();
            Random rnd = new Random();
            while (result.length() < length) {
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                result.append(SALTCHARS.charAt(index));
            }
            return result.toString();
        }

        public static String getRandomGender() {
            List<String> genders = List.of("Male", "Female", "Other");
            Random rnd = new Random();
            return genders.get(rnd.nextInt(genders.size()));
        }

    }
