package com.codepremium.radioauto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.io.IOException;

public class MainActivity extends Activity {

    private ImageButton btn;
    private boolean playPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ExoPlayer player = new ExoPlayer.Builder(getApplicationContext()).build();
        MediaItem mediaItem = MediaItem.fromUri("https://streaming.intereconomia.com/");
        player.setMediaItem(mediaItem);

        btn = findViewById(R.id.exo_play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playPause) {
                    btn.setBottom(R.id.exo_pause);
                    player.prepare();
                    player.play();
                    playPause = true;
                }
                else {
                    btn.setBottom(R.id.exo_play); //setText("Launch Streaming");
                    player.pause();
                    playPause = false;
                    }
            }
        });
    }

}









