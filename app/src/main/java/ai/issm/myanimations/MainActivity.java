package ai.issm.myanimations;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.window.SplashScreen;

import ai.issm.myanimations.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            getSplashScreen().setOnExitAnimationListener(splashScreenView -> {
                final ObjectAnimator slideUp = ObjectAnimator.ofFloat(
                        splashScreenView,
                        View.TRANSLATION_Y,
                        0f,
                        -splashScreenView.getHeight()
                );
                slideUp.setInterpolator(new AnticipateInterpolator());
                slideUp.setDuration(900L);

                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        splashScreenView.remove();
                    }
                });

                // Run your animation.
                slideUp.start();
            });
        }
        setTheme(R.style.Theme_MyAnimations);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.btnCarouselLayout.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MotionAnimation.class));

        });

        activityMainBinding.btnTransitionActivity.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TransitionAnimation.class));

        });
        activityMainBinding.btnMusicActivity.setOnClickListener(v -> {
//            startActivity(new Intent(MainActivity.this, MusicActivity.class));

        });



    }






}