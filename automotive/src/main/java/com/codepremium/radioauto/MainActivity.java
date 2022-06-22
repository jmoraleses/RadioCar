package com.codepremium.radioauto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.io.IOException;

public class MainActivity extends Activity {

    private Button btn;
    private boolean playPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExoPlayer player = new ExoPlayer.Builder(getApplicationContext()).build();
        MediaItem mediaItem = MediaItem.fromUri("https://streaming.intereconomia.com/");
        player.setMediaItem(mediaItem);

        btn = (Button) findViewById(R.id.playMusic);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playPause) {
                    btn.setText("Pause Streaming");
                    player.prepare();
                    player.play();
                    playPause = true;
                }
                else {
                    btn.setText("Launch Streaming");
                        player.pause();
                        playPause = false;
                    }
            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (mediaPlayer != null) {
//            mediaPlayer.reset();
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }
//    }

}









