package com.example.litlites;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdaptor extends ArrayAdapter {

    private Activity mContext;
    List<Stocks> stocksList;


    public ListAdaptor(Activity mContext, List<Stocks> stocksList) {
        super(mContext, R.layout.list_items, stocksList);
        this.mContext = mContext;
        this.stocksList = stocksList;
    }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = mContext.getLayoutInflater();
            View listItemview = inflater.inflate(R.layout.list_items,null,true);

            TextView tvCode = listItemview.findViewById(R.id.tvcode);
            TextView tvName = listItemview.findViewById(R.id.tvname);
            TextView tvTypes = listItemview.findViewById(R.id.tvtypes);
            TextView tvWatt = listItemview.findViewById(R.id.tvwatt);
            TextView tvQty = listItemview.findViewById(R.id.tvqty);
            TextView tvRates = listItemview.findViewById(R.id.tvrates);

            Stocks stocks = stocksList.get(position);

            tvCode.setText(stocks.getCode());
            tvName.setText(stocks.getIname());
            tvTypes.setText(stocks.getTypes());
            tvWatt.setText(stocks.getWatt());
            tvQty.setText(stocks.getQty());
            tvRates.setText(stocks.getRates());

            return listItemview;


        }


}
