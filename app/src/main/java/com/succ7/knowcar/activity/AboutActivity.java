package com.succ7.knowcar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.succ7.knowcar.R;
import com.succ7.knowcar.utils.ApkUtils;
import com.succ7.knowcar.utils.AppUtils;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView version = findViewById(R.id.tv_version);
        version.setText(getString(R.string.version_info, AppUtils.getVersionName(this), AppUtils.getVersionCode(this)));
        version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(mBaseActivity, BlurTestActivity.class));
                //给彩虹桥好评
                ApkUtils.openAppInMarket(AboutActivity.this);
            }
        });
    }
}
