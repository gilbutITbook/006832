package org.androidtown.study20;

import android.content.Context;
import android.widget.Toast;

public class BMW extends CarPrototype {
	 
	public BMW(Context context) {
		super(context);
	}
	 
	@Override
	public void doRun() {
		Toast.makeText(context, "BMW�� doRun �޼ҵ尡 ȣ��Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
	}
 
}
