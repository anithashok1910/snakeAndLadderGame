package com.game.snakeAndLadder.game.components;

public class Player {

    private String playerName;
    private String color;
    private Integer currentIndex;
    private PlayerStatus playerStatus;

    public Player(String playerName, String color) {
        this.playerName = playerName;
        this.color = color;
        this.currentIndex = 0;
        this.playerStatus = PlayerStatus.JOINED;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getColor() {
        return color;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    @Override
    public String toString() {
        return "Player:"+ playerName + " with color: " + color
                + " has moved to the "+ (currentIndex +1)
                + " and " + ((playerStatus == PlayerStatus.PLAYING)? "is playing" :
                ((playerStatus == PlayerStatus.FINISHED)? "has won":"has not started yet")) + "\n";
    }
}
