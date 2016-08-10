package com.example.user.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2016/8/10.
 */
public class OrderAdapter extends BaseAdapter {

    List<Order> orders;
    LayoutInflater layoutInflater;

    public OrderAdapter(Context context,List<Order> orderList){
        this.orders = orderList;
        this.layoutInflater = LayoutInflater.from(context);
    }




    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;


        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.listview_order_item, null);
            TextView textView2 = (TextView)convertView.findViewById(R.id.textView2);
            TextView textView4 = (TextView)convertView.findViewById(R.id.textView4);
            TextView textView3 = (TextView)convertView.findViewById(R.id.textView3);

            holder = new Holder();

            holder.textView2 = textView2;
            holder.textView4 = textView4;
            holder.textView3 = textView3;

            convertView.setTag(holder);
        }
        else
        {
            holder =(Holder)convertView.getTag();
        }

        Order order = orders.get(position);
        holder.textView2.setText(order.note);
        holder.textView4.setText(order.storeInfo);
        holder.textView3.setText(order.drink);

        return convertView;
    }

    class Holder{
        TextView textView2;
        TextView textView4;
        TextView textView3;
    }
}
