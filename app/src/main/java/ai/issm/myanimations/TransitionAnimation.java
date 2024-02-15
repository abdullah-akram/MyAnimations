package ai.issm.myanimations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import ai.issm.myanimations.databinding.ActivityMainBinding;
import ai.issm.myanimations.databinding.ActivityTransitionAnimationBinding;

public class TransitionAnimation extends AppCompatActivity {

    private ActivityTransitionAnimationBinding activityTransitionAnimationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityTransitionAnimationBinding = ActivityTransitionAnimationBinding.inflate(getLayoutInflater());
        setContentView(activityTransitionAnimationBinding.getRoot());
        activityTransitionAnimationBinding.btnBack.setOnClickListener(v -> {
            finish();
        });
        activityTransitionAnimationBinding.btnAnimate.setOnClickListener(v -> {
            Pair<View, String> p1 = Pair.create(((View) activityTransitionAnimationBinding.cardView), "image");
            Pair<View, String> p2 = Pair.create(((View) activityTransitionAnimationBinding.txtMessage), "text");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, p1, p2);
            Intent intent = new Intent(TransitionAnimation.this, SecondTransition.class);
            startActivity(intent, options.toBundle());

        });


    }
}