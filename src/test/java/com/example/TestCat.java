package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestCat {

    private Cat cat;
    private Predator mockFeline;

    @BeforeEach
    void setUp() {
        mockFeline = mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    void testGetSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFoodCallsEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
        verify(mockFeline, times(1)).eatMeat();
    }
}
