package com.example.user.orientationproject;

import android.app.Activity;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView textOrientation;
    OrientationEventListener myOrientationEventListener;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textOrientation = (TextView)findViewById(R.id.textorientation);

        myOrientationEventListener
                = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL){

            @Override
            public void onOrientationChanged(int arg0) {
                // TODO Auto-generated method stub=
                if(arg0>70)
                textOrientation.setText("Orientation: Portrait" );
                else
                    textOrientation.setText("Orientation: landscape" );
            }};

        if (myOrientationEventListener.canDetectOrientation()){
            Toast.makeText(this, "Can DetectOrientation", Toast.LENGTH_LONG).show();
            myOrientationEventListener.enable();
        }
        else{
            Toast.makeText(this, "Can't DetectOrientation", Toast.LENGTH_LONG).show();
            finish();
        }


    }

//    @Override
//    protected void onDestroy() {
//        // TODO Auto-generated method stub
//        super.onDestroy();
//        myOrientationEventListener.disable();
//    }
}

