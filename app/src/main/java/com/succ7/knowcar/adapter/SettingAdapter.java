package com.succ7.knowcar.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.succ7.knowcar.R;
import com.succ7.knowcar.bean.Car;

import java.util.List;

/**
 * 作者 : 527633405@qq.com
 * 时间 : 2015/12/16 0016
 */
public class SettingAdapter extends BaseAdapter {
    private Context context;
    private List<Car> cars;

    public SettingAdapter(List<Car> cars, Context context) {
        this.context = context;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout_setting_grid_item, null);
            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_item);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Car car = (Car) getItem(position);
        holder.iv.setImageResource(car.getCarLogoId());
        holder.tv.setText(car.getCarName());
        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView tv;
    }
}
