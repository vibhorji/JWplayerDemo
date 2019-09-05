package com.example.demojwplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.configuration.PlayerConfig;
import com.longtailvideo.jwplayer.media.ads.AdBreak;
import com.longtailvideo.jwplayer.media.ads.AdSource;
import com.longtailvideo.jwplayer.media.ads.ImaAdvertising;
import com.longtailvideo.jwplayer.media.ads.ImaVMAPAdvertising;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



private JWPlayerView jwPlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jwPlayerView = findViewById(R.id.jw);
        List<AdBreak> adSchedule = new ArrayList<>();

        AdBreak adBreak = new AdBreak.Builder()
                .tag("https://www.domain.com/adtag.xml")
                .build();

        adSchedule.add(adBreak);

        ImaAdvertising imaAdvertising = new ImaAdvertising( adSchedule);


        new KeepScreenOnHandler(jwPlayerView, getWindow());
        PlaylistItem pi = new PlaylistItem.Builder()
                .file("https://mobiletak-pdelivery.akamaized.net/mobiletv/video/2019_08/vod_28_aug_19_pok_bol_pkg_2048/vod_28_aug_19_pok_bol_pkg_2048.m3u8")
                .title("BipBop")

                .description("A video player testing video.")
                .build();
        List<PlaylistItem> playlist = new ArrayList<>();
        playlist.add(pi);

        PlayerConfig config = new PlayerConfig.Builder()
                .playlist(playlist)
                .advertising(imaAdvertising)
                .build();
        jwPlayerView.setup(config);

    }


    @Override
    protected void onStart() {
        super.onStart();
        jwPlayerView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        jwPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jwPlayerView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        jwPlayerView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jwPlayerView.onDestroy();
    }

}
