package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordSettingActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    EditText editText2;
    CheckBox checkBox;
    Button button;
    Button button2;

    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_setting);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        // 저장 버튼 설정
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // 두 개 입력상자의 값 비교
                String password1 = editText.getText().toString().trim();
                String password2 = editText2.getText().toString().trim();

                if (!password1.equals(password2)) {
                    Toast.makeText(getApplicationContext(), "입력한 두 개의 비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (mode != null && mode.equals("lock")) {
                    savePasswordUseYn(getApplicationContext(), "Y");
                    savePassword(getApplicationContext(), password1);

                    Toast.makeText(getApplicationContext(), "비밀번호가 설정되었습니다.", Toast.LENGTH_LONG).show();
                    finish();
                } else if (mode.equals("unlock")) {
                    String previousPassword = loadPassword(getApplicationContext());
                    if (password1.equals(previousPassword)) {
                        if (checkBox.isChecked()) {
                            savePasswordUseYn(getApplicationContext(), "N");
                            savePassword(getApplicationContext(), "");

                            Toast.makeText(getApplicationContext(), "비밀번호가 해제되었습니다.", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "비밀번호가 확인되었습니다.", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "비밀번호가 맞지 않습니다.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "알수없는 mode 값 : " + mode, Toast.LENGTH_LONG).show();
                }

            }
        });

        // 취소 버튼 설정
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (mode != null && mode.equals("unlock")) {
                    Intent intent = new Intent();
                    intent.putExtra("mode", "exit");
                    setResult(Activity.RESULT_CANCELED);

                    finish();
                } else {
                    finish();
                }
            }
        });

        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");
        if (mode != null && mode.equals("unlock")) {
            checkBox.setVisibility(View.VISIBLE);

            textView.setText("비밀번호 확인");
            button.setText("확인");
            button2.setText("끝내기");
        } else {
            checkBox.setVisibility(View.GONE);

            textView.setText("비밀번호 설정");
            button.setText("저장");
            button2.setText("취소");
        }

    }


    /**
     * 환경 정보에 비밀번호 저장하기
     */
    public void savePassword(Context context, String password) {
        SharedPreferences preferences = context.getSharedPreferences("environ", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("password", password);
        editor.commit();
    }

    /**
     * 환경 정보에서 비밀번호 가져오기
     */
    public String loadPassword(Context context){
        SharedPreferences preferences = context.getSharedPreferences("environ", 0);

        return preferences.getString("password", "");
    }

    /**
     * 환경 정보에 비밀번호 사용 여부 저장하기
     */
    public void savePasswordUseYn(Context context, String useYn){
        SharedPreferences preferences = context.getSharedPreferences("environ", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("passwordUseYn", useYn);
        editor.commit();
    }

}
