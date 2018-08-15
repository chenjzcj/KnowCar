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
 * author : 527633405@qq.com
 * time : 2016/4/5
 */
public class CarListAdapter extends BaseAdapter {
    private List<Car> datas;
    private Context context;

    public CarListAdapter(List datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null ? datas.get(position) : position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout_car_item, null);
            viewHolder = new ViewHolder();
            viewHolder.carLogo = (ImageView) convertView.findViewById(R.id.iv_carlogo);
            viewHolder.carName = (TextView) convertView.findViewById(R.id.tv_carname);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.carLogo.setImageResource(datas.get(position).getCarLogoId());
        viewHolder.carName.setText(datas.get(position).getCarName());
        return convertView;
    }

    class ViewHolder {
        ImageView carLogo;
        TextView carName;
    }
}
