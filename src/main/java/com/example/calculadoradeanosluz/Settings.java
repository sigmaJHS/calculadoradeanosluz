package com.example.calculadoradeanosluz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Settings extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Intent intent = getIntent();
        if(intent.hasExtra("from") && intent.hasExtra("to")){
            TextView from = (TextView)findViewById(R.id.textView3);
            TextView to = (TextView)findViewById(R.id.textView4);
            to.setText(intent.getStringExtra("to"));
            from.setText(intent.getStringExtra("from"));
        }

    }

    public void save(View view){

        RadioGroup from = (RadioGroup)findViewById(R.id.from);
        RadioGroup to = (RadioGroup)findViewById(R.id.to);

        RadioButton fromV = (RadioButton)findViewById(from.getCheckedRadioButtonId());
        RadioButton toV = (RadioButton)findViewById(to.getCheckedRadioButtonId());

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("from", (String)fromV.getText().toString());
        intent.putExtra("to", (String)toV.getText().toString());

        startActivity(intent);
    }

}
