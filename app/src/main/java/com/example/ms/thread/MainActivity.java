package com.example.ms.thread;
;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int x=1;
    TextView textView;
    Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textview);
        start_button = (Button)findViewById(R.id.start_button);
        start_button.setOnClickListener(this);

    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(x==1){
                textView.setText("Nice to meet you");
            }
        }
    };

    @Override
    public void onClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                x=1;
                handler.sendMessage(message);
            }
        }).start();
    }

}
