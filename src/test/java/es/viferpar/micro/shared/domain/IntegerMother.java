package es.viferpar.micro.shared.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IntegerMother {

    public static Integer random() {
        return MotherCreator.random().number().numberBetween(-10, 10);
    }

}
