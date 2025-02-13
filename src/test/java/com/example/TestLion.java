package com.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestLion {
    @Test
    public void testInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестный", new Feline()));
    }
    }

