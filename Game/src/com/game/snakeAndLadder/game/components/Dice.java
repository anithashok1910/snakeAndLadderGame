package com.game.snakeAndLadder.game.components;

import java.util.Random;

public class Dice {

    private Integer diceValue;

    public final static Integer MINIMUM_DICE_VALUE = 1;

    public final static Integer MAXIMUM_DICE_VALUE = 6;

    public Integer getDiceValue() {
        Random randomNumber = new Random();
        diceValue = MINIMUM_DICE_VALUE + randomNumber.nextInt(MAXIMUM_DICE_VALUE);
        return diceValue;
    }

    @Override
    public String toString() {
        return "Dice Value after rolling " + diceValue;
    }
}
