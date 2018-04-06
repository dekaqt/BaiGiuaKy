package com.example.dk.quanlythuchi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DK on 04/03/2018.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<NDThuChi> list;

    public Adapter(Context context, int layout, List<NDThuChi> list) {
        this.context = context;
        Layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(Layout, null);

            holder.hinh = convertView.findViewById(R.id.avt);
            holder.tvND = convertView.findViewById(R.id.tvND);
            holder.tvTien = convertView.findViewById(R.id.tvTien);
            holder.tvHinhThuc = convertView.findViewById(R.id.tvTC);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        NDThuChi object = (NDThuChi) getItem(position);
        if (object.getHinhthuc().equals("thu")) {
            holder.hinh.setImageResource(R.drawable.thu);
        } else {
            holder.hinh.setImageResource(R.drawable.chi);
        }
        holder.tvND.setText(object.getNoidung());
        holder.tvTien.setText(object.getSotien()+"");
        holder.tvHinhThuc.setText("Hình thức: " + object.getHinhthuc());
        return convertView;
    }
    private class ViewHolder {
        ImageView hinh;
        TextView tvND, tvTien, tvHinhThuc;
    }
}


