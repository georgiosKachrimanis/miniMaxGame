package com.georgiosKachrimanis;

public class Main {

    public static final int BOARD_SIZE = 15;
    public static final String WHITE = "| |";
    public static final String BLACK = "|X|";
    public static final String PLAYER_A = "|A|";
    public static final String PLAYER_B = "|B|";


    public static void main(String[] args) {
        boolean hasMoves = true;
        boolean isTurn = true; //True=Player A, False Player B
        // Making new board game
        Board board = new Board(BOARD_SIZE);
        //create new players
        Player playerA = new Player();
        Player playerB = new Player();
        //Place players on the board
        board.initPlayer(playerA);
        board.initPlayer(playerB);

        //Board
        System.out.println("------------------------------------------------------------------");
        System.out.println("Player A starts at" + playerA);
        System.out.println("Player B starts at" + playerB);
        board.showBoard(playerA, playerB);
        System.out.println("------------------------------------------------------------------");


        MiniMax miniMax = new MiniMax();

        while(hasMoves){

            if (isTurn){

                if (miniMax.getBestMove(board, playerA).getSquareValue() != -1){
                    playerA.setXY(miniMax.getBestMove(board, playerA));
                    board.setBoardValue(playerA.getX(), playerA.getY(), Board.BLACK);
                    isTurn=false;
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Player A moves to " + playerA);

                } else{
                    hasMoves = false;
                    System.out.println("Player A lost the game.");
                }

            } else{
                if (miniMax.getBestMove(board, playerB).getSquareValue() != -1){
                    playerB.setXY(miniMax.getBestMove(board, playerB));
                    board.setBoardValue(playerB.getX(), playerB.getY(), Board.BLACK);
                    isTurn=true;
                    System.out.println("Player B moves to " + playerB);
                } else{
                    hasMoves = false;
                    System.out.println("Player B lost the game.");
                }
            }
            board.showBoard(playerA, playerB);
            System.out.println("------------------------------------------------------------------");

        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Final game board.");
        board.showBoard(playerA, playerB);
        System.out.println("------------------------------------------------------------------");
    }
}
