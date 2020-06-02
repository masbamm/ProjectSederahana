package iqbalyusuf.id.masjidku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView profile, laporan, jadwal, contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profile = (CardView) findViewById(R.id.profil);
        laporan = (CardView) findViewById(R.id.laporan);
        jadwal = (CardView) findViewById(R.id.jadwal);
        contact = (CardView) findViewById(R.id.contact);

        profile.setOnClickListener(this);
        laporan.setOnClickListener(this);
        jadwal.setOnClickListener(this);
        contact.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Intent i ;

        switch (view.getId()){
            case R.id.profil: i = new Intent(this,AboutActivity.class);startActivity(i);break;
            case R.id.laporan: i = new Intent(this,LaporanActivity.class);startActivity(i);break;
            case R.id.jadwal: i = new Intent(this,JadwalActivity.class);startActivity(i);break;
            case R.id.contact: i = new Intent(this,ContactActivity.class);startActivity(i);break;

            default:break;
        }

    }
}