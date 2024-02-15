package ai.issm.myanimations;

import static java.lang.Math.abs;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.animation.LinearInterpolator;

import ai.issm.myanimations.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity {

    float previousZ = 0.0f;
    SoundPool soundPool;
    ActivityMusicBinding activityMusicBinding;
    private int soundId, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13;
    private int[] sounds = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20};

    int xabs;
    int yabs;
    int prevy;
    float convertedValue = 1.0f; // Default pitch
    private float pitch = 1.0f; // Default pitch
    int cnt = 0;
    ObjectAnimator objectAnimator;
    private Handler handler = new Handler();


    @SuppressLint({"ClickableViewAccessibility", "ObjectAnimatorBinding"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMusicBinding = ActivityMusicBinding.inflate(getLayoutInflater());

        setContentView(activityMusicBinding.getRoot());
        xabs = 0;
        yabs = 0;
        SoundActivity();
        SensorActivity();

        objectAnimator = ObjectAnimator.ofArgb(this, "color", Color.BLUE, Color.RED);
        objectAnimator.setDuration(3000);
        objectAnimator.setInterpolator(new LinearInterpolator());


        activityMusicBinding.btnplaysound.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Start playing the sound when button is pressed
                        s1 = soundPool.play(sounds[1], 1.0f, 1.0f, 1, -1, 1.0f);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Stop playing the sound when button is released or canceled
                        soundPool.stop(s1);
//                        soundPool.autoPause();
                        break;
                }
                return true;
            }
        });


//        activityMusicBinding.btnplaysound.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                activityMusicBinding.btnplaysound.setEnabled(false);
//                startAnimate();
//                Log.d("smol", "xabs: " + xabs + "");
//                cnt += 1;
//                soundPool.play(sounds[xabs], 1, 1, cnt, 0, 1);
//                if(prevy!=yabs) {
//
//                    soundPool.play(sounds[yabs + 9], 1, 1, cnt, 0, 1);
//                prevy = yabs;
//                }
//                activityMusicBinding.btnplaysound.setEnabled(true);
//
//            }
//        });

    }

    public void startAnimate() {
        ObjectAnimator colorAnimator = ObjectAnimator.ofObject(
                activityMusicBinding.btnplaysound,
                "backgroundColor",
                new ArgbEvaluator(),
                Color.BLUE,  // Normal color
                Color.RED,
                Color.YELLOW// Color when clicked
        );

        colorAnimator.setDuration(500);


        colorAnimator.start();
    }


    public void SoundActivity() {
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();

        soundId = soundPool.load(this, R.raw.cutted_audio, 1);


        sounds[0] = soundPool.load(this, R.raw.c, 1);
        sounds[1] = soundPool.load(this, R.raw.c, 1);
        sounds[2] = soundPool.load(this, R.raw.d, 1);
        sounds[3] = soundPool.load(this, R.raw.d, 1);
        sounds[4] = soundPool.load(this, R.raw.e, 1);
        sounds[5] = soundPool.load(this, R.raw.e, 1);
        sounds[6] = soundPool.load(this, R.raw.f, 1);
        sounds[7] = soundPool.load(this, R.raw.f, 1);
        sounds[8] = soundPool.load(this, R.raw.g, 1);
        sounds[9] = soundPool.load(this, R.raw.g, 1);
        sounds[10] = soundPool.load(this, R.raw.g, 1);
        sounds[11] = soundPool.load(this, R.raw.a, 1);
        sounds[12] = soundPool.load(this, R.raw.a, 1);
        sounds[13] = soundPool.load(this, R.raw.b, 1);
        sounds[14] = soundPool.load(this, R.raw.b, 1);
        sounds[15] = soundPool.load(this, R.raw.b, 1);
        sounds[16] = soundPool.load(this, R.raw.a_hash, 1);
        sounds[17] = soundPool.load(this, R.raw.a_hash, 1);


    }

    public void SensorActivity() {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener accelerometerListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                int yint = (int) abs(y);
                int xint = (int) abs(x);
                int zint = (int) abs(z);

                Log.d("lolint", "zint: " + zint + "");
                Log.d("lolint", "xint: " + xint + "");



                if (xabs != xint) {
                    convertedValue = (float) (((xint - 0.0) / (10.0 - 0.0))
                            * (2.0 - 0.1) + 0.1);
                    Log.d("convertedValue", "convertedValue: " + convertedValue + "");
                    xabs = xint;
                }

                if (yabs != yint) {
                    yabs = yint;
                    Log.d("yyyy", "yabs: " + yabs + "");

                }


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // Handle accuracy changes if needed.
            }
        };

        sensorManager.registerListener(accelerometerListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);


    }


    @Override
    protected void onStop() {
        super.onStop();
        soundPool.release();
        handler.removeCallbacksAndMessages(null); // Remove any pending callbacks


    }

    private void changePitch() {
        // Adjust the pitch
        pitch += 0.1f;
        if (pitch > 2.0f) {
            pitch = 1.0f; // Reset pitch if it exceeds a certain value
        }
    }

    private void changePitchDecrease() {
        // Adjust the pitch
        pitch -= 0.1f;
        if (pitch < 0.0f) {
            pitch = 1.0f; // Reset pitch if it exceeds a certain value
        }

    }

}