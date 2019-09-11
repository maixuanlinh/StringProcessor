package com.maixuanlinh.stringprocessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultTxv;
    private EditText editText;
    private Button convert;
    private ClipboardManager clipboardManager;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.rawText);
        resultTxv = findViewById(R.id.result);
        convert = findViewById(R.id.convertbtn);
        Button convertToNormal = findViewById(R.id.convertToNormal);
        Button convertForTTS = findViewById(R.id.convertForTTS);
        reset= findViewById(R.id.reset);
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawString = editText.getText().toString();
                String result = "";
                result = rawString.replace("\n", "@");
                resultTxv.setText(result);
                ClipData clipData = ClipData.newPlainText("Result", result);
                clipboardManager.setPrimaryClip(clipData);





            }
        });

        convertToNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawString = editText.getText().toString();
                String result = "";
                result = rawString.replace("@", "\n");
                resultTxv.setText(result);
                ClipData clipData = ClipData.newPlainText("Result", result);
                clipboardManager.setPrimaryClip(clipData);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("Paste");
            }
        });

        convertForTTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawString = editText.getText().toString();
                String result = "";
                result = rawString.replace(":", "... ")
                .replace("(","")
                .replace(")","")
                .replace("~","...")
                .replace("/"," or ")
                .replace("etc.","etc ...");

                resultTxv.setText(result);
                ClipData clipData = ClipData.newPlainText("Result", result);
                clipboardManager.setPrimaryClip(clipData);

            }
        });
    }
}
