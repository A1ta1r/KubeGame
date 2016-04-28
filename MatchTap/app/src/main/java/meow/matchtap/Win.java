package meow.matchtap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        TextView txtSteps = (TextView) findViewById(R.id.txtWinSteps);
        txtSteps.setText("You made it in "+(Game.getWinTurns()+1)+" turns!");
    }

    public void ToGame(View v){
        Intent intent = new Intent(this, GameWindow.class);
        startActivity(intent);
        this.finish();

    }

    public void ToMenu(View v){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        this.finish();

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Menu.class));
        this.finish();
    }

}
