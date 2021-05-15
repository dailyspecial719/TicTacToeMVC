package com.generally2.tictactoemvc;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;


public class TicTacToeGame {
    private enum GameState {
        X_TURN,
        O_TURN,
        X_WIN,
        O_WIN,
        TIE_GAME;

        private GameState gameState;
        private int [][] boardArray;
        private  Context context;

        public static final int NUM_ROWS = 3;
        public static final int NUM_COLUMNS = 3;

        private static final int MARK_NONE = 0;
        private static final int MARK_X = 1;
        private static final int MARK_O = 2;

        public void TicTacToeGame(Context context){
            this.context = context;
            resetGame();
        }

        private void resetGame() {
            this.boardArray= new int[NUM_ROWS][NUM_COLUMNS];
            this.gameState = GameState.X_TURN;
        }

        public void pressedButtonAtLocation(int row,int column){
            if (row < 0 || row > NUM_ROWS || column < 0 || column > NUM_COLUMNS){
                return; // not a valid square location
            }
            if (this.boardArray[row][column] != MARK_NONE){
                return; //empty
            }
            if (this.gameState == GameState.X_TURN){
                this.boardArray[row][column] = MARK_X;
                this.gameState = GameState.O_TURN;
            } else  if (this.gameState ==GameState.O_TURN){
                this.boardArray[row][column] = MARK_O;
                this.gameState = GameState.X_TURN;
            }

            checkForWin();

        }

        private void checkForWin() {
            if (!(this.gameState == GameState.X_TURN || this.gameState ==GameState.O_TURN)){
                return;
            }

        }
    }
}
