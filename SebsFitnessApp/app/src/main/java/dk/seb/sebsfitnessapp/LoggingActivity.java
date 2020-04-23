package dk.seb.sebsfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;


public class LoggingActivity extends AppCompatActivity  {

    public int[] logIds;
    public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);

        //Initializing and assigning bottomnavigation-variable.
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //Setting Logging screen to selected
        bottomNavigationView.setSelectedItemId(R.id.logExercises_tab);

        //Selecteditem-listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.logExercises_tab:
                        return true;
                    case R.id.heartRate_tab:
                        startActivity(new Intent(getApplicationContext(),HeartRateActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.homeTab:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });








    }


    protected void onStart (){
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    public void openLogDialog (){


    }


}


