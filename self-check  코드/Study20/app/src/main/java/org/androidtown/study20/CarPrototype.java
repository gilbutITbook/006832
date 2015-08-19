package org.androidtown.study20;

import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

public abstract class CarPrototype implements Car {
	Context context;
	
	int price;
	
	public static ArrayList<Car> cars = new ArrayList<Car>();
	
	public CarPrototype(Context context) {
		this.context = context;
	}
	
	@Override
	public void doStart() {
		Toast.makeText(context, "CarPrototype�� doStart �޼ҵ尡 ȣ��Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
	}

	@Override
	public abstract void doRun();

	@Override
	public void doTurn() {
		Toast.makeText(context, "CarPrototype�� doTurn �޼ҵ尡 ȣ��Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doStop() {
		Toast.makeText(context, "CarPrototype�� doStop �޼ҵ尡 ȣ��Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
