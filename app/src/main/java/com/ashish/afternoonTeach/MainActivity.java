package com.ashish.afternoonTeach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgTeaType;
    Spinner sSugarOptions;
    Button bGetMyTea;
    String id;
    TextView tvGreeting;

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity lifecycle", "in onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity lifecycle", "in onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity lifecycle", "in onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("Activity lifecycle", "in onSaveInstanceState");
        outState.putString("message", "This is the message i saved");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activity lifecycle", "in onCreate");

        if(savedInstanceState != null) {
            String message = savedInstanceState.getString("message");
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_main);
        rgTeaType = findViewById(R.id.rgTeaType);
        sSugarOptions = findViewById(R.id.sSugarOptions);
        bGetMyTea = findViewById(R.id.bGetMyTea);
        tvGreeting = findViewById(R.id.tvGreeting);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            id = extras.getString("id", "Tea lover");
        tvGreeting.setText(String.format("Welcome %s", id));

        bGetMyTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedTeaTypeId = rgTeaType.getCheckedRadioButtonId();
                RadioButton rbSelectedTeaType = findViewById(selectedTeaTypeId);
                String selectedTeaType = rbSelectedTeaType.getText().toString();

                String sugarOption = sSugarOptions.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), String.format("You ordered %s with %s sugar", selectedTeaType, sugarOption), Toast.LENGTH_SHORT).show();
            }
        });
    }
}