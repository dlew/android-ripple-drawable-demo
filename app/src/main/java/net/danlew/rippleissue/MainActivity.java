package net.danlew.rippleissue;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    private View mLeftContainer;
    private View mRightContainer;

    private View mLeftButton;
    private View mRightButton;

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
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
