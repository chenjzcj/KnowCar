package com.succ7.knowcar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.succ7.knowcar.R;
import com.succ7.knowcar.utils.CarHelper;

import java.util.Random;


/**
 * 作者 : 527633405@qq.com
 * 时间 : 2015/12/15 0015
 * 开屏页
 */
public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, R.layout.activity_splash, null);
        setContentView(view);
        // 渐变展示启动屏
        ((ImageView) view.findViewById(R.id.iv_splash)).setImageResource(CarHelper.getSplashResIds()[new Random().nextInt(CarHelper.getSplashResIds().length)]);
        AlphaAnimation aa = new AlphaAnimation(1.0f, 1.0f);
        aa.setDuration(2000);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                enterMainActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }


    /**
     * 启动页面后续的操作
     */
    private void enterMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}
