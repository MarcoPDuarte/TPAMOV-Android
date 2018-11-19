package pt.isec.a21260401a21260412.tpamov_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    //Function to save data containing the winners
    public void saveToFile(){
        try{
            FileOutputStream fileToSave = openFileOutput("historyFile", MODE_APPEND);
            // String infoToSave = //ir buscar as cenas a cada variavel
            //fileToSave.write(infoToSave.getBytes());
            fileToSave.close();

        }catch(FileNotFoundException error){
            messageToShow("FILE Error", "" + error);
        }catch(IOException errorr){
            messageToShow("FILE Error", "" + errorr);
        }

    }



    //Function to show a alertDialog on Activity with the message you want
    public void messageToShow (String title, String message){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(GameActivity.this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setNeutralButton("OK",null);
        alertDialog.show();
    }

}
