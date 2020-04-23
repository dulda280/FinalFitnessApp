package dk.seb.sebsfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
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

public class MainActivity extends AppCompatActivity {

    public boolean timer_running;
    public Chronometer work_timer;
    TextView timer_textView;
    String timerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing and assigning bottomnavigation-variable.
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //Setting Homescreen to selected
        bottomNavigationView.setSelectedItemId(R.id.homeTab);

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
                        startActivity(new Intent(getApplicationContext(), HeartRateActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.homeTab:
                        return true;
                }
                return false;
            }
        });




        final Button start_work_button = findViewById(R.id.startWorkout_button);
        start_work_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Timer_class Timer = new Timer_class();
//                Timer.run();

                setTimer_running(findViewById(R.id.work_timer));


                workoutToast(findViewById(R.id.Homescreen));
                if(timer_running) {
                    final Button stop_work_button = findViewById(R.id.stopWorkout_button);
                    stop_work_button.setVisibility(View.VISIBLE);
                }
            }
        });

        final Button stop_work_button = findViewById(R.id.stopWorkout_button);
        stop_work_button.setVisibility(View.INVISIBLE);
        stop_work_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setTimer_stop(findViewById(R.id.work_timer));
                stopworkoutToast(findViewById(R.id.Homescreen));
//                stop_work_timer(findViewById(R.id.work_timer));

//                Timer_class Timer = new Timer_class();
//                Timer.stop_work_timer(findViewById(R.id.work_timer));

                stop_work_button.setVisibility(View.INVISIBLE);

            }
        });

        work_timer = findViewById(R.id.work_timer);

//       timer_textView = findViewById(R.id.timer_textview);
//
//        timer_textView.setText(timerValue);

    }

    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

//        if(timer_running){
//
//            Timer_class Timer = new Timer_class();
//            Timer.run();
//        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
//
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("closeTime",findViewById(R.id.work_timer).toString());
//        outState.putBoolean("timer_running",timer_running);
//
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        timerValue = work_timer.toString() + SystemClock.elapsedRealtime();
//
//
//
//    }

    public void workoutToast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Workout started!";
        int duration = Toast.LENGTH_SHORT;

        Toast work_Start = Toast.makeText(context, text, duration);
        work_Start.show();


    }

    public void stopworkoutToast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Workout stopped!";
        int duration = Toast.LENGTH_SHORT;

        Toast work_Stop = Toast.makeText(context, text, duration);
        work_Stop.show();


    }

    public void setTimer_running (View v) {
        if(timer_running) {
            work_timer.setBase(SystemClock.elapsedRealtime());
            work_timer.start();
        }



    }

    public void setTimer_stop (View v) {

        work_timer.stop();
        timer_running = false;
    }

//    public void scheduleTimer(View v){
//        ComponentName timerCompenent = new ComponentName(this, TimerService.class);
//
//        JobInfo timerInfo = new JobInfo.Builder(123,timerCompenent)
//                .setPersisted(true)
//                .setOverrideDeadline(0)
//                .build();
//
//
//        JobScheduler timerScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
//        int infocode = timerScheduler.schedule(timerInfo);
//
//
//    }
//
//    public void cancelTimer(View v){
//        JobScheduler timerScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
//        timerScheduler.cancel(123);
//
//
//    }

//    public void notstartedToast(View v){
//        Context context = getApplicationContext();
//        CharSequence text = "Workout not started!";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast work_not_started = Toast.makeText(context, text, duration);
//        work_not_started.show();
//
//    }


//class Timer_class implements Runnable {
//
//
//
//    Chronometer work_timer = findViewById(R.id.work_timer);
//
//    @Override
//    public void run() {
//        work_timer.setBase(SystemClock.elapsedRealtime());
//        work_timer.start();
//        timer_running = true;
//
//    }
//
//
//    public void stop_work_timer (View v){
//        if (timer_running) {
//            work_timer.stop();
//            timer_running = false;
//
//        }
//    }
//}
//



}



