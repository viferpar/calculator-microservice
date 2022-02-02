package es.viferpar.micro.shared.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WordMother {

    public static String random() {
        return MotherCreator.random().lorem().word();
    }

}
