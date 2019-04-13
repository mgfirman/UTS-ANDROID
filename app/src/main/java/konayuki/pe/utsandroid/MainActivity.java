package konayuki.pe.utsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    MediaController media_Controller;
    DisplayMetrics dm;

    VideoView videoViewSaya;
    TextView txtJudul;

    @verride
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view
        videoViewSaya = (VideoView) findViewById(R.id.videoViewUtama);
        txtJudul = (TextView) findViewById(R.id.txtJudul);

        // inisialisasi
        media_Controller = new MediaController(this);
        dm = new DisplayMetrics();

        // ambil ukuran layar
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;

        // lebar dan tinggi video view diberi nilai agar menyesuaikan ukuran layout
        videoViewSaya.setMinimumWidth(width);
        videoViewSaya.setMinimumHeight(height);

        // kontroler video
        videoViewSaya.setMediaController(media_Controller);
    }

    private void muatVideo(String judul, String nama_file) {
        // kasih judul
        txtJudul.setText(judul);

        // ambil video
        videoViewSaya.setVideoPath("android.resource://"+getPackageName()+"/raw/"+nama_file);

        // mulai
        videoViewSaya.start();
    }

    public void video1(View view) { muatVideo("Trik Memasukkan Benang ke Jarum", "telu"); }
    public void video2(View view) {
        muatVideo("Kucing Mau Lompat", "loro");
    }
    public void video3(View view) {
        muatVideo("Hypnotism Tata Surya", "siji");
    }







    //ini adalah Activity Lifecycle
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "OnRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
