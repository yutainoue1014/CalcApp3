package jp.techacademy.inoue.yuuta.calcapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static jp.techacademy.inoue.yuuta.calcapp.R.id.editText2;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mEditText;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(editText2);

        //エディットの取得
        mEditText = (EditText) findViewById(R.id.editText1);
        mEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEditText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

    }

    @Override
    public void onClick(View v) {
        if (mEditText.getText().toString().equals("")){
            Toast.makeText(this, "数字が未入力です", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mEditText2.getText().toString().equals("")){
            Toast.makeText(this, "数字が未入力です", Toast.LENGTH_SHORT).show();
            return;
        }
        double value1 = Double.parseDouble(String.valueOf(mEditText.getText().toString()));
        double value2 = Double.parseDouble(String.valueOf(mEditText2.getText().toString()));
        double value3 = 0;

        if (v.getId() == R.id.button1) {
            value3 = value1 + value2;
        } else if (v.getId() == R.id.button2) {
            value3 = value1 - value2;
        } else if (v.getId() == R.id.button3) {
            value3 = value1 * value2;
        } else if (v.getId() == R.id.button4) {
            value3 = value1 / value2;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE3", value3);
        startActivity(intent);

    }
}









