package com.example.hotelbooking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView back, up;
    TextView title, subtitle, moredetails;
    RatingBar ratingBar;

    Animation from_button, from_right, from_left;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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
        back = findViewById(R.id.second_back_arrow);
        up = findViewById(R.id.seconf_arrow_up);

        title = findViewById(R.id.second_title);
        subtitle = findViewById(R.id.second_subtitle);
        moredetails = findViewById(R.id.more_details);

        ratingBar = findViewById(R.id.second_ratingBar);

        from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        back.setAnimation(from_left);

        title.setAnimation(from_right);
        subtitle.setAnimation(from_right);

        ratingBar.setAnimation(from_left);

        up.setAnimation(from_button);
        moredetails.setAnimation(from_button);
    }

    public void onClicked(){

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdActivity = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(thirdActivity);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent thirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(up, "background_image_transition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondActivity.this, pairs);

                startActivity(thirdActivity, options.toBundle());
            }
        });

    }

}