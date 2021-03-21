package id.ac.umn.uas32025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TampilanUtama extends AppCompatActivity {
    private Button btnlogin, btnprofil;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_utama);
        btnlogin = findViewById(R.id.login);
        btnprofil = findViewById(R.id.profil);

        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profil = new Intent(getApplicationContext(), profil.class);
                profil.putExtra("fromMenu","1");
                startActivity(profil);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), login.class);
                startActivity(login);
            }
        });
    }
}