package io.simpolor.utils;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RandomGerneratorTest {

    @Test
    public void testGeneratorName(){

        // give, when
        String result = RandomGenerator.generateName();

        // then
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void testGeneratorAge(){

        // give, when
        int result = RandomGenerator.generateAge();

        // then
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void testGeneratorHobby(){

        // give, when
        String result = RandomGenerator.generateHobby();

        // then
        System.out.println(result);
        assertNotNull(result);
    }
}
