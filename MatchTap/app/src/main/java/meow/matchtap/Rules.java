package meow.matchtap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Rules extends AppCompatActivity {

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }
    public void ToGame(View v){
        Intent intent = new Intent(this, GameWindow.class);
        startActivity(intent);
        this.finish();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Menu.class));
        this.finish();

    }

}
