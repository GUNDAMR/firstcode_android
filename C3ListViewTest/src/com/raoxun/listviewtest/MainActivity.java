package com.raoxun.listviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] fruitNameStrings = { "Apple", "Banana", "Orange",
			"Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry",
			"Mango" };

	private int[] fruitLayout = { R.drawable.apple_pic, R.drawable.banana_pic,
			R.drawable.orange_pic, R.drawable.watermelon_pic,
			R.drawable.pear_pic, R.drawable.grape_pic,
			R.drawable.pineapple_pic, R.drawable.strawberry_pic,
			R.drawable.cherry_pic, R.drawable.mango_pic };

	class Fruit {
		private String fruitName;
		private int fruitLayoutId;

		public int getImageId() {
			return fruitLayoutId;
		}

		public void setImageId(int id) {
			fruitLayoutId = id;
		}

		public String getText() {
			return fruitName;
		}

		public void setText(String text) {
			fruitName = text;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<Fruit> fruitList = new ArrayList<Fruit>();
		for (int i = 0; i < fruitNameStrings.length; i++) {
			Fruit fruit = new Fruit();
			fruit.setImageId(fruitLayout[i]);
			fruit.setText(fruitNameStrings[i]);
			fruitList.add(fruit);
		}

		setContentView(R.layout.activity_main);
		FruitAdapter adapter = new FruitAdapter(
				MainActivity.this, R.layout.fruit_layout, fruitList);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String fruitName = fruitNameStrings[position];
				Toast.makeText(MainActivity.this, fruitName, Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}
