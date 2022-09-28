package com.georgiosKachrimanis;

import java.util.Random;

public class Board {
    private final String[][] gameBoard;
    public static final String WHITE = "| |";
    public static final String BLACK = "|X|";
    public static final String PLAYER_A = "|A|";
    public static final String PLAYER_B = "|B|";


    public Board(int size) {
        this.gameBoard = new String[size][size];
        //create the game tiles
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Math.random() >= 0.20) {
                    gameBoard[i][j] = WHITE;
                } else {
                    gameBoard[i][j] = BLACK;
                }
            }
        }
    }

    public String getBoardValue(Square square) {
        int x =square.getX();
        int y =  square.getY();
        return gameBoard[x][y];
    }

    public void setBoardValue(int x, int y, String value) {
        gameBoard[x][y] = value; // change the value of a Cell(|A|,|B|,| |,|X|)
    }

    // Check if the board square is white
    public boolean isWhite(int x, int y) {
        return gameBoard[x][y].equals("| |");
    }

    // Place player in random position
    public void initPlayer(Player player) {
        boolean isValid = false;

        while (!isValid) {
            int x = new Random().nextInt((gameBoard.length));
            int y = new Random().nextInt((gameBoard.length));
            if (isWhite(x, y)) {
                player.setXY(new Square(x, y));
                gameBoard[x][y] = BLACK;
                isValid = true;
            }
        }
    }

    //Board without player names
    public void showBoard() {
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    //Board with player names
    public void showBoard(Player playerA, Player playerB) {
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                String squareValue;

                if (i == playerA.getX() && j == playerA.getY()) {
                    squareValue = "|A|";
                } else if (i == playerB.getX() && j == playerB.getY()) {
                    squareValue = "|B|";
                } else if (gameBoard[i][j].equals(WHITE)) {
                    squareValue = "| |";
                } else {
                    squareValue = "|X|";
                }
                System.out.print(squareValue);
            }
            System.out.println();
        }

    }

    public int calculateMoveValue(Player player) {
        int moves = 0;
        int x = player.getX();
        int y = player.getY();

        if (x == 0 && y == 0) { //first we get the extreme options of positioning
            if (isWhite(x, y + 1)) moves++;
            if (isWhite(x + 1, y + 1)) moves++;
            if (isWhite(x + 1, y)) moves++;
        } else if (x + 1 == gameBoard.length && y + 1 == gameBoard.length) {
            if (isWhite(x - 1, y)) moves++;
            if (isWhite(x - 1, y - 1)) moves++;
            if (isWhite(x, y - 1)) moves++;
        } else if (x == 0 && y + 1 == gameBoard.length) {
            if (isWhite(x, y - 1)) moves++;
            if (isWhite(x + 1, y - 1)) moves++;
            if (isWhite(x + 1, y)) moves++;
        } else if (x + 1 == gameBoard.length && y == 0) {
            if (isWhite(x - 1, y)) moves++;
            if (isWhite(x - 1, y + 1)) moves++;
            if (isWhite(x, y + 1)) moves++;
        } else if (x == 0) {//Now we check if the player is at the border
            if (isWhite(x, y - 1)) moves++;
            if (isWhite(x, y + 1)) moves++;
            if (isWhite(x + 1, y + 1)) moves++;
            if (isWhite(x + 1, y)) moves++;
            if (isWhite(x + 1, y - 1)) moves++;
        } else if (x + 1 == gameBoard.length) {
            if (isWhite(x, y - 1)) moves++;
            if (isWhite(x, y + 1)) moves++;
            if (isWhite(x - 1, y + 1)) moves++;
            if (isWhite(x - 1, y)) moves++;
            if (isWhite(x - 1, y - 1)) moves++;
        } else if (y == 0) {
            if (isWhite(x - 1, y)) moves++;
            if (isWhite(x + 1, y)) moves++;
            if (isWhite(x + 1, y + 1)) moves++;
            if (isWhite(x, y + 1)) moves++;
            if (isWhite(x - 1, y + 1)) moves++;
        } else if (y + 1 == gameBoard.length) {
            if (isWhite(x - 1, y)) moves++;
            if (isWhite(x + 1, y)) moves++;
            if (isWhite(x - 1, y - 1)) moves++;
            if (isWhite(x, y - 1)) moves++;
            if (isWhite(x + 1, y - 1)) moves++;
        } else { //Last option is if the player is at the normal position
            for (int i = x - 1; i <= x + 1; i++)
                for (int j = y - 1; j <= y + 1; j++) {
                    if (isWhite(i, j)) moves++;
                }
        }

        return moves;
    }

    public int boardLength() {
        return gameBoard.length;
    }

    public boolean isValidMove(Square square) {
        int x = square.getX();
        int y = square.getY();

        if (x<0||x>= gameBoard.length||y<0||y>= gameBoard.length){
            return false;
        }
        if (gameBoard[x][y].equals(WHITE)) {
            return (square.getX() >= 0 && square.getX() < gameBoard.length) &&
                    (square.getY() >= 0 && square.getY() < gameBoard.length);
        }
        return false;
    }
}
