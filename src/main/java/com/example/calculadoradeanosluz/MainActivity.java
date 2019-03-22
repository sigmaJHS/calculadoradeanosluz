package com.example.calculadoradeanosluz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent.hasExtra("v")) {
            TextView t = (TextView) findViewById(R.id.textView2);
            double v = Double.parseDouble(intent.getStringExtra("v"));

            v = v / 9500000000000L;

            t.setText("Aproximadamente " + Double.toString(v) + " anos-luz");
        }

    }

    public void calculate(View view) {
        EditText i = (EditText) findViewById(R.id.editText);
        String v = (String) i.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("v", v);
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}
