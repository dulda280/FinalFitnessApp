//package dk.seb.sebsfitnessapp;
//
//import android.app.job.JobParameters;
//import android.app.job.JobService;
//import android.os.SystemClock;
//import android.util.Log;
//import android.view.View;
//import android.widget.Chronometer;
//import android.widget.Toast;
//
//
//public class TimerService extends JobService {
//
//    public boolean timer_running;
//    private static final String TAG = "TimerService";
//    private boolean jobCancelled = false;
//
//    Chronometer work_timer;
//    @Override
//    public boolean onStartJob(JobParameters params) {
//        doBackgroundWork(params);
//
//        return true;
//    }
//
//    public void doBackgroundWork(final JobParameters params) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                if(jobCancelled){
//                    return;
//                }
//                try{
//                work_timer = work_timer.findViewById(R.id.work_timer);
//
//                work_timer.setBase(SystemClock.elapsedRealtime());
//                work_timer.start();
//                timer_running = true;
//
//                if(timer_running=false) {
//                    jobFinished(params, false);
//                }
//                } catch (Exception e) {
//                    Log.d("errorTimer","Timer not working");
//                    Toast work_Stop = Toast.makeText(getApplicationContext(), "Timer not working", Toast.LENGTH_SHORT);
//                }
//
//
//            }
//        }).start();
//    }
//
//
//
//    @Override
//    public boolean onStopJob(JobParameters params) {
//
//        jobCancelled = true;
//        return false;
//    }
//
//
//
//
//
//}