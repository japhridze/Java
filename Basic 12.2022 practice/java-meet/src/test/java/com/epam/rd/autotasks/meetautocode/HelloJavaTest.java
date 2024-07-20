package com.epam.rd.autotasks.meetautocode;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HelloJavaTest {

    @Test
    public void test() {

        final ByteArrayOutputStream sink = new ByteArrayOutputStream();
        PrintStream controlledOut = new PrintStream(sink);
        PrintStream defaultOut = System.out;

        System.setOut(controlledOut);

        try {
            HelloJava.main(new String[]{});
            controlledOut.flush();
            final String actual = sink.toString().trim();
            assertEquals("Hello, Java course!", actual, "Your program must print \"Hello, Java course!\" but printed \"" + actual + "\" instead.");
        } finally {
            System.setOut(defaultOut);
        }
    }
}