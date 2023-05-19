package com.rajamrit.localdata;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText name;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.name);
        textView = (TextView) findViewById(R.id.textView);
        String MY_PREF_FILENAME = "com.rajamrit.localdata.data";

        SharedPreferences preferences = getSharedPreferences(MY_PREF_FILENAME, MODE_PRIVATE);
        String get_name = preferences.getString("name", "");
        textView.setText("Hello "+ get_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip_name = name.getText().toString();
                if (ip_name.length() > 0){
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREF_FILENAME, MODE_PRIVATE).edit();
                    editor.putString("name", ip_name);
                    editor.apply();
                    textView.setText("Welcome " + ip_name);
                }else{

                }
            }
        });

    }
}