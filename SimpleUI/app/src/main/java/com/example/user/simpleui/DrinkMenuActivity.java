package com.example.user.simpleui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class DrinkMenuActivity extends AppCompatActivity {


    String[] names = {"冬瓜紅茶""玫瑰鹽奶蓋紅茶", "珍珠紅茶拿鐵", "紅茶拿鐵"};
    int[] lPrices = {35, 45, 55, 45};
    int[] mPrices = {25, 35, 45, 35};
    int[] imageIds = {R.drawable.drink1, R.drawable.drink2, R.drawable.drink3, R.drawable.drink4};

    private GoogleApiClient client;

    List<Drink> drinkList = new ArrayList();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

        setData();

        drinkMenuListView = (ListView) findViewById(R.id.drinkMenuListView);
        totalTextView = (TextView)findViewById(R.id.)





        Log.d("DEBUG", "DrinkMenuActivity");


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void setData() {
        for (int i = 0; i < names.length; i++) {
            Drink drink = new Drink();
            drink.name = names[i];
            drick.lPrice = lPrices[i];
            drink.mPrice = mPrices[i];
            drink.imageId = imageIds[i];
            drinkList.add(drink);
        }


        @Override
        public void onStart () {
            super.onStart();
            Log.d("DEBUG", "MainActivity OnStart");
        }
        @Override
        protected void onResume () {
            super.onResume();
            Log.d("DEBUG", "MainActivity OnResume");
        }
        @Override
        protected void onPause () {
            super.onPause();
            Log.d("DEBUG", "MainActivity OnPause");
        }
        @Override
        public void onStop () {
            super.onStop();
            Log.d("DEBUG", "MainActivity OnStop");
        }
        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.d("DEBUG", "MainActivity OnDestroy");
        }
        @Override
        public void onRestart () {
            super.onRestart();
            Log.d("DEBUG", "MainActivity OnRestart");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("DEBUG", "MainActivity OnStart");



    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d("DEBUG", "MainActivity OnStop");
    }

    }
}
