package dk.seb.sebsfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HeartRateActivity extends AppCompatActivity implements SensorEventListener {

    boolean step_running = false;
    static int steps = 0;
    boolean clicked = false;
    SensorManager sensorManagerhr;
    SensorManager sensorManagersc;

    TextView stepnumber_view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);

        //Initializing and assigning bottomnavigation-variable.
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //Setting Heart Rate to selected
        bottomNavigationView.setSelectedItemId(R.id.heartRate_tab);

        //Selecteditem-listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.logExercises_tab:
                        startActivity(new Intent(getApplicationContext(), LoggingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.heartRate_tab:
                        return true;

                    case R.id.homeTab:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        sensorManagersc = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManagerhr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        stepnumber_view = (TextView) findViewById(R.id.stepnumber_view);
    }

    @Override
    protected void onResume() {
        super.onResume();



        step_running = true;
        Sensor step_counter_sensor = sensorManagersc.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor heart_rate_sensor = sensorManagerhr.getDefaultSensor(Sensor.TYPE_HEART_RATE);

        if (step_counter_sensor != null) {
            sensorManagersc.registerListener(this, step_counter_sensor, SensorManager.SENSOR_DELAY_NORMAL);
            TextView noSupport = (TextView) findViewById(R.id.noStepSupportView);
            noSupport.setVisibility(View.INVISIBLE);
        } else {
            //if not support
            TextView noSupport = (TextView) findViewById(R.id.noStepSupportView);
            noSupport.setVisibility(View.VISIBLE);

        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        step_running = true;

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (step_running) {
                steps+=1;
                Log.d("Stepcounter",steps + "Steps taken");
                stepnumber_view.setText(String.valueOf(steps));


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public void heart_rate_Toast(View view) {

        CharSequence text_no_heart = "Heart rate sensor not found!";
        Toast heart_not_found = Toast.makeText(getApplicationContext(), text_no_heart, Toast.LENGTH_LONG);
        heart_not_found.show();

    }



}