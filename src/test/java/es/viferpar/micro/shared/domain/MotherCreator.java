package es.viferpar.micro.shared.domain;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MotherCreator {

    private final static Faker faker = new Faker();

    public static Faker random() {
        return faker;
    }

}
