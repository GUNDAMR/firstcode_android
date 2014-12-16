package com.raoxun.listviewtest;

import java.util.List;

import com.raoxun.listviewtest.MainActivity.Fruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {

	private int resourceId;

	public FruitAdapter(Context context, int textViewResourceId,
			List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Fruit item = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			ImageView fruitImageView = (ImageView) view
					.findViewById(R.id.fruit_image);
			TextView fruitTextView = (TextView) view
					.findViewById(R.id.fruit_name);
			viewHolder.fruitImageView = fruitImageView;
			viewHolder.fruitTextView = fruitTextView;
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}

		viewHolder.fruitImageView.setImageResource(item.getImageId());
		viewHolder.fruitTextView.setText(item.getText());
		return view;
	}

	class ViewHolder {
		ImageView fruitImageView;
		TextView fruitTextView;
	}
}
