package ai.issm.myanimations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.window.OnBackInvokedDispatcher;

import ai.issm.myanimations.databinding.ActivitySecondTransitionBinding;

public class SecondTransition extends AppCompatActivity {

   private ActivitySecondTransitionBinding activitySecondTransitionBinding;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySecondTransitionBinding = ActivitySecondTransitionBinding.inflate(getLayoutInflater());
        setContentView(activitySecondTransitionBinding.getRoot());

        activitySecondTransitionBinding.btnBack.setOnClickListener(v -> {
            finish();
        });



        activitySecondTransitionBinding.cardView.animate()
//                .translationY(-6.0f)
                .scaleX(0.90f)
                .scaleY(0.90f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // Apply bounce effect when the animation ends
                        activitySecondTransitionBinding.cardView.animate()
                                .scaleX(1.0f)
                                .scaleY(1.0f)
                                .setDuration(400)
//                                .translationY(5.0f)
                                .start();
                    }
                })
                .start();
        activitySecondTransitionBinding.txtMessage.animate()
//                .translationY(-6.0f)
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setListener(new AnimatorListenerAdapter() {
                    @SuppressLint("UseCompatLoadingForDrawables")
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        activitySecondTransitionBinding.txtMessage.setBackground(getDrawable(R.drawable.send_msg_body));

                        activitySecondTransitionBinding.txtMessage.animate()
                                .scaleX(1.0f)
                                .scaleY(1.0f)
                                .setDuration(400)
//                                .translationY(5.0f)
                                .start();

                    }
                })
                .start();


    }
}