package pt.isec.a21260401a21260412.tpamov_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import pt.isec.a21260401a21260412.tpamov_android.GameLogic.*;

public class GameActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView gridView = findViewById(R.id.gameGridView);
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GameActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });
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


    public class ImageAdapter extends BaseAdapter{
        private Context context;

        public ImageAdapter(Context c){
            this.context = c;
        }
        @Override
        public int getCount() {
            return fields.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(105,105));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //imageView.setPadding(1,8,1,8);
            }else{
                imageView = (ImageView) convertView;
            }

            imageView.setBackgroundColor(fields[position]);
            imageView.setImageResource(balls[0]);

            return imageView;
        }

        private Integer[] balls = {
                R.drawable.black_ball
        };

        private Integer[] fields = {Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"),
                Color.parseColor("#008000"),Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000"), Color.parseColor("#008000")

        };
    }


}
