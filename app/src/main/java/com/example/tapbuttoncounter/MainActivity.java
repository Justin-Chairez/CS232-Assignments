package com.example.tapbuttoncounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //1.Reference global data, models, and views
    private Counter count;
    private TextView countView;
    private Button tapBtn;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //2. CREATE THE DATA MODEL
        count = new Counter();

        //3. REFERENCE THE VIEWS
        countView = findViewById(R.id.textView);
        tapBtn = findViewById(R.id.button);

        //4. REGISTER A LISTENER EVEN FOR THE BUTTON - USE A HANDLER
        tapBtn.setOnClickListener(updateCounter);
    }

    //5. HANDLER - updateCounter()
    private final View.OnClickListener updateCounter = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            count.addCount();
            countView.setText(count.getCount().toString());
            Log.i(TAG,"Justin's Count: " + count.getCount().toString());
        }
    };
}
