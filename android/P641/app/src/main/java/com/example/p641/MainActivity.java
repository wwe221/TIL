package com.example.p641;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int position = 0;
    public static final String VIDEO_URL = "https://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //playAudio();
        videoView = findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            releaseMedia();
        }
    }

    public void releaseMedia(){
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
    }
    public void playAudio(){
        releaseMedia();
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.sample);

        mediaPlayer.start();
    }
    public void play(View view){
        playAudio();
    }

    public void stop(View view){

    }
    public void pause(View view){

    }
    public void replay(View view){
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_video);
        videoView.setVideoURI(uri);

        videoView.requestFocus();
        videoView.start();
    }

}
