package ua.edu.sumdu.helloconstraint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mTxtShowCount;
    private Button mBtnZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtShowCount = findViewById(R.id.txt_show_count);
        mBtnZero = findViewById(R.id.btn_zero);

        updateCount();
    }

    public void showToast(View view) {
        Toast.makeText(
                this,
                R.string.toast_message,
                Toast.LENGTH_SHORT
        ).show();
    }

    public void countUp(View view) {
        mCount++;
        updateCount();
    }


    public void toZero(View view) {
        mCount = 0;
        updateCount();
    }

    private void updateCount() {
        if (mTxtShowCount != null) {
            mTxtShowCount.setText(String.format("%d", mCount));
        }
        if (mBtnZero != null) {
            mBtnZero.setEnabled(mCount > 0);

            mBtnZero.getBackground().setTint(
                    getColor(mCount % 2 == 0
                            ? Constants.COLOR_EVEN
                            : Constants.COLOR_ODD
                    )
            );
        }
    }
}