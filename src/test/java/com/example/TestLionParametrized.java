package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class TestLionParametrized {
    private final String sex;
    private final boolean expectedHasMane;
    private Lion lion;
    private Predator mockPredator;

    public TestLionParametrized(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, Грива: {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() throws Exception {
        mockPredator = mock(Predator.class);
        when(mockPredator.getKittens()).thenReturn(3);
        when(mockPredator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        lion = new Lion(sex, mockPredator);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        assertEquals(3, lion.getKittens());
        verify(mockPredator, times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(mockPredator, times(1)).eatMeat();
    }
}

