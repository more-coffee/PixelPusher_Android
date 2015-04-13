package com.example.cnr.pixelpusher;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {

    private ImageButton settingsBtn;
    private ImageButton infoBtn;
    private ImageButton pixelpusherBtn;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //settingsBtn = (ImageButton) findViewById(R.id.settingsBtn);
        //infoBtn = (ImageButton) findViewById(R.id.infoBtn);
        //pixelpusherBtn = (ImageButton) findViewById(R.id.pixelPusherBtn);


        Integer color1 = getResources().getColor(R.color.red_bg);
        Integer color2 = getResources().getColor(R.color.orange_bg);
        Integer color3 = getResources().getColor(R.color.yellow_bg);
        Integer color4 = getResources().getColor(R.color.green_bg);
        Integer color5 = getResources().getColor(R.color.blue_bg);
        Integer color6 = getResources().getColor(R.color.indigo_bg);

        //Put in double of each color to account for a smooth wrap-around when the color
        //animation repeats.
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), color1, color2,
                color2, color3, color3, color4, color4, color5, color5, color6, color6, color1);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                findViewById(R.id.layout_bg).
                        setBackgroundColor((Integer) animator.getAnimatedValue());
            }

        });
        colorAnimation.setDuration(30000);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.start();

    }


    public void openSettings(View view) {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }


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
