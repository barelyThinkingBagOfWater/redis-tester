package com.webfluxjedisredistester.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntitiesGenerator {

    public final int CHARS_IN_PAYLOAD = 363675; //from given json
    private final int CHARS_IN_KEY = 35; //from example with 2 cities, 1 date and 1 cabin type


    public List<TestEntity> generateTestEntities(int number) {
        List<TestEntity> entities = new ArrayList<>(number);

        for (int i=0; i < number; i++) {
            entities.add(new TestEntity(generateRandomString(CHARS_IN_KEY), generateRandomString(CHARS_IN_PAYLOAD)));
        }

        return entities;
    }

    public String generateRandomString(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
