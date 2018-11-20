package pt.isec.a21260401a21260412.aula8api;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadApps();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener(){
                            public void onClick(View v){
                                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });

        rv = findViewById(R.id.rvLista);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setHasFixedSize(true);
        rv.setAdapter(new MyAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    List<ApplicationInfo> lstApp;

    void loadApps(){
        PackageManager pm = getPackageManager();

        lstApp = pm.getInstalledApplications(0);

        rv.requestLayout();

        return;
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
            MyViewHolder mvh = new MyViewHolder(v);
            return mvh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            ApplicationInfo app = lstApp.get(i);
            myViewHolder.icon.setImageDrawable(app.loadIcon(getPackageManager()));
            myViewHolder.nome.setText(app.packageName);
            myViewHolder.desc.setText(app.toString());

        }

        @Override
        public int getItemCount() {
            if(lstApp == null) return 0;

            return lstApp.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView icon;
            TextView nome, desc;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                icon = itemView.findViewById(R.id.ivIcon);
                nome = itemView.findViewById(R.id.tvNome);
                desc = itemView.findViewById(R.id.tvDesc);


            }
        }
    }
}
