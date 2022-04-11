package ro.pub.cs.systems.eim.practicaltest01var05.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ro.pub.cs.systems.eim.practicaltest01var05.R;
import ro.pub.cs.systems.eim.practicaltest01var05.general.Constants;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private Button okButton;
    private Button cancelButton;

    private TextView clickingPatternTextView;

    private ButtonOnClickListener buttonOnClickListener = new ButtonOnClickListener();

    private class ButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        okButton = (Button)findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonOnClickListener);

        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonOnClickListener);

        Intent intent = getIntent();
        clickingPatternTextView = (TextView)findViewById(R.id.clicking_pattern);
        clickingPatternTextView.setText(intent.getStringExtra(Constants.PATTERN));
    }
}