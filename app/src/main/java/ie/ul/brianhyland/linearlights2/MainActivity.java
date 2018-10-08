package ie.ul.brianhyland.linearlights2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LightsOutGame mGame;
    private TextView mGameStateTextView;
    private Button[] lButtons;
    //public int numberButtons = 7;
    //private int numButtons = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGame = new LightsOutGame(7);
        mGameStateTextView = findViewById(R.id.game_state_text_view);
        lButtons = new Button[LightsOutGame.numButtons];
        lButtons[0] = findViewById(R.id.button0);
        lButtons[1] = findViewById(R.id.button1);
        lButtons[2] = findViewById(R.id.button2);
        lButtons[3] = findViewById(R.id.button3);
        lButtons[4] = findViewById(R.id.button4);
        lButtons[5] = findViewById(R.id.button5);
        lButtons[6] = findViewById(R.id.button6);
        updateView();
    }

    public void pressedButton(View view) {
        String tagAsStr = view.getTag().toString();
        int tagAsInt = Integer.parseInt(tagAsStr);
        mGame.pressedButtonAtIndex(tagAsInt);
        updateView();

    }

    public void pressedNewGame(View view) {

        mGame = new LightsOutGame(1);
        updateView();
    }


    private void updateView() {
        mGameStateTextView.setText((CharSequence) mGame.stringForGameState());
        for (int i = 0; i < lButtons.length; i++)
            //lButtons[0].setText(mGame.toString());
            lButtons[i].setText(mGame.stringForButtonAtIndex(i));

    }
}
