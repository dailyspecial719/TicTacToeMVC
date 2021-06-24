package com.generally2.tictactoemvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TicTacToeGame mGame = new TicTacToeGame();
    private TextView mGameSateTextView;
    private Button[][] mTicTacToeButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGame.resetGame();

        mGameSateTextView = findViewById(R.id.message_txt);


        Button newGameButton = findViewById(R.id.new_game_btn);
        newGameButton.setOnClickListener(this);

        mTicTacToeButtons = new Button[TicTacToeGame.NUM_ROWS][TicTacToeGame.NUM_COLUMNS];
      //  mTicTacToeButtons[0][0]= findViewById(R.id.btn00);
        for (int row = 0; row < TicTacToeGame.NUM_ROWS; row++){
            for (int col = 0; col < TicTacToeGame.NUM_COLUMNS; col++){
                int id = getResources().getIdentifier("button" + row + col, "id", getPackageName());
                mTicTacToeButtons[row][col] = findViewById(id);
                mTicTacToeButtons[row][col].setOnClickListener(this);
            }

        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.new_game_btn){
            mGame.resetGame();
        }

        for (int row = 0; row < TicTacToeGame.NUM_ROWS; row++) {
            for (int col = 0; col < TicTacToeGame.NUM_COLUMNS; col++) {
                if (view.getId() == mTicTacToeButtons[row][col].getId()){
                    Log.d("TTT", "Button pressed at " + row + " " + col);

                }
                mGameSateTextView.setText(mGame.stringForGameState());


            }
        }



        //you are here, game not working 13:57 on controller video
    }
}