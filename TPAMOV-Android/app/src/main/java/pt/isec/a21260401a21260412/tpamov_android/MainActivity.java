package pt.isec.a21260401a21260412.tpamov_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView title;
    Button btnOP, btnTP, btnM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.MenuTitle);
        btnOP = findViewById(R.id.btnOnePlayer);
        btnTP = findViewById(R.id.btnTwoPlayers);
        btnM = findViewById(R.id.btnMultiplayer);

    }

    public void onOnePlayer(View v){

    }

    public void onTwoPlayers(View v){

    }

    public void onMultiplayer(View v){

    }

}
