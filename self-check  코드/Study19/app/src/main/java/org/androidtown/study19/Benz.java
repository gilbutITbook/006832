package org.androidtown.study19;

import android.content.Context;
import android.widget.Toast;

public class Benz implements Car {
	Context context;
	
	public Benz(Context context) {
		this.context = context;
	}
	
	@Override
	public void doStart() {
		Toast.makeText(context, "Benz의 doStart 메소드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doRun() {
		Toast.makeText(context, "Benz의 doRun 메소드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doTurn() {
		Toast.makeText(context, "Benz의 doTurn 메소드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

	@Override
	public void doStop() {
		Toast.makeText(context, "Benz의 doStop 메소드가 호출되었습니다.", Toast.LENGTH_LONG).show();
	}

}
