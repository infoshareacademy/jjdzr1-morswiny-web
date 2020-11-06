package com.isa.morswiny.mailService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataCheckTest {

    @Test
    void checkIncorrectEmail(){

        boolean result = DataCheck.isEmailCorrect("email");
        Assertions.assertFalse(result);

    }

    @Test
    void checkCorrectEmail(){

        boolean result = DataCheck.isEmailCorrect("newemail@o2.pl");
        Assertions.assertTrue(result);
    }
}
