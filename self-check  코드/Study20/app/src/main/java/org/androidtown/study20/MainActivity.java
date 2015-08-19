package org.androidtown.study20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout1;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        editText1 = (EditText) findViewById(R.id.editText1);
    }

    public void onButton1Clicked(View v) {
        int price = getPrice();

        Benz benz = new Benz(this);
        benz.setPrice(price);
        CarPrototype.cars.add(benz);

        Toast.makeText(getApplicationContext(), "Benz 구매함.", Toast.LENGTH_LONG).show();

        addToLayout();
    }

    public void onButton2Clicked(View v) {
        int price = getPrice();

        BMW bmw = new BMW(this);
        bmw.setPrice(price);
        CarPrototype.cars.add(bmw);

        Toast.makeText(getApplicationContext(), "BMW 구매함.", Toast.LENGTH_LONG).show();

        addToLayout();
    }

    private int getPrice() {
        String priceStr = editText1.getText().toString();
        int price = 0;
        try {
            price = Integer.parseInt(priceStr);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return price;
    }

    private void addToLayout() {
        Button button = new Button(this);
        button.setTag((CarPrototype.cars.size()-1));
        button.setText("Car " + CarPrototype.cars.size());
        button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button curButton = (Button) v;
                int index = ((Integer)curButton.getTag()).intValue();
                Car curCar = CarPrototype.cars.get(index);
                int price = curCar.getPrice();

                if (curCar instanceof Benz) {
                    Toast.makeText(getApplicationContext(), "지금 선택하신 차는 Benz 차종이고 가격은 " + price + "만원입니다.", Toast.LENGTH_LONG).show();
                } else if (curCar instanceof BMW) {
                    Toast.makeText(getApplicationContext(),"지금 선택하신 차는 BMW 차종이고 가격은 " + price + "만원입니다.", Toast.LENGTH_LONG).show();
                }
            }

        });

        linearLayout1.addView(button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
