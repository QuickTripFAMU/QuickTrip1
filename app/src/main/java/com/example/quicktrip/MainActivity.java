package com.example.quicktrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import okhttp3.Headers;


public class MainActivity extends AppCompatActivity {

    public static final String TRAVEL_SEARCH_URL = "https://travel-advisor.p.rapidapi.com/locations/v2/search?currency=USD&units=km&lang=en_US";
    public static final String TRAVEL_RESTURANTS_URL = "https://travel-advisor.p.rapidapi.com/restaurants/v2/list?currency=USD&units=km&lang=en_US";
    public static final String TRAVEL_ATTRACTIONS_URL = "https://travel-advisor.p.rapidapi.com/attractions/v2/list?currency=USD&units=km&lang=en_US";
    public static final String TRAVEL_HOTEL_URL = "https://travel-advisor.p.rapidapi.com/hotels/v2/list?currency=USD&units=km&lang=en_US";
    public static final String TAG = "MainActivity";
    CardView cardView, cardView2, cardView3;
    ImageView imageView;
    TextView textView, textView2, textView3, textView4, textView5;
    SearchView searchView;

    Animation anim_from_button, anim_from_top, anim_from_left;

    @TargetApi(Build.VERSION_CODES.KITKAT)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.firstText);
        textView2 = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView4);
        searchView = findViewById(R.id.searchView);

        // Load Animation
        anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        // Set Animation
        cardView.setAnimation(anim_from_button);
        cardView2.setAnimation(anim_from_button);
        cardView3.setAnimation(anim_from_button);
        imageView.setAnimation(anim_from_top);
        textView.setAnimation(anim_from_top);
        textView2.setAnimation(anim_from_top);
        textView3.setAnimation(anim_from_top);
        textView4.setAnimation(anim_from_top);
        textView5.setAnimation(anim_from_top);
        searchView.setAnimation(anim_from_left);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DetailActivity = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(DetailActivity);
            }
        });




//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(TRAVEL_ATTRACTIONS_URL, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Headers headers, JSON json) {
//                Log.d(TAG, "onSuccess");
//            }
//            @Override
//            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
//                Log.d(TAG, "onFailure");
//            }
//        });




    }
}