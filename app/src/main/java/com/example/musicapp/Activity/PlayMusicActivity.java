package com.example.musicapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicapp.Adapter.ViewPaperPlaylistMusic;
import com.example.musicapp.Fragment.Fragment_DiaNhac;
import com.example.musicapp.Fragment.Fragment_PlayList;
import com.example.musicapp.Fragment.Fragment_Play_Music;
import com.example.musicapp.Model.BaiHat;
import com.example.musicapp.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayMusicActivity extends AppCompatActivity {

    Toolbar tbPlayMusic;
    TextView txtTimeSong, txtTotalTimeSong;
    SeekBar sbSong;
    ImageButton imgbSuffle, imgbPre, imgbPlay, imgbNext, imgbRepeat;
    ViewPager vpPlayMusic;
    public static ArrayList<BaiHat> mangBaiHat = new ArrayList<>();
    public static ViewPaperPlaylistMusic adapterMusic;
    Fragment_DiaNhac fragment_diaNhac;
    Fragment_Play_Music fragment_play_music;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getDataFromIntent();
        init();
        eventClick();

    }

    private void eventClick() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(adapterMusic.getItem(1) != null) {
                    if(mangBaiHat.size() > 0 ) {
                        fragment_diaNhac.Playnhac(mangBaiHat.get(0).getHinhBaiHat());
                        handler.removeCallbacks(this);
                    }else {
                        handler.postDelayed(this, 300);
                    }
                }
            }
        }, 500);
        imgbPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgbPlay.setImageResource(R.drawable.iconplay);
                } else {
                    mediaPlayer.start();
                    imgbPlay.setImageResource(R.drawable.iconpause);
                }
            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        mangBaiHat.clear();
        if (intent != null) {
            if (intent.hasExtra("cakhuc")) {
                BaiHat baiHat = intent.getParcelableExtra("cakhuc");
                mangBaiHat.add(baiHat);
            }
            if (intent.hasExtra("cacbaihat")) {
                ArrayList<BaiHat> baiHatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangBaiHat = baiHatArrayList;
            }
        }

    }

    private void init() {
        tbPlayMusic = findViewById(R.id.tbPlayMusic);
        txtTimeSong = findViewById(R.id.txtTimeSong);
        txtTotalTimeSong = findViewById(R.id.txtTotalTimeSong);
        sbSong = findViewById(R.id.sbSong);
        imgbSuffle = findViewById(R.id.imgbSuffle);
        imgbPre = findViewById(R.id.imgbPre);
        imgbPlay = findViewById(R.id.imgbPlay);
        imgbNext = findViewById(R.id.imgbNext);
        imgbRepeat = findViewById(R.id.imgbRepeat);
        vpPlayMusic = findViewById(R.id.vpPlayMusic);
        setSupportActionBar(tbPlayMusic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbPlayMusic.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tbPlayMusic.setTitleTextColor(Color.WHITE);
        fragment_diaNhac = new Fragment_DiaNhac();
        fragment_play_music = new Fragment_Play_Music();
        adapterMusic = new ViewPaperPlaylistMusic(getSupportFragmentManager());
        adapterMusic.addFragment(fragment_play_music);
        adapterMusic.addFragment(fragment_diaNhac);
        vpPlayMusic.setAdapter(adapterMusic);
        fragment_diaNhac = (Fragment_DiaNhac) adapterMusic.getItem(1);
        if(mangBaiHat.size() > 0 ) {
            getSupportActionBar().setTitle(mangBaiHat.get(0).getTenBaiHat());
            new PlayMP3().execute(mangBaiHat.get(0).getLinkBaiHat());
            imgbPlay.setImageResource(R.drawable.iconpause);
        }
    }

    class PlayMP3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotalTimeSong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        sbSong.setMax(mediaPlayer.getDuration());
    }

}
