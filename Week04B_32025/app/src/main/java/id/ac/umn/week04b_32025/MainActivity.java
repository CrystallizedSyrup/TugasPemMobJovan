package id.ac.umn.week04b_32025;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button m1,m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1 = findViewById(R.id.main_button_change_1);
        m2 = findViewById(R.id.main_button_change_2);

        m1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        m2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}