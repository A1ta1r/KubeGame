package meow.matchtap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameWindow extends AppCompatActivity {
    Button activeBtn;
    Game game = new Game();
    boolean done = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);
    }

    public void Restart(View v) {
        game.setWinTurns(game.getSteps());
        game = new Game();
        TextView txtRequest = (TextView) findViewById(R.id.txtRes);
        TextView txtStep = (TextView) findViewById(R.id.txtSteps);
        for (int i = 0; i < game.getSIZE(); i++) {
            Button btn = (Button) findViewById(R.id.btn11 + i);
            btn.setEnabled(true);
            btn.setText("");
            txtRequest.setText("Select a block");
            txtStep.setText(game.getSteps() + "");
        }
    }

    public void CheckButtons() {
        int[] x = game.getNumbers();
        for (int i = 0; i < game.getSIZE(); i++) {
            Button btn = (Button) findViewById(R.id.btn11 + i);
            if (x[i] == game.doneVal) {
                btn.setEnabled(false);
            }
        }
    }

    public void ToWin() {
        Intent intent = new Intent(this, Win.class);
        startActivity(intent);
        this.finish();

    }

    public void ToMenu(final View v) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        this.finish();
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                Restart(v);
            }
        },1000);


    }

    public void BtnClicked(View v) throws InterruptedException {
        if (((Button) v).getText() == "") {
            TextView txtRequest = (TextView) findViewById(R.id.txtRes);
            TextView txtStep = (TextView) findViewById(R.id.txtSteps);
            final int i = v.getId() - R.id.btn11;
            final Button newBtn = (Button) v;
            newBtn.setText(game.getNumbers()[i] + "");
            if (game.SecondClick()) {
                final int newI = activeBtn.getId() - R.id.btn11;
                if (game.getNumbers()[i] == game.getNumbers()[newI]) {
                    game.MatchFound(i, newI);
                    CheckButtons();
                    if (game.endGame) {
                        ToWin();
                        Restart(v);
                        return;
                    }
                } else {
                    game.SwapElements(i, newI);
                    for (int j = R.id.btn11; j <= R.id.btn44; j++)
                        ((Button) findViewById(j)).setEnabled(false);
                    int delay = 250;
                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            activeBtn.setText("");
                            newBtn.setText("");
                            if (!done)
                                for (int j = R.id.btn11; j <= R.id.btn44; j++)
                                    ((Button) findViewById(j)).setEnabled(true);
                            done = true;
                        }
                    }, delay);
                }


                txtRequest.setText("Select a block");
                game.plusStep();
                txtStep.setText(game.getSteps() + "");
            } else {
                activeBtn = (Button) v;
                txtRequest.setText("Find a pair");
            }
            game.EvenStep();
            done = false;
        }

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Menu.class));
        this.finish();
    }

}
