package com.game.snakeAndLadder.game.components;


import java.util.HashMap;

public class GameBoard {

    public static Integer LAST_POSITION = 99;

    public static Integer GAMEBOARDSIZE = 100;

    private final Integer[] gameBoard = new Integer[GameBoard.GAMEBOARDSIZE];

    private HashMap<Integer,Integer> laddersPositions;

    private HashMap<Integer,Integer> snakesPositions;

    public Integer[] getGameboard() {
        return gameBoard;
    }

    public GameBoard(){
        //Values of the Array should point to which index the player should move
        setDefaultPositions();
        setLaddersInBoard();
        setSnakesInBoard();

    }

    private void setDefaultPositions(){
        for(int position = 0; position < GameBoard.LAST_POSITION; ++position)
        {
            gameBoard[position] = position+1;
        }
        gameBoard[99] = 0;
    }


    private void setLaddersPositions(){
        laddersPositions = new HashMap<>();
        laddersPositions.put(4,14);
        laddersPositions.put(9,31);
        laddersPositions.put(19,38);
        laddersPositions.put(28,84);
        laddersPositions.put(21,42);
        laddersPositions.put(51,76);
        laddersPositions.put(71,91);
        laddersPositions.put(80,97);
    }

    private void setSnakesPositions(){
        snakesPositions = new HashMap<>();
        snakesPositions.put(17,9);
        snakesPositions.put(54,34);
        snakesPositions.put(64,60);
        snakesPositions.put(87,24);
        snakesPositions.put(95,77);
        snakesPositions.put(98,79);
    }

    private void setSnakesInBoard(){
        setSnakesPositions();
        for (Integer position:snakesPositions.keySet()) {
            gameBoard[position-1] = snakesPositions.get(position)-1;
        }

    }

    private void setLaddersInBoard(){
        setLaddersPositions();
        for(Integer position:laddersPositions.keySet()){
            gameBoard[position-1] = laddersPositions.get(position)-1;
        }

    }

    public boolean isSnakeHeadPresent(int position){

        return (gameBoard[position] < position) && (position != GameBoard.LAST_POSITION);
    }

    public boolean isLadderTailPresent(int position){
        return gameBoard[position] > position + 1 ;
    }

    public void printGameBoard(){
        for (Integer position:gameBoard) {
            System.out.println(position);
        }
    }
}
