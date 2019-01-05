package com.example.king.dsweek002.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;

import com.example.king.dsweek002.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();
    }

    private void initData() {
        //设置动画
        //获取屏幕宽度
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int heightPixels = metrics.heightPixels;
        //平移
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mImageView,"translationY",
                0,heightPixels/2 - mImageView.getHeight()/2);
        //缩放
        ObjectAnimator objectAnimator21 = ObjectAnimator.ofFloat(mImageView,"scaleX",2,1);
        ObjectAnimator objectAnimator22 = ObjectAnimator.ofFloat(mImageView,"scaleY",2,1);
        //渐变
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mImageView,"alpha",0,1);
        //选转
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mImageView,"rotation",0,360);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator1).with(objectAnimator21)
                .with(objectAnimator22).with(objectAnimator3).with(objectAnimator4);
        animatorSet.setDuration(3000);
        animatorSet.start();

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
    }

    private void initView() {
        getSupportActionBar().hide();
        mImageView = (ImageView) findViewById(R.id.imageView);
    }
}
