package com.succ7.knowcar.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.succ7.knowcar.R;
import com.succ7.knowcar.adapter.CarListAdapter;
import com.succ7.knowcar.adapter.SettingAdapter;
import com.succ7.knowcar.bean.Car;
import com.succ7.knowcar.utils.CarHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    GridView mGridView;
    CarListAdapter carListAdapter;
    private List<Car> cars;
    private SettingAdapter settingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cars = getCars();
        mGridView = (GridView) findViewById(R.id.gv_cars);
        mListView = (ListView) findViewById(R.id.lv_cars);
        initView();
    }

    private void initView() {
        if (getState()) {
            initGridView();
            mListView.setVisibility(View.GONE);
            mGridView.setVisibility(View.VISIBLE);
        } else {
            initListView();
            mGridView.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
        }
    }

    private void initGridView() {
        settingAdapter = new SettingAdapter(cars, this);
        mGridView.setAdapter(settingAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CarDetailActivity.class);
                intent.putExtra("car", cars.get(position));
                startActivity(intent);
            }
        });
    }

    private void initListView() {
        carListAdapter = new CarListAdapter(cars, this);
        mListView.setAdapter(carListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CarDetailActivity.class);
                intent.putExtra("car", cars.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_switch:
                saveState(!getState());
                initView();
                break;
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        return true;
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        String[] carInfos = getResources().getStringArray(R.array.carInfos);
        String[] carIntroduces = getResources().getStringArray(R.array.carIntroduces);
        int[] carLogoIds = CarHelper.getCarLogoIds();
        for (int i = 0; i < carInfos.length; i++) {
            Car car = new Car();
            car.setCarName(carInfos[i].split("%")[0]);
            car.setCarHome(carInfos[i].split("%")[1].split("#")[0]);
            car.setCarBDaddress(carInfos[i].split("%")[1].split("#")[1]);
            car.setCarLogoId(carLogoIds[i]);
            car.setCarIntroduces(carIntroduces[0]);
            cars.add(car);
        }
        return cars;
    }

    private void saveState(boolean iGridView) {
        SharedPreferences state = getSharedPreferences("state", MODE_PRIVATE);
        state.edit().putBoolean("iGridView", iGridView).apply();
    }

    private boolean getState() {
        SharedPreferences state = getSharedPreferences("state", MODE_PRIVATE);
        return state.getBoolean("iGridView", true);
    }
}
