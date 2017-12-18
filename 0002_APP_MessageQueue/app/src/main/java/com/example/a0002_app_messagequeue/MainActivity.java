package com.example.a0002_app_messagequeue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private final String TAG="MessageTest";
    private int ButtonCnt = 0;
    private Thread myThread;
    private MyThread myThread2;
    //缺点：无法扩展更多的线程函数
    class MyRunable implements Runnable {
        @Override
        public void run() {
            int count = 0;
            for (;;) {
                Log.d(TAG, "MyThread "+count);
                count++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            int count = 0;
            for (;;) {
                Log.d(TAG, "MyThread2 "+count);
                count++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button_id);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Log.d(TAG, "Send Message "+ ButtonCnt);
                ButtonCnt++;
            }
        });

        myThread = new Thread(new MyRunable(), "MessageTestThread");
        myThread.start();

        myThread2 = new MyThread();
        myThread2.start();
    }
}
