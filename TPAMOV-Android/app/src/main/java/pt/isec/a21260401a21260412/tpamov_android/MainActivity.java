package pt.isec.a21260401a21260412.tpamov_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.functionalities_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuProfile){
            Intent profileIntent = new Intent(this, ManageProfileActivity.class);
            startActivity(profileIntent);
        }
        else if(item.getItemId() == R.id.menuHistory){
            Intent historyIntent = new Intent(this, HistoryActivity.class);
            startActivity(historyIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
