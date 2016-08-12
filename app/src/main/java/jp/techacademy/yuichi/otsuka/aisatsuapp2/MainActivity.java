package jp.techacademy.yuichi.otsuka.aisatsuapp2;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mPlaceForAisatsuTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.showTimeDialogButton);
        button1.setOnClickListener(this);

        mPlaceForAisatsuTextView = (TextView) findViewById(R.id.placeForAisatsuTextView);
    }

    @Override
    public void onClick(View v) {
        showTimeDialog();
    }

    private void showTimeDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                String word1 = "";
                if ((hourOfDay >= 2) && (hourOfDay < 10)) {
                    word1 = "おはよう";
                } else if ((hourOfDay >= 10) && (hourOfDay < 18)) {
                    word1 = "こんにちは";
                } else if ((hourOfDay >= 18) && (hourOfDay <= 24)) {
                    word1 = "こんばんは";
                } else if ((hourOfDay >= 0) && (hourOfDay < 2)) {
                    word1 = "こんばんは";
                }
                mPlaceForAisatsuTextView.setText(word1);
            }
        }, 12, 0, true);
        timePickerDialog.show();
    }
}
