package pt.isec.a21260401a21260412.tpamov_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.IOException;

public class HistoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        LoadFile();
        ListView listView = (ListView)findViewById(R.id.HistoryTable);




    }


    public void LoadFile (){
        String infoToShow = "";

        try {
            FileInputStream fileToLoad = new FileInputStream("historyFile");
            byte [] buffer = new byte[256];
            fileToLoad.read(buffer);
            fileToLoad.close();
            infoToShow = new String (buffer);

        }catch(IOException errorr){
            messageToShow("FILE Error", "" + errorr);
        }
    }

    //Function to show a alertDialog on Activity with the message you want
    public void messageToShow (String title, String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(HistoryActivity.this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setNeutralButton("OK",null);
        alertDialog.show();
    }
}
