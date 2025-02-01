package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Mock
    Feline feline;

    @InjectMocks
    Cat cat;

    @Test
    public void getSoundIsCorrect() {
        String expectedString = "Мяу";
        MatcherAssert.assertThat("Кот мяукает не так",
                cat.getSound(),
                equalTo(expectedString)
        );
    }

    @Test
    public void getFoodIsCorrect() throws Exception {
        List<String> expectedListOfFood = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Вернулся некорректный список еды",
                cat.getFood(),
                equalTo(expectedListOfFood)
        );
    }
}
