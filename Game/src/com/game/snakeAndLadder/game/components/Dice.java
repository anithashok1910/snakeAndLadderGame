package com.game.snakeAndLadder.game.components;

import java.util.Random;

public class Dice {

    private Integer diceValue;

    private final Integer minimumDiceValue = 1;

    private final Integer maximumDiceValue = 6;

    public Integer getDiceValue() {
        Random randomNumber = new Random();
        diceValue = minimumDiceValue + randomNumber.nextInt(maximumDiceValue);
        return diceValue;
    }

    @Override
    public String toString() {
        return "Dice Value after rolling " + diceValue;
    }
}
