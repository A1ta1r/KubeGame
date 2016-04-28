package meow.matchtap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void ToGame(View v){
        Intent intent = new Intent(this, GameWindow.class);
        startActivity(intent);
        this.finish();

    }

    public void ToRules(View v){
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
        this.finish();

    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
