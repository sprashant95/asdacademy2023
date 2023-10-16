package com.example.asdadvertiseapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    AdView adView;

    InterstitialAd myInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = findViewById(R.id.adView);

        MobileAds.initialize(this);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e("error","ad not loaded");
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);

                 myInterstitialAd = interstitialAd;

                 myInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                     @Override
                     public void onAdClicked() {
                         super.onAdClicked();
                     }

                     @Override
                     public void onAdDismissedFullScreenContent() {
                         super.onAdDismissedFullScreenContent();
                     }

                     @Override
                     public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                         super.onAdFailedToShowFullScreenContent(adError);
                     }

                     @Override
                     public void onAdImpression() {
                         super.onAdImpression();
                     }

                     @Override
                     public void onAdShowedFullScreenContent() {
                         super.onAdShowedFullScreenContent();
                         myInterstitialAd = null;
                     }
                 });

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (myInterstitialAd != null){
                    myInterstitialAd.show(MainActivity.this);
                }
            }
        },10000);

    }
}