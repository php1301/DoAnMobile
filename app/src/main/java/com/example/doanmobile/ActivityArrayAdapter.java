package com.example.doanmobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityArrayAdapter extends ArrayAdapter<Fruit> {
    private static final String TAG = "ActivityArrayAdapter";
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    static class ActivityViewHolder {
        TextView fruitImg;
        TextView fruitName;
        TextView calories;
    }

    public ActivityArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Fruit object) {
        fruitList.add(object);
        super.add(object);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public int getCount() {
        return this.fruitList.size();
    }

    @Override
    public Fruit getItem(int index) {
        return this.fruitList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ActivityViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_activity, parent, false);
            viewHolder = new ActivityViewHolder();
            viewHolder.fruitImg = (TextView) row.findViewById(R.id.time_activity);
            viewHolder.fruitName = (TextView) row.findViewById(R.id.name_activity);
            viewHolder.calories = (TextView) row.findViewById(R.id.text_value);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ActivityViewHolder)row.getTag();
        }
        Fruit fruit = getItem(position);
        viewHolder.fruitImg.setText(fruit.getFruitImg());
        viewHolder.calories.setText(fruit.getCalories());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}