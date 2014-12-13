package net.danlew.rippleissue;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    private View mLeftContainer;
    private View mRightContainer;

    private View mLeftButton;
    private View mRightButton;

    private MenuItem mFixMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mLeftContainer = findViewById(R.id.left_container);
        mRightContainer = findViewById(R.id.right_container);

        mLeftButton = findViewById(R.id.left_button);
        mLeftButton.setOnClickListener(mOnClickListener);

        mRightButton = findViewById(R.id.right_button);
        mRightButton.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mLeftContainer.setVisibility(v == mLeftButton ? View.GONE : View.VISIBLE);
            mRightContainer.setVisibility(v == mRightButton ? View.GONE : View.VISIBLE);

            // In this case, we know that whichever View is becoming visible, we want it
            // to reset its drawable state; but if you have a button revealing a View
            // (but not hiding itself) you need to be more careful so you don't instantly
            // cancel the ripple animation.
            if (mFixMenuItem.isChecked()) {
                ViewCompat.jumpDrawablesToCurrentState(mLeftContainer);
                ViewCompat.jumpDrawablesToCurrentState(mRightContainer);
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mFixMenuItem = menu.findItem(R.id.toggle_fix);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item == mFixMenuItem) {
            mFixMenuItem.setChecked(!mFixMenuItem.isChecked());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
