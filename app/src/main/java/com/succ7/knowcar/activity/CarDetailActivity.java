package com.succ7.knowcar.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.succ7.knowcar.R;
import com.succ7.knowcar.bean.Car;

public class CarDetailActivity extends AppCompatActivity {

    private ImageView ivCarlogo;
    private TextView tvCarname;
    private TextView tvCarhome;
    private TextView tvCarbrand;
    private TextView tvCarintro;
    private TextView tvCarlinktobaidu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        initView();
    }

    private void initView() {
        final Car car = (Car) getIntent().getSerializableExtra("car");
        setTitle(car.getCarName());
        ivCarlogo = (ImageView) findViewById(R.id.iv_carlogo);
        tvCarname = (TextView) findViewById(R.id.tv_carname);
        tvCarhome = (TextView) findViewById(R.id.tv_carhome);
        tvCarbrand = (TextView) findViewById(R.id.tv_carbrand);
        tvCarintro = (TextView) findViewById(R.id.tv_carintro);
        tvCarlinktobaidu = (TextView) findViewById(R.id.tv_carlinktobaidu);

        ivCarlogo.setImageResource(car.getCarLogoId());
        tvCarname.setText(car.getCarName());
        tvCarhome.setText(getString(R.string.carhome, car.getCarHome()));

        tvCarintro.setText(getString(R.string.carintro, car.getCarIntroduces()));
        tvCarlinktobaidu.setText(getString(R.string.getmore, car.getCarBDaddress()));
        tvCarlinktobaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDetailActivity.this, CarBaikeActivity.class);
                intent.putExtra("car", car);
                startActivity(intent);
            }
        });
    }

}
