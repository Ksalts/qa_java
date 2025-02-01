package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class TestFeline {
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);
        Assert.assertEquals(3, kittens);
    }
}

