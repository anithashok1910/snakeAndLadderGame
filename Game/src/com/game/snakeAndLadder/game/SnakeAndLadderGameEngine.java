package com.game.snakeAndLadder.game;

import com.game.snakeAndLadder.game.components.Dice;
import com.game.snakeAndLadder.game.components.GameBoard;
import com.game.snakeAndLadder.game.components.Player;
import com.game.snakeAndLadder.game.components.PlayerStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderGameEngine {

    private GameBoard gameBoard;
    private Dice dice;
    private List <Player> players;
    private int playersCount;

    public SnakeAndLadderGameEngine(){
        //Sets and Adds and creates things
        System.out.println("Game Initiates");
        gameBoard = new GameBoard();
        dice = new Dice();
        System.out.println("Enter the number of players");
        Scanner in = new Scanner(System.in);
        playersCount = in.nextInt();
        players = addPlayersToGame(playersCount);
        gameBoard.printGameBoard();

    }

    public void start(){
        //contains the logic and everything
        System.out.println("Game Starts");
        Boolean hasAnyoneWonTheGame = Boolean.FALSE;
        while(!hasAnyoneWonTheGame){
            gameloop:
            for  (Player player:players) {
                    Integer diceValue;
                    do {
                        diceValue = dice.getDiceValue();
                        System.out.println("Dice Rolled with value: " + diceValue);
                        if(player.getPlayerStatus() == PlayerStatus.PLAYING){
                            player.setCurrentIndex(updatePlayerIndexAfterMove(player.getCurrentIndex(),diceValue));
                            if(gameBoard.isLadderTailPresent(player.getCurrentIndex()) || gameBoard.isSnakeHeadPresent(player.getCurrentIndex())){
                                player.setCurrentIndex(gameBoard.getGameboard()[player.getCurrentIndex()]);
                                printPlayerStatus(player);
                            }
                            if(hasPlayerWon(player.getCurrentIndex())){
                                hasAnyoneWonTheGame = Boolean.TRUE;
                                player.setPlayerStatus(PlayerStatus.FINISHED);
                                System.out.println(player);
                                System.out.println("\n ==== Game end ==== \n");
                                break gameloop;
                            }
                        }else{
                            if(diceValue == Dice.MAXIMUM_DICE_VALUE)
                                player.setPlayerStatus(PlayerStatus.PLAYING);
                        }
                        System.out.println(player);
                    }while(diceValue == Dice.MAXIMUM_DICE_VALUE && player.getPlayerStatus() == PlayerStatus.PLAYING);

            }
        }
    }

    private void printPlayerStatus(Player player) {
        System.out.println("Player "
                + player.getPlayerName()
                + ((gameBoard.isLadderTailPresent(player.getCurrentIndex()))? " has climbed through ladder to "
                + (player.getCurrentIndex() + 1) : " is bitten by Snake and is down to "
                + (player.getCurrentIndex() + 1))
                + " position");
    }

    private List<Player> addPlayersToGame(int playersCount){
        List <Player> players = new ArrayList<>();
        for(int i = 0 ; i < playersCount; i++){
            Player player = createPlayer();
            players.add(player);
        }
        return players;
    }

    private Player createPlayer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter player name");
        String playerName = in.nextLine();   //Add value from user
        System.out.println("Enter color");
        String color = in.nextLine();    //Add value from user
        Player player = new Player(playerName,color);
        return player;
    }

    private Boolean hasPlayerWon(Integer position){
        return position.equals(GameBoard.LAST_POSITION);
    }

    private Integer updatePlayerIndexAfterMove(Integer currentIndex, Integer diceValue){
        if((currentIndex + diceValue) > GameBoard.LAST_POSITION ){
            return GameBoard.LAST_POSITION - (diceValue - (GameBoard.LAST_POSITION - currentIndex));
        }else {
            return currentIndex + diceValue;
        }
    }

}
