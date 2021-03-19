package id.ac.umn.week07b_32025;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvDaftarVideo;
    DaftarVideoAdapter mAdapter;
    LinkedList<SumberVideo> daftarVideo = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isiDaftarVideo();
        rvDaftarVideo = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarVideoAdapter(this, daftarVideo);
        rvDaftarVideo.setAdapter(mAdapter);
        rvDaftarVideo.setLayoutManager(new LinearLayoutManager(this));
    }



    public void isiDaftarVideo(){

        daftarVideo.add(new SumberVideo("CHRISTIAN LI / Menuhin Competition 2018, Junior finals",
                "Christian Li Jaehyuck Choi Self in Mind & A. Vivaldi The Four Seasons, Op. 8, Summer",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.christianli));
        daftarVideo.add(new SumberVideo("Porcsche 918",
                "Menikmati mobil sport Porsche 918 Spyder",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.porsche918));
    }
}