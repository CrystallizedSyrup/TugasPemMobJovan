package id.ac.umn.uas32025;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class playLagu extends AppCompatActivity {
    private TextView etJudul;
    private MediaPlayer mediaPlayer;
    private ImageButton start;
    private SeekBar seekBar;
    boolean playing = false;
    private Handler mSeekbarUpdateHandler = new Handler();
    private Runnable mUpdateSeekbar = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            mSeekbarUpdateHandler.postDelayed(this, 50);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_lagu);
        etJudul = findViewById(R.id.etJudul);
        start = findViewById(R.id.play);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberLagu lagu = (SumberLagu) bundle.getSerializable(
                "play");
        String link = lagu.getUri();
        etJudul.setText(lagu.getJudul());
        mediaPlayer = MediaPlayer.create(
                this, Uri.parse(link));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!playing){
                    seekBar.setMax(mediaPlayer.getDuration());
                    mediaPlayer.start();
                    mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar, 0);
                    start.setBackgroundResource(R.drawable.pause);
                    playing = true;
                } else {
                    mediaPlayer.pause();
                    mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
                    start.setBackgroundResource(R.drawable.playing);
                    playing = false;
                }
            }
        });
        seekBar = findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
                if(fromTouch) mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mediaPlayer != null) {
                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        mediaPlayer.pause();
        mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
        playing = false;
        super.onDestroy();
        clear();
    }

    private void clear() {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}