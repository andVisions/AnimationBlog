package com.franktan.animationblog;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class ViewAnimationActivity extends AppCompatActivity {
    private ImageView mImageView;
    private View mFramesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        mImageView = (ImageView) findViewById(R.id.image);
        mFramesView = findViewById(R.id.frames_view);
    }

    public void onRotateButtonClicked(View view) {
        // Tween Animation using Java code
        Animation rotateAnimation = new RotateAnimation(
                0,
                360,
                Animation.RELATIVE_TO_SELF,
                (float) 0.5,
                Animation.RELATIVE_TO_SELF,
                (float) 0.5);
        rotateAnimation.setDuration(500);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        mImageView.startAnimation(rotateAnimation);
    }

    public void onZoomButtonClicked(View view) {
        // Tween Animation using Java code
        Animation scaleDownAnimation = new ScaleAnimation(
                (float) 1.0,
                0,
                (float) 1.0,
                0,
                Animation.RELATIVE_TO_SELF,
                (float) 0.5,
                Animation.RELATIVE_TO_SELF,
                (float) 0.5);
        scaleDownAnimation.setDuration(500);
        scaleDownAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleDownAnimation.setRepeatCount(1);
        scaleDownAnimation.setRepeatMode(Animation.REVERSE);
        mImageView.startAnimation(scaleDownAnimation);
    }

    public void onFadeButtonClicked(View view) {
        // Tween Animation using XML
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout_fadein);
        mImageView.startAnimation(fadeAnimation);
    }

    public void onShakeButtonClicked(View view) {
        // Tween Animation using XML
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        mImageView.startAnimation(fadeAnimation);
    }

    public void onAnimSetButtonClicked(View view) {
        // Tween Animation Set using XML
        Animation animationSet = AnimationUtils.loadAnimation(this, R.anim.disappear);
        mImageView.startAnimation(animationSet);
    }

    public void onFramesButtonClicked(View view) {
        // Frame Animation
        AnimationDrawable animationDrawable = (AnimationDrawable) mFramesView.getBackground();
        animationDrawable.stop();
        animationDrawable.start();
    }
}
