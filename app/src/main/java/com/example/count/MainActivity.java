package com.example.count;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private static final String COUNT_VALUE = "count_value";
    private TextView tv;

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        count = savedInstanceState.getInt(COUNT_VALUE,0);
        if(tv != null){
            tv.setText(Integer.toString(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(COUNT_VALUE,count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv_count);
        Button btShowToast = findViewById(R.id.btShowToast);

        btShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"计数功能！",Toast.LENGTH_SHORT).show();
            }
        });

        Button btCount = findViewById(R.id.btCount);
        btCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(Integer.toString(++count));
            }
        });
    }


}