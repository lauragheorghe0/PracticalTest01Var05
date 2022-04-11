package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {
    private Button centerButton;
    private Button topLeftButton;
    private Button topRightButton;
    private Button bottomLeftButton;
    private Button bottomRightButton;

    private RelativeButtonOnClickListener relativeButtonOnClickListener = new RelativeButtonOnClickListener();
    private class RelativeButtonOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);
    }
}