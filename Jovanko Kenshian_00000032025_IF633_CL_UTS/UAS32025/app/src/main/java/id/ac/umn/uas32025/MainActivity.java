package id.ac.umn.uas32025;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.LinkedList;

import static android.view.Gravity.CENTER_HORIZONTAL;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvDaftarLagu;
    DaftarLaguAdapter mAdapter;
    LinkedList<SumberLagu> daftarLagu = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check();
        isiDaftarLagu();
        rvDaftarLagu = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarLaguAdapter(this, daftarLagu);
        rvDaftarLagu.setAdapter(mAdapter);
        rvDaftarLagu.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        rvDaftarLagu.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiDaftarLagu(){
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Spring 1st Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.spring1));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Spring 2nd Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.spring2));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Spring 3rd Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.spring3));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Summer 1st Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.summer1));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Summer 2nd Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.summer2));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Summer 3rd Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.summer3));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Autumn 1st Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.autumn1));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Autumn 2nd Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.autumn2));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Autumn 3rd Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.autumn3));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Winter 1st Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.winter1));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Winter 2st Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.winter2));
        daftarLagu.add(new SumberLagu("Itzhak Perlman, The Four Seasons, Winter 3st Movement.mp3","android.resource://"+getPackageName()+"/"+R.raw.winter3));
    }

    private void check() {
        Intent intent = getIntent();
        if(intent.hasExtra("nama")){
            AlertDialog.Builder popup = new AlertDialog.Builder(this);
            TextView title = new TextView(this);
            title.setText("Selamat Datang\n");
            title.setGravity(Gravity.CENTER);
            title.setTextSize(16);
            title.setTypeface(title.getTypeface(), Typeface.BOLD);
            popup.setCustomTitle(title);
            TextView message = new TextView(this);
            message.setText("Jovanko Kenshian\n00000032025");
            message.setGravity(Gravity.BOTTOM|CENTER_HORIZONTAL);
            popup.setView(message);
            popup.setPositiveButton("OK", (dialog, which) -> {
                getIntent().removeExtra("nama");
                dialog.cancel();
            });
            AlertDialog alertDialog = popup.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profil:
                Intent profil = new Intent(getApplicationContext(), profil.class);
                profil.putExtra("fromLogin","1");
                startActivity(profil);
                break;
            case R.id.logout:
                Intent back = new Intent(getApplicationContext(), TampilanUtama.class);
                startActivity(back);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}