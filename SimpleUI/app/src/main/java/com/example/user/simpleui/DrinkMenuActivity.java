package com.example.user.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DrinkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);
        Log.d("DEBUG", "DrinkMenuActivity");
        @Override
        public void onStart() {
            super.onStart();
            Log.d("DEBUG", "MainActivity OnStart");
        }
            @Override
            protected void onResume() {
                super.onResume();
                Log.d("DEBUG", "MainActivity OnResume");
            }
            @Override
            protected void onPause() {
                super.onPause();
                Log.d("DEBUG", "MainActivity OnPause");
            }
            @Override
            public void onStop() {
                super.onStop();
                Log.d("DEBUG", "MainActivity OnStop");
            }
                @Override
                public void onDestroy() {
                    super.onDestroy();
                    Log.d("DEBUG", "MainActivity OnDestroy");
                }
                    @Override
                    public void onRestart() {
                    super.onRestart();
                     Log.d("DEBUG", "MainActivity OnRestart");
        }
        }
}
