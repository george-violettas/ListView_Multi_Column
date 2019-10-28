package com.example.parsaniahardik.listview_multi_column;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<FoodModel> foodModelArrayList;

    public FoodAdapter(Context context, ArrayList<FoodModel> foodModelArrayList) {
        this.context = context;
        this.foodModelArrayList = foodModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getCount() {
        return foodModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return foodModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null, true);

            holder.tvProduct = (TextView) convertView.findViewById(R.id.tvProduct);
            holder.tvQty = (TextView) convertView.findViewById(R.id.tvQty);
            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvProduct.setText(foodModelArrayList.get(position).getProduct());
        holder.tvQty.setText(String.valueOf(foodModelArrayList.get(position).getQty()));
        return convertView;
    }

    private class ViewHolder {
        protected TextView tvProduct, tvQty;
    }
}
