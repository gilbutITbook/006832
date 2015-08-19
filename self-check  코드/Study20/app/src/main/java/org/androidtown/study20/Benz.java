package org.androidtown.study20;

import android.content.Context;
import android.widget.Toast;

public class Benz extends CarPrototype {
	 
	public Benz(Context context) {
		super(context);
	}
	 
	@Override
	public void doRun() {
		Toast.makeText(context, "Benz�� doRun �޼ҵ尡 ȣ��Ǿ����ϴ�.", Toast.LENGTH_LONG).show();
	}
 
}
