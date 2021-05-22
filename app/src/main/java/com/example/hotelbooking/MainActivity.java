package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView cv, cv2, cv3;
    ImageView iv;
    TextView tv, tv11, tv3, tv4, tv5;
    SearchView searchView;

    Animation anim_from_button, anim_from_top, anim_from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setAnimation();
        onClicked();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );
    }

    public void initViews(){
        cv = findViewById(R.id.cv);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);

        iv = findViewById(R.id.iv);

        tv = findViewById(R.id.tv);
        tv3 = findViewById(R.id.tv2);
        tv4 = findViewById(R.id.tv3);
        tv5 = findViewById(R.id.tv4);
        tv11 = findViewById(R.id.tv11);

        searchView = findViewById(R.id.searchView);

        anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        cv.setAnimation(anim_from_button);
        cv2.setAnimation(anim_from_button);
        cv3.setAnimation(anim_from_button);

        iv.setAnimation(anim_from_top);

        tv.setAnimation(anim_from_top);
        tv3.setAnimation(anim_from_top);
        tv4.setAnimation(anim_from_top);
        tv5.setAnimation(anim_from_top);
        tv11.setAnimation(anim_from_top);
        tv11.setAnimation(anim_from_top);

        searchView.setAnimation(anim_from_left);
    }

    public void onClicked(){
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondActivity);
            }
        });
    }
}