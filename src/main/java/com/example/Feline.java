package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    @Override
    public int getKittens() { // Теперь этот метод есть в Predator
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
