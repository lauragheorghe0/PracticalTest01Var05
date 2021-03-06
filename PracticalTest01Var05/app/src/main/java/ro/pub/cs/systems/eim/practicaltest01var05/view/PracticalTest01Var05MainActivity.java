package ro.pub.cs.systems.eim.practicaltest01var05.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ro.pub.cs.systems.eim.practicaltest01var05.R;
import ro.pub.cs.systems.eim.practicaltest01var05.general.Constants;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {
    private Button centerButton;
    private Button topLeftButton;
    private Button topRightButton;
    private Button bottomLeftButton;
    private Button bottomRightButton;

    private Button nextActivityButton;

    private int totalClicks;

    private EditText buttonsPressedEditText;

    private RelativeButtonOnClickListener relativeButtonOnClickListener = new RelativeButtonOnClickListener();
    private class RelativeButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            totalClicks++;
            String currentText = buttonsPressedEditText.getText().toString();
            if (!currentText.equals("")) {
                currentText = currentText + ", ";
            }

            switch(view.getId()) {
                case R.id.center_button:
                    buttonsPressedEditText.setText(currentText + "Center");
                    break;
                case R.id.top_left_button:
                    buttonsPressedEditText.setText(currentText + "Top Left");
                    break;
                case R.id.top_right_button:
                    buttonsPressedEditText.setText(currentText + "Top Right");
                    break;
                case R.id.bottom_left_button:
                    buttonsPressedEditText.setText(currentText + "Bottom Left");
                    break;
                case R.id.bottom_right_button:
                    buttonsPressedEditText.setText(currentText + "Bottom Right");
                    break;
                case R.id.next_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                    intent.putExtra(Constants.PATTERN, currentText);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        centerButton = (Button)findViewById(R.id.center_button);
        centerButton.setOnClickListener(relativeButtonOnClickListener);

        topRightButton = (Button)findViewById(R.id.top_right_button);
        topRightButton.setOnClickListener(relativeButtonOnClickListener);

        topLeftButton = (Button)findViewById(R.id.top_left_button);
        topLeftButton.setOnClickListener(relativeButtonOnClickListener);

        bottomLeftButton = (Button)findViewById(R.id.bottom_left_button);
        bottomLeftButton.setOnClickListener(relativeButtonOnClickListener);

        bottomRightButton = (Button)findViewById(R.id.bottom_right_button);
        bottomRightButton.setOnClickListener(relativeButtonOnClickListener);

        buttonsPressedEditText = (EditText)findViewById(R.id.buttons_pressed_edit_text);

        nextActivityButton = (Button)findViewById(R.id.next_activity_button);
        nextActivityButton.setOnClickListener(relativeButtonOnClickListener);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("save", "" + totalClicks);
        outState.putInt("TOTAL_CLICKS", totalClicks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("restore", "" + savedInstanceState.getInt("TOTAL_CLICKS"));
        totalClicks = savedInstanceState.containsKey("TOTAL_CLICKS") ? savedInstanceState.getInt("TOTAL_CLICKS") : 0;

        Toast.makeText(this, "Total clicks: " + totalClicks, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}