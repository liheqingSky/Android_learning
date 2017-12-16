package com.example.a0001_app_leddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean ledStatus = false;
    private Button button = null;
    private CheckBox CheckBoxLed1 = null;
    private CheckBox CheckBoxLed2 = null;
    private CheckBox CheckBoxLed3 = null;
    private CheckBox CheckBoxLed4 = null;


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.led1:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED1 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED1 off", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.led2:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED2 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED2 off", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.led3:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED3 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED3 off", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.led4:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED4 on", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED4 off", Toast.LENGTH_SHORT).show();
                }
                break;
            // TODO: Veggie sandwich
        }
    }



    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ledStatus = !ledStatus;
            if (ledStatus)
            {
                button.setText("ALL ON");
                CheckBoxLed1.setChecked(true);
                CheckBoxLed2.setChecked(true);
                CheckBoxLed3.setChecked(true);
                CheckBoxLed4.setChecked(true);
            }
            else {
                button.setText("ALL OFF");
                CheckBoxLed1.setChecked(false);
                CheckBoxLed2.setChecked(false);
                CheckBoxLed3.setChecked(false);
                CheckBoxLed4.setChecked(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button_id);

        CheckBoxLed1 = (CheckBox) findViewById(R.id.led1);
        CheckBoxLed2 = (CheckBox) findViewById(R.id.led2);
        CheckBoxLed3 = (CheckBox) findViewById(R.id.led3);
        CheckBoxLed4 = (CheckBox) findViewById(R.id.led4);

        //新创建一个类对象MyButtonListener
        button.setOnClickListener(new MyButtonListener());
    }


}
