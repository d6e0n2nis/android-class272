package com.example.user.simpleui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 2016/8/11.
 */
public class DrinkAdapter extends BaseAdapter {
    list<Drink>







    @Override
    public int getCount() {
        return drinkList.size();
    }

    @Override
    public Object getItem(int position) {
        return drinkLIst.get(position);
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
            convertView = inflater.inflate(R.layout.listview_drink_item,null);
            holder = new Holder();
            holder.drinkNameTextView = (TextView)convertView.findViewById(R, R.id.DrinknameTextView);
            holder.lPriceTextView = (TextView)convertView.findViewById(R.id.lPriceTextViewl);
            holder.mPriceTextView = (TextView)convertView.findViewById(R.id.mPriceTextView);
            holder.imageView = (imageView)convertView.findViewById(R.id.inageTextView);
        }
        else
        {
            holder = (Holder)convertView.getTag();
        }


        Drink drink = drinkList.get(position);
        holder.drinkNameTextView.setText(drink.name);
        holder.mPriceTextView.setText(String.valueOf(drink.mPrice));
        holder.lPriceTextView.setText(String.valueOf(drink.lPrice));




        return null;


    }
    class Holder{
        TextView drinkNameTextView ;
        TextView mPriceTextView;
        ImageView imageView;


    }


}
