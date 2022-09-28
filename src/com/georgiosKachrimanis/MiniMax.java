package com.georgiosKachrimanis;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {
    public static final String WHITE = "| |";
    public static final String BLACK = "|X|";

    public MiniMax() {
    }

    public int miniMax(Board gameBoard, Player player, boolean isMax, int depth) {

        int x = player.getX();
        int y = player.getY();
        int moveValue = gameBoard.calculateMoveValue(player);

        if (depth == 0) {
            return moveValue;
        }


        if (isMax) {

            int highestValue = Integer.MIN_VALUE;

            for (int i = x - 1; i <= x + 1; i++)
                for (int j = y - 1; j <= y + 1; j++) {
                    Square testSquare = new Square(i, j);
                    if (gameBoard.isValidMove(testSquare)) {
                        gameBoard.setBoardValue(i, j, BLACK);
                        player.setXY(testSquare);
                        highestValue = Math.max(highestValue, miniMax(gameBoard, player, false, depth - 1));
                        gameBoard.setBoardValue(i, j, WHITE);
                    }

                }
            return highestValue;
        } else {
            //System.out.println("Inside the isMax false");
            int lowestValue = Integer.MAX_VALUE;
            for (int i = x - 1; i <= x + 1; i++)
                for (int j = y - 1; j <= y + 1; j++) {
                    Square testSquare = new Square(i,j);
                    if (gameBoard.isValidMove(testSquare)) {
                        gameBoard.setBoardValue(i, j, BLACK);
                        player.setXY(testSquare);
                        lowestValue = Math.min(lowestValue, miniMax(gameBoard, player, true, depth - 1));
                        gameBoard.setBoardValue(i, j, WHITE);
                    }
                }
            return lowestValue;
        }
    }

    public  Square getBestMove(Board gameBoard,Player player){
        List<Square> availableMoves = new ArrayList<>();
        Square startingSquare = new Square(player.getX(), player.getY());
        Square returnSquare = new Square(player.getX(), player.getY(), -1);
        Square testSquare;


        for (int row = returnSquare.getX()-1; row <= returnSquare.getX()+1 ; row++) {
            for (int col = returnSquare.getY()-1; col <= returnSquare.getY()+1; col++) {

                testSquare = new Square(row, col);
                if(gameBoard.isValidMove(testSquare)){
                    gameBoard.setBoardValue(row, col, BLACK);
                    player.setXY(testSquare);
                    int moveValue = miniMax(gameBoard, player, true, 1);
                    availableMoves.add(new Square(row, col, moveValue));
                    gameBoard.setBoardValue(row, col, WHITE);
                }
            }
        }

        for (int i = 0; i < availableMoves.size(); i++) {
            Square square = new Square(availableMoves.get(i).getX(), availableMoves.get(i).getY(),
                    availableMoves.get(i).getSquareValue());
            if(square.getSquareValue() > returnSquare.getSquareValue()){
                returnSquare = square;
            }

        }
        player.setXY(startingSquare);
        return returnSquare;
    }

}




