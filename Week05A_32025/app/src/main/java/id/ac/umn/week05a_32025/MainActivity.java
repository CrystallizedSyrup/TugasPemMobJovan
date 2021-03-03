package id.ac.umn.week05a_32025;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    private SeekBar sbRed, sbGreen, sbBlue;
    private RadioGroup rgBentuk;
    private RadioButton rbPilih;
    private ImageButton btnWarna;
    private CustomView customView;
    private int red=0, blue=0, green=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = findViewById(R.id.sbRed);
        sbBlue = findViewById(R.id.sbBlue);
        sbGreen = findViewById(R.id.sbGreen);
        btnWarna = findViewById(R.id.btnWarna);
        rgBentuk = findViewById(R.id.rgBentuk);

        customView = findViewById(R.id.customView);
        customView = new CustomView(this);

        rgBentuk.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int intRb = rgBentuk.getCheckedRadioButtonId();
                        rbPilih = findViewById(intRb);
                        String bentuk = rbPilih.getText().toString();
                        customView.gantiBentuk(bentuk);
                    }
                });

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){

            }
            @Override
            public void onStartTrackingTouch (SeekBar seekBar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekbar){
                red = sbRed.getProgress();
                customView.gantiWarna(red,green,blue);
                btnWarna.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){

            }
            @Override
            public void onStartTrackingTouch (SeekBar seekBar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekbar){
                green = sbGreen.getProgress();
                customView.gantiWarna(red,green,blue);
                btnWarna.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){

            }
            @Override
            public void onStartTrackingTouch (SeekBar seekBar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekbar){
                blue =sbBlue.getProgress();
                customView.gantiWarna(red,green,blue);
                btnWarna.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
    }
}