package com.succ7.knowcar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.succ7.knowcar.R;
import com.succ7.knowcar.bean.Car;

/**
 * 车的百度百科介绍
 */
public class CarBaikeActivity extends AppCompatActivity {
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_baike);

        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);

        final Car car = (Car) getIntent().getSerializableExtra("car");
        setTitle(car.getCarName());

        final WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(true);          //支持缩放
        settings.setBuiltInZoomControls(true);  //启用内置缩放装置
        settings.setJavaScriptEnabled(true);    //启用JS脚本

        webView.setWebViewClient(new WebViewClient() {
            //当点击链接时,希望覆盖而不是打开新窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);  //加载新的url
                return true;    //返回true,代表事件已处理,事件流到此终止
            }

        });
        //点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }

        });

        webView.setWebChromeClient(new WebChromeClient() {
            //当WebView进度改变时更新窗口进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //Activity的进度范围在0到10000之间,所以这里要乘以100
                CarBaikeActivity.this.setProgress(newProgress * 100);
                if (newProgress < 100) {
                    pb.setProgress(newProgress);
                } else {
                    pb.setVisibility(View.GONE);
                }
            }
        });
        webView.loadUrl(car.getCarBDaddress());
    }
}
