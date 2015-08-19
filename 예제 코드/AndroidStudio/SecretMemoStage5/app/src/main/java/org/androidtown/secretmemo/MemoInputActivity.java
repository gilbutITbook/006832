package org.androidtown.secretmemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoInputActivity extends AppCompatActivity {

    // 메모
    EditText editText;
    // 친구이름
    EditText editText2;
    // 친구번호
    EditText editText3;

    // 타이틀
    TextView textView;

    // 일시
    TextView textView2;

    // 이미지뷰
    ImageView imageView;

    // 이미지 비트맵
    Bitmap imageBitmap;

    // 메모 모드
    String mode;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_input);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);

        // 저장 버튼 설정
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String contents = editText.getText().toString();
                String friendName = editText2.getText().toString();
                String friendMobile = editText3.getText().toString();
                String timestamp = textView.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("mode", mode);
                intent.putExtra("contents", contents);
                intent.putExtra("friendName", friendName);
                intent.putExtra("friendMobile", friendMobile);
                intent.putExtra("timestamp", timestamp);
                intent.putExtra("imageBitmap", imageBitmap);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        // 취소 버튼 설정
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // 이미지뷰 터치 시 사진찍기
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1004);
            }
        });


        // 전화 버튼 설정
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String friendMobile = editText3.getText().toString();

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + friendMobile));
                startActivity(intent);
            }
        });

        // 문자 버튼 설정
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String friendMobile = editText3.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("address", friendMobile);
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });


        // 전달된 인텐트 데이터 처리
        Intent intent = getIntent();
        mode = intent.getStringExtra("mode");

        if (mode != null && mode.equals("create")) {
            textView.setText("새 메모");

            Date date = new Date();
            String timestamp = dateFormat.format(date);

            textView2.setText(timestamp);
        } else if (mode.equals("modify")) {
            String contents = intent.getStringExtra("contents");
            String friendName = intent.getStringExtra("friendName");
            String friendMobile = intent.getStringExtra("friendMobile");
            String timestamp = intent.getStringExtra("timestamp");
            Bitmap imageBitmap = intent.getParcelableExtra("imageBitmap");

            textView.setText("메모 수정");

            editText.setText(contents);
            editText2.setText(friendName);
            editText3.setText(friendMobile);
            textView2.setText(timestamp);
            imageView.setImageBitmap(imageBitmap);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1004 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }


}
